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
| `3.api/` | 从模组 `doc-api` 注解门面源码**生成**（仅 `00.overview.md` 为手写） |

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

生成的 API 树已加入 gitignore——任何构建站点的机器都要先执行上面的
两条命令（CI 在构建前同样如此）。不要手改生成的 API 页——除手写的
概述页外的一切都会在同步时被清空重建。

手写的按模块示例片段（`api-examples/<en,zh>/<module>.md`）由同步脚本
以 `## Examples` 标题追加到生成的模块页尾部。

## 本地开发

```bash
npm install
npm run dev        # http://localhost:3300
npm run generate   # 静态产物在 .output/public
```

### 全新克隆

生成的 API 内容不入库，所以新克隆的仓库 API 分区是空的，先跑一次生成：

```bash
npm run api:generate && npm run api:sync
```

`npm run dev` / `npm run generate` 依赖同步好的内容树（以及
`server/assets/neomacros.d.ts`）。由于这些树已被 ignore，再生成、再
同步的产物永远不会出现在 `git status` 里，裸 `git pull` 始终干净——
不再需要任何 skip-worktree 标记。

## CI

`.github/workflows/docs.yml` 重新生成 API 树、构建站点，并把预构建的
静态产物部署到 Vercel——生成内容不再提交入库。需要仓库 secrets
`VERCEL_TOKEN`、`VERCEL_ORG_ID`、`VERCEL_PROJECT_ID`；Vercel 的 Git
集成已断开，本工作流是唯一部署通道。触发方式：触及管线/站点路径的
推送、手动 dispatch、以及模组仓库 `docs-dispatch` 工作流发出的
`api-docs` repository dispatch。

## 许可

MIT
