<script setup lang="ts">
/**
 * Header block for facade module pages, fed by the doclet's inline
 * `:api-module-header{...}` tag: a localized category chip, the global
 * exposure line (`neo.x` as a code chip) and the availability capsule row.
 */
defineProps<{
  category?: string
  neoName?: string
  since?: string
  mc?: string
  loader?: string
}>()

const { labels } = useApiLabels()
</script>

<template>
  <div class="not-prose my-4 flex flex-col gap-2">
    <div class="flex flex-wrap items-center gap-2">
      <UBadge v-if="category" color="primary" variant="subtle" size="sm">{{ category }}</UBadge>
      <span v-if="neoName" class="flex flex-wrap items-center gap-1.5 text-sm text-(--ui-text-muted)">
        {{ labels.exposedAs }}
        <code class="rounded bg-(--ui-bg-elevated) px-1.5 py-0.5 font-mono text-xs text-(--ui-text-highlighted)">{{ neoName }}</code>
      </span>
    </div>
    <ApiBadges :since="since" :mc="mc" :loader="loader" />
  </div>
</template>
