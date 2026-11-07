# 常见失败模式与排查清单(中文参考)

完整指南:https://neomacros.tuanzi.ink/zh-cn/guide/troubleshooting

## 读错误屏

`/neomacros errors` 列出最近失败——非法文件夹与运行时异常都有,含脚本名、
消息、指向源文件的堆栈。抛错不会弄垮游戏:被捕获、跳过失败处理器、
其他脚本继续跑。

## 按失败模式对症

### 1. 脚本不出现在 /neomacros list

加载时被拒。常见原因:

- **事件名拼错**(`config.event.on`):加载时对照目录校验,未知名字被拒
  并列出可用事件。从事件页**原样复制,大小写含在内**——多个名字是驼峰,
  如 `world:blockUpdate`、`player:attackBlock`。
- **缺 `domain:` 前缀**:几乎全部事件是 `domain:name`,写 `receive` 而非
  `chat:receive` 校验失败。裸 `tick` 是唯一无域内置事件。
- **顶层遗留行为字段**:`key`、`lifecycle`、`autostart`、`events` 已废除;
  行为在 `config:` 块,旧清单报迁移错误并指明目标。
- **缺必填身份字段**:`name`、`version`、`author` 缺一不可。

### 2. 拒绝调用错误(edit 之后突然出现)

脚本碰了信任门后的东西(`fs` / `net` / `command` / `java`)而没授权。
改过文件 = 内容哈希变了,旧信任失效——**改后重新 `/neomacros trust`
是头号原因**。其次检查清单 `permissions` 是否声明了代码实际调用的能力。

### 3. 属性读取时崩溃

活句柄每次读取都重查游戏状态:不在世界时 `player.self` 读出 `undefined`,
消失实体的句柄同样。守卫:

```js
const p = player.self;
if (!p) return;
```

维度切换、重生后,先前有效的句柄也可能短暂指向空,同一守卫适用。
`lifecycle: always` 的服务、离开世界后仍在跑的异步循环都要防。

### 4. 脚本自己的计时器/事件停摆

没有 `await` 的紧密轮询或长计算独占脚本事件循环,自己的计时器和事件
投递全部排在后面。每个长等待都该是 `await thread.sleep(...)` /
`thread.ticks(...)` / `thread.nextTick()`;游戏状态读写放进
`thread.runOnMain`。

### 5. storage.put 抛错

`storage.put` 只收纯 JSON。传活句柄、类实例、函数都失败;`null` 特殊,
是删除键。用 `JSON.stringify` 检查值——活着往返的才是合法的。

## 统一排查清单

1. `/neomacros list` — 脚本出现吗?不出现是清单问题,去 errors 看拒绝原因。
2. `/neomacros errors` — 读最新条目的消息与堆栈,文件和行号通常够了。
3. 清单声明了代码调用的每个能力吗?上次编辑后重新 trust 了吗?
4. 事件名与目录拼写完全一致吗(含域前缀与驼峰)?
5. `player.self` 与实体句柄有 `undefined` 守卫吗?
6. 每个循环都 `await` 让出吗?游戏状态只在主线程碰吗?
7. 仍不行?把脚本缩到最小失败部分,对照 API 参考
   https://neomacros.tuanzi.ink/zh-cn/api/overview 核对调用签名。
