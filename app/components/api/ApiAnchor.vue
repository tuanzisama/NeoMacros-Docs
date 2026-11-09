<script setup lang="ts">
/**
 * Invisible deep-link target for hand-written pages: the markdown pipeline
 * strips raw HTML (`<a id="...">`) and lacks `{#id}` heading anchors, so
 * glossary entries expose stable targets via `:api-anchor{id="..."}`.
 * Renders an empty block-level span right above the heading it names.
 */
defineProps<{
  /** Anchor id, e.g. `kind-handle` for the glossary's Handle entry. */
  id: string
}>()
</script>

<template>
  <span :id="id" aria-hidden="true" class="block" />
</template>
