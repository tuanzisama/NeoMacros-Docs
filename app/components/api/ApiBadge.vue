<script setup lang="ts">
/**
 * One capsule badge of the API reference. The generated MDC pages pass
 * raw data only (kind + availability value); the semantic color, icon
 * and localized wording are resolved here. An availability wildcard ("*")
 * renders as a calm "all versions" capsule, while a concrete expression
 * (e.g. ">=1.20.6") renders as an amber warning.
 *
 * The optional {@code tooltip} prop overrides the kind's default detail
 * shown on hover (UTooltip). The writable kind carries a default detail
 * from the label table, so the sync-channel semantics stay one hover away.
 */
const props = withDefaults(defineProps<{
  kind: 'since' | 'mc' | 'loader' | 'permission' | 'experimental' | 'cancellable' | 'readonly' | 'writable'
  value?: string
  size?: 'xs' | 'sm' | 'md'
  tooltip?: string
}>(), { size: 'xs' })

const { labels } = useApiLabels()

const capsule = computed(() => {
  const wildcard = !props.value || props.value === '*'
  switch (props.kind) {
    case 'since':
      return { label: labels.value.since, value: props.value, color: 'neutral', icon: 'i-lucide-clock', mono: false }
    case 'mc':
      return {
        label: labels.value.mc,
        value: wildcard ? labels.value.mcAll : props.value,
        color: wildcard ? 'neutral' : 'warning',
        icon: 'i-lucide-box',
        mono: false,
      }
    case 'loader':
      return {
        label: labels.value.loader,
        value: wildcard ? labels.value.loaderAll : props.value,
        color: wildcard ? 'neutral' : 'warning',
        icon: 'i-lucide-layers',
        mono: false,
      }
    case 'permission':
      return { label: labels.value.permission, value: props.value, color: 'secondary', icon: 'i-lucide-key-round', mono: true }
    case 'experimental':
      return { label: labels.value.experimental, value: '', color: 'warning', icon: 'i-lucide-flask-conical', mono: false }
    case 'cancellable':
      return { label: labels.value.cancellable, value: '', color: 'info', icon: 'i-lucide-shield', mono: false }
    case 'readonly':
      return { label: labels.value.readonly, value: '', color: 'neutral', icon: 'i-lucide-lock', mono: false }
    case 'writable':
      return { label: labels.value.writable, value: '', color: 'primary', icon: 'i-lucide-pen-line', mono: false }
  }
})

/**
 * Hover detail precedence: the explicit MDC prop wins, the writable kind
 * falls back to its label-table detail, other kinds carry no hover detail.
 */
const tooltipText = computed(() => {
  if (props.tooltip) {
    return props.tooltip
  }
  return props.kind === 'writable' ? labels.value.writableTooltip : null
})
</script>

<template>
  <UTooltip v-if="tooltipText" :text="tooltipText">
    <UBadge :color="capsule.color" variant="subtle" :size="size" :icon="capsule.icon" class="gap-1 font-normal cursor-help">
      <span class="opacity-70">{{ capsule.label }}</span>
      <span v-if="capsule.value" :class="capsule.mono ? 'font-mono' : 'opacity-90'">{{ capsule.value }}</span>
    </UBadge>
  </UTooltip>
  <UBadge v-else :color="capsule.color" variant="subtle" :size="size" :icon="capsule.icon" class="gap-1 font-normal">
    <span class="opacity-70">{{ capsule.label }}</span>
    <span v-if="capsule.value" :class="capsule.mono ? 'font-mono' : 'opacity-90'">{{ capsule.value }}</span>
  </UBadge>
</template>
