<script setup lang="ts">
/**
 * A row of availability capsules for one API member, as emitted by the
 * doclet's inline `:api-badges{...}` tag. MDC passes booleans as strings,
 * so "true" is the presence test.
 */
const props = defineProps<{
  since?: string
  mc?: string
  loader?: string
  permission?: string
  experimental?: string
}>()

const visible = computed(() =>
  !!(props.since || props.mc || props.loader || props.permission || props.experimental === 'true'),
)
</script>

<template>
  <div v-if="visible" class="not-prose my-2 flex flex-wrap items-center gap-1.5">
    <ApiBadge v-if="since" kind="since" :value="since" size="sm" />
    <ApiBadge v-if="mc" kind="mc" :value="mc" size="sm" />
    <ApiBadge v-if="loader" kind="loader" :value="loader" size="sm" />
    <ApiBadge v-if="permission" kind="permission" :value="permission" size="sm" />
    <ApiBadge v-if="experimental === 'true'" kind="experimental" size="sm" />
  </div>
</template>
