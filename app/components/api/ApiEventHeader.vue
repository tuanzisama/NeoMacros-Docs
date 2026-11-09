<script setup lang="ts">
/**
 * Header block for event pages, fed by the doclet's
 * `::api-event-header{...}` block: the event name in mono with a kind
 * chip and optional Cancellable badge, plus the payload link arriving
 * through the `#payload` markdown slot (so sync link rewrites apply).
 */
defineProps<{
  event?: string
  cancellable?: string
  since?: string
  mc?: string
  loader?: string
}>()

const { labels, glossaryHref } = useApiLabels()
</script>

<template>
  <div class="not-prose my-4">
    <div class="rounded-lg border border-(--ui-border) bg-(--ui-bg-elevated)/50 px-4 py-3">
      <div class="flex flex-wrap items-center gap-2 font-mono text-sm">
        <NuxtLink
          :to="glossaryHref('event')"
          class="inline-flex rounded-(--ui-radius) transition-opacity hover:opacity-80"
          :title="labels.kinds.event"
        >
          <UBadge color="secondary" variant="subtle" size="sm">{{ labels.kinds.event }}</UBadge>
        </NuxtLink>
        <span v-if="event" class="font-mono font-semibold text-(--ui-text-highlighted)">{{ event }}</span>
        <ApiBadge v-if="cancellable === 'true'" kind="cancellable" size="sm" />
      </div>
      <div
        v-if="$slots.payload"
        class="mt-1.5 text-sm [&>p]:m-0 [&>p]:inline [&_a]:font-medium [&_a]:text-(--ui-primary) [&_a:hover]:underline"
      >
        <span class="mr-1.5 text-(--ui-text-muted)">{{ labels.payload }}:</span><slot name="payload" />
      </div>
    </div>
    <ApiBadges class="mt-2" :since="since" :mc="mc" :loader="loader" />
  </div>
</template>
