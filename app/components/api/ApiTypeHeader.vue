<script setup lang="ts">
/**
 * Header block for event payload type pages, fed by the doclet's
 * `::api-type-header{...}` block: the fixed `extends BaseEvent` signature
 * (linked via the `#extends` markdown slot) and the "Raised by" link back
 * to the event page (`#raised-by` slot).
 */
defineProps<{
  since?: string
  mc?: string
  loader?: string
}>()

const { labels } = useApiLabels()
</script>

<template>
  <div class="not-prose my-4">
    <div class="rounded-lg border border-(--ui-border) bg-(--ui-bg-elevated)/50 px-4 py-3 font-mono text-sm leading-relaxed">
      <div class="flex flex-wrap items-center gap-2 [&>p]:m-0 [&>p]:inline [&_a]:font-medium [&_a]:text-(--ui-primary) [&_a:hover]:underline">
        <UBadge color="secondary" variant="subtle" size="sm">{{ labels.kinds.event }}</UBadge>
        <span class="text-(--ui-text-dimmed)">extends</span><slot name="extends" />
      </div>
      <div
        v-if="$slots['raised-by']"
        class="mt-1.5 font-sans text-sm [&>p]:m-0 [&>p]:inline [&_a]:font-medium [&_a]:text-(--ui-primary) [&_a:hover]:underline"
      >
        <span class="mr-1.5 text-(--ui-text-muted)">{{ labels.raisedBy }}:</span><slot name="raised-by" />
      </div>
    </div>
    <ApiBadges class="mt-2" :since="since" :mc="mc" :loader="loader" />
  </div>
</template>
