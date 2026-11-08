<script setup lang="ts">
/**
 * Card wrapper for one API method entry, fed by the doclet's `::api-method`
 * block tag. The slot carries the markdown body: the `###` signature (kept
 * as a real heading so the TOC and anchor links keep working), description,
 * parameter/returns prose and the trailing availability badges, which the
 * deep styles below turn into the card's meta footer whenever nothing
 * follows them (per-method zh examples still flow past a plain badge row).
 */
</script>

<template>
  <div class="api-method my-6 overflow-hidden rounded-lg border border-(--ui-border) bg-(--ui-bg)">
    <slot />
  </div>
</template>

<style scoped>
/* Signature strip: the h3 turns into a full-bleed header band. The prose
   base (text-xl mt-8 mb-3) is replaced entirely; scroll-mt from the theme
   is kept so anchor jumps clear the sticky header. */
.api-method :deep(h3) {
  margin: 0;
  padding: 0.625rem 1rem;
  /* A faint primary wash reads as "method" at a glance; --ui-primary flips
     with the theme, so the tint stays light in light and dark mode. */
  background: color-mix(in oklab, var(--ui-primary) 9%, var(--ui-bg));
  border-bottom: 1px solid var(--ui-border);
  font-family: var(--font-mono), ui-monospace, SFMono-Regular, Menlo, Consolas, monospace;
  font-size: 1rem;
  line-height: 1.5;
  font-weight: 600;
  color: var(--ui-text-highlighted);
}

/* Signature text: strip the prose code chip (dashed border, size bump) so
   the signature reads as plain mono in the band; keep the primary hover. */
.api-method :deep(h3 a code) {
  border: none;
  border-radius: 0;
  padding: 0;
  background: transparent;
  font-size: inherit;
  line-height: inherit;
  font-weight: inherit;
  color: inherit;
}

.api-method :deep(h3 a:hover code),
.api-method :deep(h3 a:focus-visible code) {
  color: var(--ui-primary);
}

/* Park the hover # anchor inside the strip's right edge; the prose theme
   positions it off the h3's left edge, where the card would clip it. */
.api-method :deep(h3 a > span:first-child) {
  top: 50%;
  translate: 0 -50%;
  inset-inline-end: 0.375rem;
  inset-inline-start: auto;
  margin: 0;
}

/* Body gutters: everything below the strip gets side padding; the first
   paragraph sits closer to the band than the prose default. */
.api-method :deep(> *:not(h3)) {
  margin-inline: 1.25rem;
}

.api-method :deep(h3 + *) {
  margin-top: 0.875rem;
}

/* Trailing breathing room; direct child only — a descendant selector would
   leak into UBadge internals and stretch the footer capsules. */
.api-method :deep(> :last-child) {
  margin-bottom: 0.875rem;
}

/* Availability badges close the card as a meta footer band whenever they
   are the last element of the block. */
.api-method :deep(> .not-prose:last-child) {
  margin: 0.5rem 0 0;
  padding: 0.5rem 1.25rem;
  border-top: 1px solid var(--ui-border);
  background: color-mix(in oklab, var(--ui-bg-elevated) 30%, var(--ui-bg));
}
</style>
