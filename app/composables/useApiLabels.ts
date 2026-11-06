/**
 * Localized label table for the API header/badge components. Generated
 * MDC pages carry pure data as component props; all wording lives here,
 * so both locale trees share one generated page and the components pick
 * the active language at render time.
 */
export interface ApiLabels {
  since: string
  mc: string
  loader: string
  mcAll: string
  loaderAll: string
  permission: string
  experimental: string
  cancellable: string
  readonly: string
  wraps: string
  extendedBy: string
  payload: string
  raisedBy: string
  exposedAs: string
  esmOnly: string
  and: string
  kinds: Record<'handle' | 'data' | 'record' | 'event', string>
}

const EN: ApiLabels = {
  since: 'Since',
  mc: 'MC',
  loader: 'Loader',
  mcAll: 'All versions',
  loaderAll: 'All loaders',
  permission: 'Permission',
  experimental: 'Experimental',
  cancellable: 'Cancellable',
  readonly: 'Read-only',
  wraps: 'Wraps',
  extendedBy: 'Extended by',
  payload: 'Payload',
  raisedBy: 'Raised by',
  exposedAs: 'Exposed as',
  esmOnly: 'ES module only',
  and: 'and',
  kinds: { handle: 'Handle', data: 'Data', record: 'Record', event: 'Event' },
}

const ZH: ApiLabels = {
  since: '起始版本',
  mc: 'MC 版本',
  loader: '加载器',
  mcAll: '全版本',
  loaderAll: '全部加载器',
  permission: '权限',
  experimental: '实验性',
  cancellable: '可取消',
  readonly: '只读',
  wraps: '包装',
  extendedBy: '派生类型',
  payload: '载荷',
  raisedBy: '触发事件',
  exposedAs: '暴露为',
  esmOnly: '仅 ES 模块',
  and: '与',
  kinds: { handle: '句柄', data: '数据', record: '记录', event: '事件' },
}

export function useApiLabels() {
  const { locale } = useI18n()
  const zh = computed(() => locale.value.toLowerCase().startsWith('zh'))
  const labels = computed(() => (zh.value ? ZH : EN))
  return { labels, zh }
}
