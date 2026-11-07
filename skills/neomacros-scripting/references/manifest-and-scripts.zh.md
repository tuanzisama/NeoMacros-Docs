# 清单与脚本模型(中文参考)

完整指南:https://neomacros.tuanzi.ink/zh-cn/guide/getting-started 与
https://neomacros.tuanzi.ink/zh-cn/guide/first-script

## 运行时模型

NeoMacros 是客户端 Fabric 模组,内嵌 GraalJS 执行标准 ES 模块脚本:
真实的 Promise、`async`/`await`,每个脚本有独立事件循环。没有构建步骤,
`config/neomacros/macros/` 下的文件夹就是部署单元。

全局对象 `neo` 暴露全部 API(18 个门面 + 所有脚本可见类),无需 import。

## 目录布局

```text
.minecraft/
└── config/
    └── neomacros/
        ├── config.json    # 模组设置,含信任决定
        └── macros/        # 脚本根,一个脚本一个文件夹
            ├── keypress/  # 按键触发
            ├── event/     # 声明的游戏事件驱动
            └── services/  # 启动一次、长期驻留的后台脚本
```

类别文件夹决定触发方式。命令注册等一次性初始化适合放 services 脚本。

## 清单(neomacro.yml / neomacro.json)

同目录同时存在时 `.yml` 优先。顶层只放身份字段:

| 字段 | 必填 | 说明 |
| --- | --- | --- |
| `name` | 是 | 唯一 ID,命令与信任表用它指代脚本 |
| `version` | 是 | 版本号 |
| `author` | 是 | 作者 |
| `description` / `license` / `homepage` / `supportURL` | 否 | 展示信息 |
| `main` | 否 | 入口文件,默认 `index.js` |
| `permissions` | 否 | 声明需要的受限能力,如 `["fs"]` |
| `config` | 否 | 行为块(见下) |

**行为必须放 `config:` 块**。顶层遗留字段 `key`、`lifecycle`、
`autostart`、`events` 已移除,加载会报迁移错误。

事件宏:

```yaml
config:
  event:
    on: [world:join]   # 加载时校验,拼错立即被拒并列出可用事件
```

按键宏:

```yaml
config:
  keypress:
    on: keydown              # keydown / keyup / keypress(默认)
    default-key: key.keyboard.j
    modifiers: [ctrl]        # 可选:ctrl / shift / alt
```

`default-key` 只是初始绑定建议,不锁定。

## 入口导出

- `startup(payload)` **必需**,支持 async。事件宏的每个声明事件发生时
  以快照对象调用;按键宏以 `ev = { event, key, code, clicks, modifiers }`
  调用;services 宏在激活时调用一次。
- `dispose()` 可选,卸载/重载时的额外清理(计时器、`neo.fs` 文件句柄等)。
  订阅会自动随模块卸载清理,无需手动退订。

顶层代码在加载时执行一次,适合放常量与模块级状态。

## 管理命令

| 命令 | 用途 |
| --- | --- |
| `/neomacros list` | 查看已加载脚本 |
| `/neomacros reload` | 重扫 macros 目录应用修改 |
| `/neomacros trust <script>` | 授予脚本声明的能力 |
| `/neomacros errors` | 打开最近脚本失败列表(含堆栈) |

日常循环:保存文件 → `/neomacros reload` → 观察结果。

## 失败表现

- 清单非法、事件名未知、缺 `startup`:文件夹被跳过,原因记入 errors。
- 运行中抛错:被捕获,跳过失败的处理器,其他脚本继续运行。
- 两种失败都显示在 `/neomacros errors`,带指向源文件的堆栈。
