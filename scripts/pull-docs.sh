#!/usr/bin/env bash
# Safe pull for a tree where CI owns the generated API docs (docs.yml
# commits them) while local regeneration output is hidden from git via
# skip-worktree (skip-generated.sh).
#
# A bare `git pull` breaks in this setup: the merge machinery refuses to
# update a path whose on-disk content differs from the index, even when
# skip-worktree hides that difference from `git status` — every CI regen
# commit touches nearly every generated page, so pulls error out with
# "Your local changes ... would be overwritten by merge" (and the
# collision can silently strip some skip-worktree flags along the way).
#
# This script performs the safe dance instead:
#   1. unset every skip-worktree flag so git sees the real worktree;
#   2. discard local modifications ONLY in regenerable paths (generated
#      API pages + the served .d.ts) — hand-written content (00.overview,
#      guide/, examples/) is never touched;
#   3. git-clean untracked pages under the generated API trees (they are
#      pure regen output; a pull cannot start while one collides with a
#      file the remote added);
#   4. pull --rebase;
#   5. re-run skip-generated.sh (covers files the pull just brought in).
#
# With `--regen`, it then rebuilds the docs from the local mod sources
# (gradle + sync + re-mark) so local dev keeps showing locally-generated
# pages that the remote does not have yet.
#
# Usage: bash scripts/pull-docs.sh [--regen]
set -euo pipefail
cd "$(dirname "$0")/.."

# Regenerable pathspecs: everything the doclet/sync pipeline owns. The
# hand-written 00.overview.md pages are filtered out below.
gen_paths=(
  content/en/3.api
  content/zh-cn/3.api
  server/assets/neomacros.d.ts
)

echo "==> unsetting skip-worktree flags"
git ls-files -v content server \
  | grep '^S ' \
  | awk '{print $2}' \
  | xargs -r git update-index --no-skip-worktree

echo "==> discarding regenerable local changes (hand-written pages kept)"
dirty="$(git status --porcelain -- "${gen_paths[@]}" \
  | awk '$1 == "M" || $1 == "MM" {print $2}' \
  | grep -v '00\.overview\.md' || true)"
if [[ -n "$dirty" ]]; then
  printf '   %s\n' $dirty | head -10
  count="$(printf '%s\n' $dirty | wc -l)"
  [[ "$count" -gt 10 ]] && echo "   ... and $((count - 10)) more"
  # shellcheck disable=SC2086
  git checkout -- $dirty
else
  echo "   none"
fi

echo "==> cleaning untracked pages under the generated API trees"
git clean -f content/en/3.api content/zh-cn/3.api

echo "==> pulling"
git pull --rebase origin master

echo "==> re-applying skip-worktree flags"
bash scripts/skip-generated.sh

if [[ "${1:-}" == "--regen" ]]; then
  echo "==> regenerating API docs from local mod sources"
  ./gradlew -p builder generateApiDocs --console=plain
  bash scripts/sync-generated-docs.sh
  bash scripts/skip-generated.sh
  echo "==> done (local pages rebuilt; untracked local-only pages are expected)"
else
  echo "==> done (run 'bash scripts/pull-docs.sh --regen' to rebuild local pages from ../neomacros)"
fi
