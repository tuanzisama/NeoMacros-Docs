#!/usr/bin/env bash
# Hides the generated API pages from local git status and commits
# (skip-worktree), so debugging locally never stages the synced md churn.
#
# The files stay tracked: CI's docs workflow keeps committing their
# updates, and Vercel keeps building them from the repository. Local
# edits/regeneration become invisible to git until you undo this with:
#   git update-index --no-skip-worktree <path>
#
# Re-run after pulling newly generated pages (new modules/events arrive as
# fresh tracked files without the flag). Inspect current flags with:
#   git ls-files -v content | grep '^S'
set -euo pipefail
cd "$(dirname "$0")/.."

paths="$(git ls-files -- \
  'content/*/3.api/*' \
  'content/*/3.api/*/*' \
  'content/*/3.api/*/*/*' \
  'content/*/3.api/*/*/*/*' \
  'server/assets/neomacros.d.ts' \
  | grep -v '00.overview.md')"

if [[ -z "$paths" ]]; then
  echo "no tracked generated pages found (fresh clone? run scripts/sync-generated-docs.sh first)" >&2
  exit 1
fi

# shellcheck disable=SC2086
git update-index --skip-worktree $paths
echo "skip-worktree set for $(echo "$paths" | wc -l) generated file(s);"
echo "hand-written 00.overview.md stays fully tracked."
