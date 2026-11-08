#!/usr/bin/env node
// Generates public/update/updates.json — the update-check manifest the mod
// fetches (the contract lives in the mod repository's docs/releasing.md).
// Sources every release of tuanzisama/NeoMacros from the GitHub API:
//   - a v* tag names the release channel (newest non-prerelease wins);
//   - the rolling "dev"/"canary" prerelease tags name those channels.
// Asset sha256 digests come from the API's `digest` field when present.
// Runs in CI (where GitHub is reachable) before the site build so the
// manifest deploys with the site; locally it needs GITHUB_TOKEN for a
// sane rate limit. The output is never committed (public/ generated trees
// are deploy-time artifacts, matching the docs pipeline's no-commit rule).
import { mkdirSync, writeFileSync } from 'node:fs'
import { dirname, resolve } from 'node:path'

const REPO = process.env.NEOMACROS_REPO ?? 'tuanzisama/NeoMacros'
const OUT = process.env.UPDATES_OUT ?? resolve('public/update/updates.json')
const TOKEN = process.env.GITHUB_TOKEN ?? ''

const assetPattern = /^neomacros-(.+)-fabric-(.+)\.jar$/
const channels = ['release', 'dev', 'canary']

async function main() {
  const releases = await fetchJson(`/repos/${REPO}/releases?per_page=30`)
  const byChannel = {}
  for (const release of releases) {
    const tag = release.tag_name ?? ''
    let channel = null
    if (tag === 'dev' || tag === 'canary') {
      channel = tag
    } else if (!release.prerelease && /^v\d/.test(tag)) {
      // Newest-first list: the first v* non-prerelease entry is the
      // current release channel head.
      channel = 'release'
    }
    if (!channel || byChannel[channel]) {
      continue
    }
    const info = readChannel(release)
    if (info) {
      byChannel[channel] = info
    }
  }

  const manifest = {
    schema: 1,
    updated: new Date().toISOString(),
    channels: byChannel,
  }
  mkdirSync(dirname(OUT), { recursive: true })
  writeFileSync(OUT, JSON.stringify(manifest, null, 2) + '\n')
  const summary = channels.filter(c => byChannel[c]).join(', ') || 'no channels'
  console.log(`updates.json -> ${OUT} (${summary})`)
}

/** Derives one channel entry from the release's parseable mod-jar assets. */
function readChannel(release) {
  const assets = (release.assets ?? []).filter(a => assetPattern.test(a.name ?? ''))
  if (assets.length === 0) {
    return null
  }
  const version = assets[0].name.match(assetPattern)[2]
  const build = Number(version.match(/-(?:dev|canary)\.(\d+)/)?.[1] ?? 0)
  return {
    version,
    build,
    date: release.published_at ?? '',
    notes: release.html_url ?? '',
    files: assets.map(a => ({
      mc: a.name.match(assetPattern)[1],
      url: a.browser_download_url,
      sha256: digest(a),
    })),
  }
}

function digest(asset) {
  return typeof asset.digest === 'string' && asset.digest.startsWith('sha256:')
    ? asset.digest.slice('sha256:'.length)
    : ''
}

async function fetchJson(path) {
  const response = await fetch(`https://api.github.com${path}`, {
    headers: {
      Accept: 'application/vnd.github+json',
      'User-Agent': 'neomacros-docs',
      ...(TOKEN ? { Authorization: `Bearer ${TOKEN}` } : {}),
    },
  })
  if (!response.ok) {
    throw new Error(`GitHub API ${path} -> ${response.status}`)
  }
  return response.json()
}

main().catch(error => {
  console.error(error)
  process.exit(1)
})
