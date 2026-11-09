export default defineNuxtConfig({
  extends: ['docus'],
  modules: ['@nuxtjs/i18n'],

  app: {
    head: {
      // VibeCafé 作品数据统计: a single Origin-whitelisted browser
      // beacon injected once into every page's <head>. The auth key is
      // browser-facing only — never reuse it for admin APIs or query
      // parameters.
      script: [
        {
          defer: true,
          src: 'https://vibecafe.ai/telemetry/v1.js',
          'data-vc-product-id': 'cmw9e9vy0000008kxmiyy9n7x',
          'data-vc-auth-key': 'vc_web_1F_wjLxT3yHNWveciQ8meGEi8pwwW0AsVYAuv5vwXPw',
        },
      ],
    },
  },

  site: {
    name: 'NeoMacros',
    // Update to the production domain when the site is deployed.
    url: 'https://neomacros.tuanzi.ink',
  },

  i18n: {
    defaultLocale: 'en',
    baseUrl: 'https://neomacros.tuanzi.ink',
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
    '/en/api': { redirect: { to: '/en/api/overview' } },
    '/en/examples': { redirect: { to: '/en/examples/overview' } },
    '/en/migration': { redirect: { to: '/en/migration/overview' } },
    '/zh-cn/api': { redirect: { to: '/zh-cn/api/overview' } },
    '/zh-cn/examples': { redirect: { to: '/zh-cn/examples/overview' } },
    '/zh-cn/migration': { redirect: { to: '/zh-cn/migration/overview' } },
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
