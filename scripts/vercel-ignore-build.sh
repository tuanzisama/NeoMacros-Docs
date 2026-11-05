#!/usr/bin/env bash
# Vercel Ignored Build Step: exit 0 skips the build, exit 1 proceeds.
#
# The Vercel Git integration deploys every push to master, but only some
# commits affect the served site. Builder changes, workflow edits, and
# other pipeline-only commits deploy nothing new and are skipped; the
# docs workflow's regeneration commits only ever land when the content
# tree drifted, so those (and any hand-written content edits) build.
#
# A failed diff (no parent commit on the first revision, broken ref)
# must not skip the build, hence the || exit 1.
git diff --quiet HEAD^ HEAD -- \
  content \
  server \
  app \
  public \
  nuxt.config.ts \
  tsconfig.json \
  package.json \
  package-lock.json \
  vercel.json \
  || exit 1

exit 0
