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
  writable: string
  writableTooltip: string
  constructible: string
  wraps: string
  extendedBy: string
  payload: string
  raisedBy: string
  exposedAs: string
  kinds: Record<'handle' | 'data' | 'record' | 'event', string>
  matrix: {
    module: string
    member: string
    range: string
    allTitle: string
    partialTitle: string
    unavailableTitle: string
    empty: string
  }
}

const EN: ApiLabels = {
  since: 'NeoMacro',
  mc: 'Minecraft',
  loader: 'Fabric Loader',
  mcAll: 'All versions',
  loaderAll: 'All loaders',
  permission: 'Permission',
  experimental: 'Experimental',
  cancellable: 'Cancellable',
  readonly: 'Read-only',
  writable: 'Writable',
  writableTooltip: 'Writable on synchronous deliveries only; the committed value is returned to the publisher.',
  constructible: 'Constructible',
  wraps: 'Wraps',
  extendedBy: 'Extended by',
  payload: 'Payload',
  raisedBy: 'Raised by',
  exposedAs: 'Exposed as',
  kinds: { handle: 'Handle', data: 'Data', record: 'Record', event: 'Event' },
  matrix: {
    module: 'Module',
    member: 'Member',
    range: 'Range',
    allTitle: 'Available in this build',
    partialTitle: 'Only some members are available in this build',
    unavailableTitle: 'Not available in this build',
    empty: 'No member carries a specific availability range — the whole API is available on every supported version.',
  },
}

const ZH: ApiLabels = {
  since: 'NeoMacro',
  mc: 'Minecraft',
  loader: 'Fabric Loader',
  mcAll: '全版本',
  loaderAll: '全部',
  permission: '权限',
  experimental: '实验性',
  cancellable: '可取消',
  readonly: '只读',
  writable: '可写',
  writableTooltip: '仅同步通道投递实例可写；提交值回传发布方。',
  constructible: '可实例化',
  wraps: '包装',
  extendedBy: '派生类型 (Extend)',
  payload: '载荷 (Paylaod)',
  raisedBy: '触发事件',
  exposedAs: '暴露为',
  // All kind badges keep the English terms on Chinese pages too: they
  // match the API's own vocabulary (Handle, Data, Record, Event) and the
  // *Handle class names (FileHandle, TimerHandle…); translated badges
  // would drift from the type names the scripts actually see.
  kinds: { handle: 'Handle', data: 'Data', record: 'Record', event: 'Event' },
  matrix: {
    module: '模块',
    member: '成员',
    range: '范围',
    allTitle: '此构建上可用',
    partialTitle: '此构建上仅部分成员可用',
    unavailableTitle: '此构建上不可用',
    empty: '当前没有带具体版本范围的成员——整个 API 在所有受支持的版本上都可用。',
  },
}

export function useApiLabels() {
  const { locale } = useI18n()
  const zh = computed(() => locale.value.toLowerCase().startsWith('zh'))
  const labels = computed(() => (zh.value ? ZH : EN))
  /**
   * Deep link into the glossary entry for a kind chip (`Handle`, `Data`,
   * `Record`, `Event`). Both locales serve the same page under their URL
   * prefix (`/en/api/glossary`, `/zh-cn/api/glossary`), matching the
   * `#kind-<kind>` anchors in the hand-written glossary files.
   */
  const glossaryHref = (kind: string) =>
    `/${locale.value.toLowerCase()}/api/glossary#kind-${kind}`
  return { labels, zh, glossaryHref }
}
