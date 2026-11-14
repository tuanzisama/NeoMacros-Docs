# 事件映射表(中文参考)

JsMacros 1.9.2 的 36 个事件名在原生 NeoMacros 中的对应关系。事件页 URL:
`https://neomacros.tuanzi.ink/en/api/events/<域>/<小写连字符名>`(载荷字段
以各事件页为准)。兼容层的桥接清单 `src/globals/events/names.js` 是本表的
交叉核对来源。

## 一、已映射事件(36)

| JsMacros | 原生事件 | 载荷要点 |
| --- | --- | --- |
| `Tick` | `tick` | 载荷带 `count`;每秒 20 次,处理体务必早退守卫 |
| `Key` | `input:keyPress` | 注意不是 `key:press`——`key` 域已并入 `input` |
| `MouseScroll` | `input:wheel` | |
| `RecvMessage` | `chat:receive` | |
| `SendMessage` | `chat:send` | 可取消;改写走 `events.onSync` 的 `e.message` |
| `Sound` | `world:sound` | 通配符默认排除 |
| `Bossbar` | `world:bossbar` | |
| `JoinServer` | `world:join` | |
| `Disconnect` | `world:leave` | |
| `DimensionChange` | `world:dimensionChange` | |
| `ChunkLoad` | `world:chunkLoad` | |
| `ChunkUnload` | `world:chunkUnload` | |
| `BlockUpdate` | `world:blockUpdate` | 通配符默认排除 |
| `EntityLoad` | `entity:load` | |
| `EntityUnload` | `entity:unload` | |
| `EntityDamaged` | `entity:damage` | |
| `EntityHealed` | `entity:heal` | |
| `PlayerJoin` | `player:join` | |
| `PlayerLeave` | `player:leave` | |
| `AirChange` | `player:air` | |
| `AttackBlock` | `player:attackBlock` | 可取消(onSync) |
| `AttackEntity` | `player:attackEntity` | 可取消(onSync) |
| `InteractBlock` | `player:interactBlock` | 可取消(onSync) |
| `InteractEntity` | `player:interactEntity` | 可取消(onSync) |
| `Damage` | `player:damage` | |
| `Heal` | `player:heal` | |
| `HealthChange` | `player:health` | 载荷字段 `health` |
| `Death` | `player:death` | |
| `EXPChange` | `player:exp` | |
| `FallFlying` | `player:gliding` | |
| `HeldItemChange` | `player:heldItem` | 主手触发;offHand 恒无 |
| `HungerChange` | `player:hunger` | |
| `OpenScreen` | `screen:open` + `screen:close` | 一个 JsMacros 事件拆成两个原生事件 |
| `StatusEffectUpdate` | `player:effect` | |
| `LaunchGame` | `game:start` | |
| `QuitGame` | `game:quit` | |
| `ANYTHING` | `*` | 通配;默认跳过 `tick`、`world:sound`、`world:blockUpdate` |

**方向与可取消性**:事件页标注 direction 与 `cancellable` 属性——
`c2s`(客户端即将行动:`input:keyPress`、`chat:send`、`player:
attackBlock/attackEntity/interactBlock/interactEntity`)与带
`cancellable` 的 `s2c`(`chat:title`、`screen:signEdit` 等)可取消/
可改写;`local`(tick、体征、世界、屏幕状态、`input:wheel`)只读,
永不可取消;`chat:receive` 是 s2c 但**不可取消**(仅观察)。onSync 里
用 `e.cancel()` 否决、`e.cancelled` 读状态、白名单字段原位改写,返回值
被忽略——与 JsMacros 的返回值取消习惯不同。

## 二、不支持的 JsMacros 事件与原生替代(19)

兼容层对这些名字抛 `UnimplementedError`;直接迁移时按下表改写:

| JsMacros 事件 | 原生替代 | 说明 |
| --- | --- | --- |
| `RecvPacket` / `SendPacket` | `packet:receive` / `packet:send` | 事件作用域 `PacketBuffer` 句柄 + `client.createPacketBuffer` / `sendPacket` / `packetIds`;`sendPacket` 实参需 java 能力 |
| `Title` | `chat:title` + `chat:actionbar` | 原生无 Title 事件,两个输出事件承载 |
| `SignEdit` | `screen:signEdit` | |
| `ClickSlot` | `inventory:click` | `button`/`containerId`/`kind`/`shift`/`slot` 字段;仅本地观察,不可取消 |
| `DropSlot` | `inventory:click` | 同上,经 `kind` 区分 |
| `OpenContainer` | `inventory:open` | |
| `ContainerUpdate` | `inventory:update` | |
| `SlotUpdate` | `inventory:update` | |
| `Riding` | `player:riding` | 载荷 `vehicle`(EntitySnapshot,下坐时为 `null`);兼容层早于该事件,其"不支持"结论已过时 |
| `ArmorChange` | `player:armor` | 同上,兼容层结论已过时 |
| `NameChange` | 无 | 原生无实体显示名变更事件 |
| `ItemPickup` | 无 | |
| `ItemDamage` | 无 | |
| `ResourcePackLoaded` | 无 | |
| `ProfileLoad` | 无 | 原生无 profile 概念 |
| `WrappedScript` | 无 | JsMacros 内部脚本事件;原生生命周期是 `startup`/`dispose` |
| `Service` | 无 | JsMacros 内部服务事件;原生 services 宏承接 |
| `CommandContext` | 无 | JsMacros 内部命令分发;脚本命令用 `command` 门面 |

「无」表示没有对应事件——该行为要么删掉,要么用 tick 轮询/其他事件重组,
写迁移说明时如实标注。

## 三、旧 UPPER_SNAKE 别名

JsMacros 旧 profile 名(兼容层接受,原生不接受):`TICK`、`KEY`、
`RECV_MESSAGE`、`SEND_MESSAGE`、`TITLE`、`RECV_PACKET`、`SEND_PACKET`、
`JOIN_SERVER`、`DISCONNECT`、`DIMENSION_CHANGE`、`CHUNK_LOAD`、
`CHUNK_UNLOAD`、`BLOCK_UPDATE`、`BOSSBAR_UPDATE`、`SOUND`、`NAME_CHANGE`、
`PLAYER_JOIN`、`PLAYER_LEAVE`、`AIR_CHANGE`、`ARMOR_CHANGE`、`DAMAGE`、
`DEATH`、`EXP_CHANGE`、`HELD_ITEM`、`HUNGER_CHANGE`、`OPEN_SCREEN`、
`SIGN_EDIT`、`ITEM_PICKUP`、`ITEM_DAMAGE`、`PROFILE_LOAD`。

直接迁移一律使用上表的原生驼峰名;加载时清单校验会拒绝拼错的名字,
错误信息里带可用事件列表。

## 四、自定义事件

JsMacros 的脚本自定义事件 → `events.register('ns:name')` 预留命名空间
(不得遮蔽内置域),`events.emit('ns:name', payload)` 投递;载荷键避开
保留字 `type`、`timestamp`、`cancellable`。原生自定义事件可取消性与
内置不同,以 events 门面页为准。
