# 门面映射与形态变化(中文参考)

完整对照见迁移页「原生 API 对照」:
https://neomacros.tuanzi.ink/en/migration/migrating-from-jsmacros
成员签名以各门面页与 `neomacros.d.ts` 为准,勿臆造。

## 全局 → 门面

| JsMacros 全局 | 原生 | 迁移要点 |
| --- | --- | --- |
| `JsMacros.on/once/off/waitForEvent` | `events.on/once/off/waitFor` | 事件名见 event-map;回调单参数 |
| `JsMacros.awakeScript` 等脚本运行面 | 无(内部概念) | 生命周期即 `startup`/`dispose` |
| `Chat` | `chat` | `log`/`say`/`actionbar` 同名;另有 `title`/`toast`;样式文本经旧式 `§` 渲染,悬停/点击样式丢弃 |
| `Player` | `player` | `getPlayer()` → `player.self`(不在世界时 `undefined`,必须判空);类型化当前屏幕经 `player.screen` |
| `World` | `world` | `getBlock` → `world.blockAt(x,y,z)`;扫描用 `world.scanBlocks`(按刻分片的 Promise,不是同步循环) |
| `Client` | `client` | `fps`/`gameVersion`/`clipboard`/`window` 等属性;`waitTick` → `thread.nextTick`;`runOnMainThread` → `thread.runOnMain` |
| `KeyBind` | `input` | 控件菜单注册、监听、注入;按键宏声明式触发见清单 `config.keypress` |
| `Inventory` | `player.inventory` | `items` 为按槽位键控的 `Record<number, ItemStack>`;点击/丢弃等动作返回 Promise,需 await |
| `Hud`(Draw2D/Draw3D) | `hud` + `render` | Draw2D 文本 → `hud.addText`(同 id 原位替换);Draw3D 盒/线/点 → `render.drawBox/drawLine`;纹理注册经 `hud.texture` |
| `FS` | `fs` | **原生即异步**,每次调用 await;路径相对游戏目录(不是脚本文件夹) |
| `GlobalVars` | `storage` | `putInt/putString/...` → `put`;`getObject` 只收 JSON 可序列化值(compat 的 `putObject` 抛错是 compat 限制,原生 `storage.put` 直接收 JSON);无枚举全部键的操作 |
| `Request` | `net` | `get/post` → `net.fetch/get/post`,返回 Promise;`Response` 的 `text()/json()` 异步 |
| `Reflection`/`JavaUtils`/`JavaWrapper` | `java` + `reflect` | java 权限之后;`java.type` 按二进制名查类(Mojmap) |
| `Time.sleep(ms)` | `thread.sleep(ms)` | `Time.time()` → `Date.now()`;tick 边界用 `thread.ticks/nextTick` |
| `PositionCommon` | `Pos3D` 等 | `floor()`、`withX/Y/Z()`、`add()` 变形 |
| `Color` | 普通 ARGB 整数 | `0xAARRGGBB`;兼容层的助手函数与原生一致 |

## 三处形态变化

1. **回调形状**:`(event, context)` 参数对消失,事件处理器只收**一个
   冻结 payload 对象**;载荷字段名与 JsMacros 形状不同,字段一律查事件页。
2. **快照与改写**:异步事件(`events.on`)的载荷是冻结快照,改写不存在;
   改写与取消在 `events.onSync`(可写表单,白名单字段)。
3. **订阅生命周期**:模块加载期间创建的 `events.on` 订阅归属该模块,
   卸载时自动移除——JsMacros 里手动 `JsMacros.off` 的样板可删。

## 异步面清单

以下 JsMacros 调用在原生返回 Promise,调用点逐个加 `await`:

| JsMacros | 原生返回 |
| --- | --- |
| `FS.*`(全部文件操作) | `Promise<...>` |
| `Request.get/post/create(url).get()` | `Promise<Response>`(`text()/json()` 异步) |
| `Time.sleep(ms)` | `Promise<void>` |
| `Client.waitTick([n])` | `Promise<void>`(→ `thread.nextTick()`/`thread.ticks(n)`) |
| `Client.runOnMainThread(fn)` | `Promise<unknown>`(→ `thread.runOnMain`) |
| `Inventory.click/dropSlot/quick/swapHotbar/split/grabAll/close` | `Promise<void>` |
| `ClientPlayer.dropHeldItem`、交互管理器动作 | `Promise<void>` |
| `Client.connect(address)` | `Promise<void>`(失败 reject) |

:::warning
不 await 的 `fs.exists(p)` 写在 `if` 里恒为真——分支判断的是 Promise
对象而不是文件。调用点逐个迁移,不做批量替换。
:::

## 读取面差异(非抛错,行为不同)

- **活句柄**:实体/玩家读取实时重读,不在创建时快照;已消失的实体读到
  `undefined`/`null`——`player.self` 与实体句柄一律判空。
- **显示名**:由 id 推导(`minecraft:deepslate_bricks` → `Deepslate
  Bricks`),无翻译表查询。
- **`isDay`/`isNight`**:固定原版时间窗,夜晚为第 13000–23000 刻。
- **世界扫描**:原生 `world.scanBlocks`/`entity.inRadius`/`entity.inBox`
  是按每刻分片的过滤扫描(Promise),不是兼容层那种同步 JS 循环。
- **通配符**:`*` 默认跳过 `tick`、`world:sound`、`world:blockUpdate`。
