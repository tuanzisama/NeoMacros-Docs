[English](README.md) | 简体中文

# NeoMacros-Docs

[NeoMacros](https://github.com/tuanzisama/NeoMacros)（面向 Minecraft
客户端的 ECMAScript 脚本模组，Fabric）的文档站。基于
[Docus](https://docus.dev/)（Nuxt 4）构建，中英双语。

每个语言（`content/en/`、`content/zh-cn/`）下三个内容分区。目录名带数字
前缀（会从路由中剥掉），使 Nuxt Content 按路径字母序生成的导航与 header
预期顺序一致：指南 → 示例 → API：

| 分区 | 来源 |
| --- | --- |
| `1.guide/` | 手写教程页 |
| `2.examples/` | 手写完整可运行脚本 |
| `3.api/` | 从模组 `doc-api` 注解门面源码**生成**（仅 `index.md` 为手写） |

生成树里还包含版本兼容矩阵页（`api/00.version-matrix`），由 `@ApiMC`
可用性注解渲染。

## API 生成管线

`builder/` 是一个独立 Gradle 工程，用两个 Javadoc Doclet 扫描模组仓库的
`core` + `ports` 门面源码：

- `MDDoclet` — 双语 Markdown 页面（`<page>.md` 英文 + `<page>.zh.md`
  中文，按 `@zh` 标签翻译，成员级缺失回退英文）与版本兼容矩阵（MC
  版本从模组的 `versions/*` Stonecutter 节点自动发现）
- `TSDoclet` — `neomacros.d.ts` 环境类型定义，供编辑器自动补全

```bash
# 一次性，在模组仓库：发布注解 jar
cd ../neomacros && ./gradlew :doc-api:publishToMavenLocal

# 生成并同步进站点（本仓库站点根即仓库根，没有 site/ 子目录）
./gradlew -p builder generateApiDocs
bash scripts/sync-generated-docs.sh
# 或：npm run api:generate && npm run api:sync
```

生成的 API 页与 `.d.ts` 均已入库，站点构建不需要 Java 工具链。
不要手改生成的 API 页——除 `api/index.md` 外的一切都会在同步时被
清空重建。

手写的按模块示例片段（`api-examples/<en,zh>/<module>.md`）由同步脚本
以 `## Examples` 标题追加到生成的模块页尾部。

## 本地开发

```bash
npm install
npm run dev        # http://localhost:3300
npm run generate   # 静态产物在 .output/public
```

## CI

`.github/workflows/docs.yml` 在源码变更时重新生成 API 树并提交。触发
方式：触及管线/站点路径的推送、手动 dispatch、以及模组仓库
`docs-dispatch` 工作流发出的 `api-docs` repository dispatch。

## 许可

MIT
