<script setup lang="ts">
/**
 * Version-compatibility matrix, fed by VersionMatrix.java's
 * `:api-version-matrix{section data}` leaf tag. The compact JSON payload
 * travels in a single-quoted MDC prop (its double quotes are safe inside
 * single quotes; the payload never carries one) and is parsed here, so no
 * markdown table generation is involved. One generated page hosts two
 * instances with the same payload: the module availability grid and the
 * version-constrained member detail, whose empty state is localized here.
 */
interface ModuleRow {
  name: string
  href: string
  /** Per version: "all" members available, or "n/m". */
  cells: string[]
}
interface ConstrainedRow {
  module: string
  member: string
  range: string
  /** Per version whether the member's range covers the build. */
  cells: boolean[]
}
interface MatrixData {
  versions: string[]
  modules: ModuleRow[]
  constrained: ConstrainedRow[]
}

const props = defineProps<{
  section?: 'modules' | 'constrained'
  data?: string
}>()

const { labels } = useApiLabels()

// Java emits module hrefs relative to the api root ("modules/<domain>/<name>").
// The anchor bypasses Content's link rewriting, so resolve it against the
// current locale's api section here — otherwise a browser-relative href
// breaks on the trailing-slash URL of the version-matrix page.
const { locale } = useI18n()
const moduleHref = (href: string) =>
  href.startsWith('/') ? href : `/${locale.value.toLowerCase()}/api/${href}`

const parsed = computed<MatrixData | null>(() => {
  if (!props.data) {
    return null
  }
  try {
    return JSON.parse(props.data) as MatrixData
  } catch {
    return null
  }
})
const versions = computed(() => parsed.value?.versions ?? [])
const rows = computed(() => {
  if (!parsed.value) {
    return []
  }
  return props.section === 'constrained' ? parsed.value.constrained : parsed.value.modules
})
</script>

<template>
  <!-- Module availability grid: sticky first column, ✓ green, "n/m" amber. -->
  <div
    v-if="section === 'modules' && parsed"
    class="not-prose my-4 overflow-x-auto rounded-lg border border-(--ui-border)"
  >
    <table class="w-full border-collapse text-sm">
      <thead>
        <tr class="bg-(--ui-bg-elevated)">
          <th scope="col" class="sticky left-0 z-10 min-w-28 bg-(--ui-bg-elevated) px-3 py-2 text-left font-medium text-(--ui-text-muted)">
            {{ labels.matrix.module }}
          </th>
          <th
            v-for="version in versions"
            :key="version"
            scope="col"
            class="px-3 py-2 text-center font-mono text-xs font-medium whitespace-nowrap text-(--ui-text-muted)"
          >
            {{ version }}
          </th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="row in rows" :key="row.name" class="border-t border-(--ui-border)">
          <td class="sticky left-0 z-10 bg-(--ui-bg) px-3 py-2 whitespace-nowrap">
            <a :href="moduleHref(row.href)" class="font-mono font-medium text-(--ui-primary) hover:underline">{{ row.name }}</a>
          </td>
          <td
            v-for="(cell, index) in row.cells"
            :key="index"
            class="px-3 py-2 text-center whitespace-nowrap"
            :title="cell === 'all' ? labels.matrix.allTitle : labels.matrix.partialTitle"
          >
            <span v-if="cell === 'all'" class="text-(--ui-success)" aria-label="✓">✓</span>
            <UBadge v-else color="warning" variant="subtle" size="sm">{{ cell }}</UBadge>
          </td>
        </tr>
      </tbody>
    </table>
  </div>

  <!-- Constrained members: localized empty state, else the detail table. -->
  <div v-else-if="section === 'constrained' && parsed" class="not-prose my-4">
    <p v-if="!rows.length" class="my-4 text-sm text-(--ui-text-muted)">
      {{ labels.matrix.empty }}
    </p>
    <div v-else class="overflow-x-auto rounded-lg border border-(--ui-border)">
      <table class="w-full border-collapse text-sm">
        <thead>
          <tr class="bg-(--ui-bg-elevated)">
            <th scope="col" class="sticky left-0 z-10 bg-(--ui-bg-elevated) px-3 py-2 text-left font-medium text-(--ui-text-muted)">{{ labels.matrix.module }}</th>
            <th scope="col" class="px-3 py-2 text-left font-medium text-(--ui-text-muted)">{{ labels.matrix.member }}</th>
            <th scope="col" class="px-3 py-2 text-left font-medium text-(--ui-text-muted)">{{ labels.matrix.range }}</th>
            <th
              v-for="version in versions"
              :key="version"
              scope="col"
              class="px-3 py-2 text-center font-mono text-xs font-medium whitespace-nowrap text-(--ui-text-muted)"
            >
              {{ version }}
            </th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="row in rows" :key="`${row.module}.${row.member}`" class="border-t border-(--ui-border)">
            <td class="sticky left-0 z-10 bg-(--ui-bg) px-3 py-2 font-mono whitespace-nowrap">{{ row.module }}</td>
            <td class="px-3 py-2 font-mono whitespace-nowrap">{{ row.member }}</td>
            <td class="px-3 py-2 font-mono whitespace-nowrap">
              <UBadge color="warning" variant="subtle" size="sm">{{ row.range }}</UBadge>
            </td>
            <td v-for="(cell, index) in row.cells" :key="index" class="px-3 py-2 text-center" :title="cell ? labels.matrix.allTitle : labels.matrix.unavailableTitle">
              <span v-if="cell" class="text-(--ui-success)" aria-label="✓">✓</span>
              <span v-else class="text-(--ui-text-dimmed)" aria-label="—">—</span>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
