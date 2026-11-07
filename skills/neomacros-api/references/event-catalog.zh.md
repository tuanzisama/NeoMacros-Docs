# 事件目录(中文参考)

45 个客户端事件,九个域。事件名 `domain:name` **驼峰式**(裸 `tick`
唯一例外);页面 URL 为小写连字符 slug,注意 slug 会把驼峰名全部小写。

事件页 URL 模式:
`https://neomacros.tuanzi.ink/en/api/events/<域>/<小写连字符名>`
(中文把 `/en/` 换成 `/zh-cn/`)。每页列出载荷字段与是否可取消;
载荷类页面在 `/en/api/classes/<载荷类小写名>`。

标 ✓ 的六个事件可取消(onSync 订阅,truthy 否决):
`key:press`、`chat:send`、`player:attackBlock`、`player:attackEntity`、
`player:interactBlock`、`player:interactEntity`。其余事件的载荷字段以
各自页面为准。

## chat(聊天)

| 事件 | 页 slug | 可取消 |
| --- | --- | --- |
| `chat:receive` | `chat/chat-receive` | |
| `chat:send` ✓ | `chat/chat-send` | ✓ |

## entity(实体)

| 事件 | 页 slug |
| --- | --- |
| `entity:damage` | `entity/entity-damage` |
| `entity:heal` | `entity/entity-heal` |
| `entity:load` | `entity/entity-load` |
| `entity:spawn` | `entity/entity-spawn` |
| `entity:unload` | `entity/entity-unload` |

## game(游戏生命周期)

| 事件 | 页 slug |
| --- | --- |
| `game:quit` | `game/game-quit` |
| `game:start` | `game/game-start` |

## input / key(输入)

| 事件 | 页 slug | 可取消 |
| --- | --- | --- |
| `input:wheel` | `input/input-wheel` | |
| `key:press` ✓ | `key/key-press` | ✓ |

## player(玩家,20 个)

| 事件 | 页 slug | 可取消 |
| --- | --- | --- |
| `player:air` | `player/player-air` | |
| `player:armor` | `player/player-armor` | |
| `player:attackBlock` ✓ | `player/player-attackblock` | ✓ |
| `player:attackEntity` ✓ | `player/player-attackentity` | ✓ |
| `player:damage` | `player/player-damage` | |
| `player:death` | `player/player-death` | |
| `player:dimensionChange` | `player/player-dimensionchange` | |
| `player:effect` | `player/player-effect` | |
| `player:exp` | `player/player-exp` | |
| `player:gamemode` | `player/player-gamemode` | |
| `player:gliding` | `player/player-gliding` | |
| `player:heal` | `player/player-heal` | |
| `player:health` | `player/player-health` | |
| `player:heldItem` | `player/player-helditem` | |
| `player:hunger` | `player/player-hunger` | |
| `player:interactBlock` ✓ | `player/player-interactblock` | ✓ |
| `player:interactEntity` ✓ | `player/player-interactentity` | ✓ |
| `player:join` | `player/player-join` | |
| `player:leave` | `player/player-leave` | |
| `player:respawn` | `player/player-respawn` | |
| `player:riding` | `player/player-riding` | |
| `player:sneak` | `player/player-sneak` | |
| `player:spawn` | `player/player-spawn` | |
| `player:sprint` | `player/player-sprint` | |

## screen(屏幕)

| 事件 | 页 slug |
| --- | --- |
| `screen:close` | `screen/screen-close` |
| `screen:open` | `screen/screen-open` |

## tick(节拍)

| 事件 | 页 slug | 说明 |
| --- | --- | --- |
| `tick`(无域前缀) | `tick/tick` | 载荷带 `count`;每秒 20 次,处理体务必早退守卫 |

## world(世界,10 个)

| 事件 | 页 slug |
| --- | --- |
| `world:blockUpdate` | `world/world-blockupdate` |
| `world:bossbar` | `world/world-bossbar` |
| `world:chunkLoad` | `world/world-chunkload` |
| `world:chunkUnload` | `world/world-chunkunload` |
| `world:dimensionChange` | `world/world-dimensionchange` |
| `world:join` | `world/world-join` |
| `world:leave` | `world/world-leave` |
| `world:sound` | `world/world-sound` |
| `world:time` | `world/world-time` |
| `world:weather` | `world/world-weather` |

## 通配符注意

`domain:*` 与 `*` 通配可用,但 `tick`、`world:sound`、`world:blockUpdate`
等高流量事件默认不参与通配符分发。
