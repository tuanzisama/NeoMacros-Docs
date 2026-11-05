// Facade module pages moved from the api root into the Modules/<domain>
// tree (see scripts/sync-generated-docs.sh); redirect the old flat URLs
// in both slash variants so existing links keep working.
const moduleRedirects = Object.fromEntries(
  [
    ['events', 'core'], ['thread', 'core'], ['storage', 'core'],
    ['chat', 'ui'], ['hud', 'ui'], ['command', 'ui'], ['render', 'ui'],
    ['world', 'world'], ['player', 'world'], ['entity', 'world'],
    ['input', 'input'],
    ['fs', 'system'], ['net', 'system'], ['java', 'system'],
    ['client', 'system'], ['reflect', 'system'],
  ].flatMap(([name, domain]) =>
    ['en', 'zh-cn'].flatMap(locale =>
      [`/${locale}/api/${name}`, `/${locale}/api/${name}/`].map(from => [
        from,
        { redirect: { to: `/${locale}/api/modules/${domain}/${name}` } },
        ]),
      ),
    ),
  )

export default defineNuxtConfig({
  extends: ['docus'],
  modules: ['@nuxtjs/i18n'],

  site: {
    name: 'NeoMacros',
    // Update to the production domain when the site is deployed.
    url: 'https://neomacros-docs.vercel.app',
  },

  i18n: {
    defaultLocale: 'en',
    baseUrl: 'https://neomacros-docs.vercel.app',
    locales: [
      { code: 'en', name: 'English' },
      // Docus matches UI message packs by lowercase {code}.json and only
      // ships zh-CN.json, so the URL prefix is /zh-cn/ (html lang stays
      // zh-CN).
      { code: 'zh-CN', name: '中文' },
    ],
  },

  // Section folders no longer carry index.md pages (Nuxt Content v3 turns
  // them into non-routable navigation ghosts that break the header section
  // links), so the bare section roots redirect to their overview pages.
  routeRules: {
    ...moduleRedirects,
    '/en/api': { redirect: { to: '/en/api/overview' } },
    '/en/api/': { redirect: { to: '/en/api/overview' } },
    '/en/examples': { redirect: { to: '/en/examples/overview' } },
    '/en/examples/': { redirect: { to: '/en/examples/overview' } },
    '/zh-cn/api': { redirect: { to: '/zh-cn/api/overview' } },
    '/zh-cn/api/': { redirect: { to: '/zh-cn/api/overview' } },
    '/zh-cn/examples': { redirect: { to: '/zh-cn/examples/overview' } },
    '/zh-cn/examples/': { redirect: { to: '/zh-cn/examples/overview' } },
  },

  nitro: {
    // Pin the static preset so `nuxt generate` always writes
    // .output/public regardless of the detected deploy target.
    preset: 'static',
    prerender: {
      autoSubfolderIndex: true,
      // The definitions download is a prerendered server route (a *.d.ts
      // cannot be shipped from public/, see server/routes/).
      routes: ['/neomacros.d.ts'],
    },
  },
})
