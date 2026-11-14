# 目录清单迁移与常见陷阱(中文参考)

机制详解见指南:快速上手、第一个脚本、事件、异步线程、存储、权限信任
(https://neomacros.tuanzi.ink/zh-cn/guide/getting-started 起)。

## 目录与清单

JsMacros 执行脚本文件夹里的每个 `.js`;NeoMacros 一个脚本一个文件夹,
置于触发类型目录之下:

```text
config/NeoMacros/macros/        # 数据目录名取模组显示名(改名前的
├── event/<name>/               #   config/neomacros 旧安装不迁移)
│   ├── neomacro.yml
│   └── index.js
├── services/<name>/
└── keypress/<name>/
```

清单必填 `name`、`version`、`author`;行为在 `config:` 块(顶层遗留字段
`key`、`lifecycle`、`autostart`、`events` 已废除,旧清单报迁移错误):

```yaml
name: my-script
version: 1.0.0
author: you
permissions: ["fs"]          # 可选:fs | net | command | java

config:
  event:
    on: [chat:receive]       # 加载时校验,拼错被拒并列出可用事件
```

按键宏把触发边放进清单(`config.keypress.on: keydown/keyup/keypress`,
`key_code` 是初始绑定建议,`modifiers: [ctrl]` 可选),入口收到
`ev = { event, key, code, clicks, modifiers }`。

入口导出 `startup(payload)`(必需,支持 async;事件宏每次发生调用一次,
services 激活时调用一次)与可选 `dispose()`(计时器、文件句柄等额外
清理;订阅自动随模块卸载移除)。管理命令:`/neomacros list`、
`/neomacros reload`、`/neomacros trust <name>`、`/neomacros errors`。

## 权限与信任

基础面(事件、计时器、聊天输出、世界/玩家读取、HUD/render、storage)
无需声明。受限能力在清单 `permissions` 声明,玩家经聊天提示授予:

| 权限 | 解锁 |
| --- | --- |
| `fs` | `neo.fs` 全部(相对游戏目录) |
| `net` | `neo.net` fetch/get/post |
| `command` | `neo.command.register` / `execute` |
| `java` | `neo.java`、`neo.reflect`、`neo.client.minecraft`(完整宿主访问,最高信任) |

信任按内容哈希锚定:改文件即改哈希,弹窗重现、重新 trust;决定存
`config.json` 跨重启保留。未知能力名被拒(fail-closed);无权限调用在
触发时抛错,显示在 `/neomacros errors`。

## 迁移陷阱清单

1. **事件名拼写**:原生是驼峰 `domain:name`(`input:keyPress`、
   `world:blockUpdate`),JsMacros 的 `Key`/`TICK`/`HEALTH_CHANGE` 一律
   不认识;从事件页原样复制。清单校验在加载时拒绝未知名字。
2. **回调形状**:`(event, context)` → 单个 payload;字段名不同
   (`event.health` 恰好同名,`event.message` 等需查事件页),不要照搬
   JsMacros 的字段访问。
3. **取消与改写**:返回值取消已废——onSync 里 `e.cancel()` /
   `e.cancelled`,改写白名单字段原位赋值;`local` 方向事件永不可取消。
4. **未 await 的 Promise**:条件判断里 `fs.exists(p)` 恒为真;异步面
   逐调用点迁移,不批量替换。
5. **活句柄判空**:不在世界时 `player.self` 为 `undefined`,消失实体
   读 `undefined`;维度切换/重生后同理。
6. **循环不让出**:没有 `await` 的紧密循环独占脚本事件循环,自己的
   计时器与事件全部排队;每次迭代 `await thread.ticks(...)` 或
   `thread.sleep(...)`。
7. **游戏状态与主线程**:世界/实体状态读写包进 `thread.runOnMain`,
   异步代码直接读写是与客户端竞态。
8. **高频事件守卫**:`tick` 每秒 20 次,处理体早退(`n % 20 !== 0`
   return);`world:sound`、`world:blockUpdate` 同理。
9. **storage 只收 JSON**:类实例、Map、函数、活句柄存不进;位置存字段
   `{x,y,z}` 而不是句柄;`put(key, null)` 是删除。
10. **权限与代码一致**:清单声明的 `permissions` 必须覆盖代码实际调用
    的受限门面;编辑后重新 trust。

## 排查入口

`/neomacros errors` 列出最近失败(脚本名、消息、指向源文件的堆栈);
抛错被捕获,其他脚本继续运行。完整排查清单见指南 Troubleshooting。
