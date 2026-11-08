<script setup lang="ts">
/**
 * Inline type-expression chip, fed by the doclet's `:api-type` tag: one
 * code capsule wrapping the whole TS expression, with the documented types
 * referenced inside it kept clickable. `text` is the expression — pipes
 * arrive escaped as `\|` because the markdown table parser splits cells on
 * unescaped ones. `refs` is a comma list of `Name=classes/<lowercase>`
 * pairs; every referenced page lives under Classes & types, so the link
 * is resolved against the locale's /api root (a bare relative href would
 * misparse on trailing-slash URLs).
 */
const props = defineProps<{
  text?: string
  refs?: string
}>()

const { locale } = useI18n()

const segments = computed(() => {
  const raw = (props.text ?? '').replace(/\\\|/g, '|')
  const links = new Map<string, string>()
  for (const pair of (props.refs ?? '').split(',')) {
    const eq = pair.indexOf('=')
    if (eq > 0) {
      links.set(pair.slice(0, eq), pair.slice(eq + 1))
    }
  }
  const names = [...links.keys()].sort((a, b) => b.length - a.length)
  if (!names.length || !raw) {
    return [{ text: raw }]
  }
  const escaped = names.map(name => name.replace(/[.*+?^${}()|[\]\\]/g, '\\$&'))
  return raw.split(new RegExp(`(${escaped.join('|')})`, 'g'))
    .filter(part => part !== '')
    .map(part => ({ text: part, to: links.get(part) }))
})
</script>

<template>
  <code
    class="api-type inline-block rounded-md border border-(--ui-border-muted) bg-(--ui-bg-muted) px-1.5 py-0.5 text-sm font-mono font-medium text-(--ui-text-highlighted)"
  >
    <template v-for="(segment, index) in segments" :key="index">
      <NuxtLink
        v-if="segment.to"
        :href="`/${locale}/api/${segment.to}`"
        class="text-(--ui-primary) hover:underline"
      >{{ segment.text }}</NuxtLink>
      <template v-else>{{ segment.text }}</template>
    </template>
  </code>
</template>
