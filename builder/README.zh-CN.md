[English](README.md) | 简体中文

# builder

独立 Gradle 构建。从 [NeoMacros 模组仓库](https://github.com/tuanzisama/NeoMacros)的
`doc-api` 注解（坐标 `ink.tuanzi.neomacros:doc-api`，经本地仓库解析）及其
Javadoc（含 `@zh` 双语标签）生成脚本 API 文档：

- `api/<page>.md` — 英文页（规范源）
- `api/<page>.zh.md` — 中文页，按 `@zh` 标签翻译，成员级缺失时回退英文
- `api/version-matrix.md` / `.zh.md` — 版本兼容矩阵：模块 × MC 版本的
  可用性表 + 带 `@ApiMC` 版本范围的成员明细；MC 版本列表从模组仓库的
  `versions/*` Stonecutter 节点自动发现（升序）
- `api/warnings.txt` — 生成告警清单（缺 `@zh`、缺 `@ApiSince`）
- `types/neomacros.d.ts` — 全局作用域定义（模块门面接口、根级类构造面与
  `declare const neo` 全局聚合）

Markdown 与 `.d.ts` 消费同一份 `ApiModel`（注解扫描产物）。生成物不可手改；
`src/test/snapshots/` 下的快照基线仅在人工审查 diff 后更新。

## 使用

```bash
# 前置（在模组仓库执行）：发布注解 jar 到本地仓库
./gradlew :doc-api:publishToMavenLocal

# 从真实门面源码（core + ports）生成，不做快照断言；
# 产物在 build/gen/{md/api,ts/types}/
./gradlew -p builder generateApiDocs

# 生成 + 快照回归 + TypeScript 编译检查
./gradlew -p builder check -PtscPath=<typescript 包 bin/tsc 路径>
```

扫描的模组仓库默认取同级目录（`../neomacros`）；其他布局可用
`-PneomacrosRoot=<路径>` 或 `NEOMACROS_ROOT` 覆盖。`-PtscPath` 指向
typescript 包的 `tsc` JS 文件（经 node 执行）；未提供时跳过编译检查。

工具链为 JVM 25（与模组构建的 Gradle 守护进程一致）；CI 上由
`actions/setup-java` 提供。

## 结构

```
src/main/java/ink/tuanzi/neomacros/docs/
├── ApiModel.java        # 渲染层共用模型（模块/成员/句柄/事件/告警）
├── ModelExtractor.java  # DocletEnvironment → ApiModel，顺序确定性排序
├── DocletSupport.java   # Javadoc 摊平、@zh 标签提取、Java→TS 类型映射
├── MDDoclet.java        # 双语 Markdown 渲染（含 -mc-versions 矩阵开关）
├── VersionMatrix.java   # 版本兼容矩阵页（@ApiMC 表达式求值 + 双语渲染）
├── TSDoclet.java        # TypeScript ambient 定义渲染
├── NpmTypesPackager.java# npm 包形态的类型定义打包
└── ApiDocsGenerate.java # 命令行入口（可带第 5 个参数：逗号分隔 MC 版本）
```
