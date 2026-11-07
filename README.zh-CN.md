[English](README.md) | 简体中文

# NeoMacros-Docs

[NeoMacros](https://github.com/tuanzisama/NeoMacros)(面向 Minecraft
客户端的 ECMAScript 脚本模组,Fabric)的文档站。基于
[Docus](https://docus.dev/)(Nuxt 4)构建,中英双语。分区:指南、
示例、以及从模组注解源码生成的 API 参考。

## 本地开发

```bash
npm install
npm run dev        # http://localhost:3300
npm run generate   # 静态产物在 .output/public
```

API 分区为生成内容且不入库,新克隆先跑一次:

```bash
npm run api:generate && npm run api:sync
```

## Agent Skills

站点在 `/.well-known/skills/` 发布两个 AI 技能(`neomacros-scripting`、
`neomacros-api`),一条命令装入任意 AI 工具:

```bash
npx skills add https://neomacros.tuanzi.ink
```
