<script setup lang="ts">
/**
 * Javadoc-style declaration box for class/type pages, fed by the
 * doclet's `::api-declaration{...}` block. Plain data arrives as props;
 * inheritance links travel in markdown slots (`#extends`, `#extended-by`)
 * so the sync script's link rewrites keep applying to them. Slot content
 * renders as markdown blocks, hence the inline/margin-neutralizing deep
 * utilities.
 */
const props = defineProps<{
  kind?: 'handle' | 'data' | 'record' | 'event'
  name?: string
  /** Script-facing constructor signature when the class is constructible (`new Name(...)`). */
  ctor?: string
  /** Fully-qualified Java class this script type wraps (handle kinds). */
  wraps?: string
}>()

const { labels, glossaryHref } = useApiLabels()

const kindColor = {
  handle: 'primary',
  data: 'info',
  record: 'neutral',
  event: 'secondary',
} as const

const linkSlotClass = '[&>p]:m-0 [&>p]:inline [&_a]:font-medium [&_a]:text-(--ui-primary) [&_a:hover]:underline'
</script>

<template>
  <div class="not-prose my-4">
    <div class="overflow-hidden rounded-lg border border-(--ui-border) bg-(--ui-bg-elevated)/50 px-4 py-3 font-mono text-sm leading-relaxed">
      <div class="flex flex-wrap items-center gap-2">
        <NuxtLink
          v-if="kind"
          :to="glossaryHref(kind)"
          class="inline-flex rounded-(--ui-radius) transition-opacity hover:opacity-80"
          :title="labels.kinds[kind]"
        >
          <UBadge :color="kindColor[kind]" variant="subtle" size="sm">{{ labels.kinds[kind] }}</UBadge>
        </NuxtLink>
        <UBadge v-if="ctor" color="warning" variant="subtle" size="sm">{{ labels.constructible }}</UBadge>
        <span v-if="name" class="font-mono text-base font-semibold text-(--ui-text-highlighted)">{{ name }}</span>
      </div>
      <div v-if="ctor" class="mt-1.5 truncate font-mono text-xs text-(--ui-text-muted)" :title="ctor">{{ ctor }}</div>
      <div v-if="$slots.extends" :class="linkSlotClass" class="mt-1.5">
        <span class="mr-1.5 text-(--ui-text-dimmed)">extends</span><slot name="extends" />
      </div>
      <div v-if="wraps" class="mt-1.5 truncate" :title="wraps">
        <span class="mr-1.5 text-(--ui-text-dimmed)">wraps</span><span class="text-(--ui-text-muted)">{{ wraps }}</span>
      </div>
    </div>
    <div v-if="$slots['extended-by']" :class="linkSlotClass" class="mt-2 text-sm">
      <span class="mr-1.5 font-medium text-(--ui-text-muted)">{{ labels.extendedBy }}:</span><slot name="extended-by" />
    </div>
  </div>
</template>
