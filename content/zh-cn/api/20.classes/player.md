# Player

Handle · Wraps: `net.minecraft.world.entity.player.Player` · Extends: [`LivingEntity`](livingentity) · Extended by: [`LocalPlayer`](localplayer)

玩家句柄：实体读面经实体端口（远端玩家同样可用）；饥饿/氧气/游戏模式/经验等本地字段经玩家端口，远端玩家读为 undefined。

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `air` | `number` | 氧气值；仅本地玩家有值。 (read-only) |
| `gamemode` | `string` | 游戏模式标识（survival/creative/adventure/spectator）；仅本地玩家有值。 (read-only) |
| `health` | `number` | 生命值；本地玩家经玩家端口读取（生命在玩家快照上），远端玩家回退到实体快照。 (read-only) |
| `hunger` | `number` | 饥饿值；仅本地玩家有值。 (read-only) |
| `inventory` | [PlayerInventory](playerinventory) | 玩家自己的物品栏；仅本地玩家有值。 (read-only) |
| `saturation` | `number` | 饱和度；仅本地玩家有值。 (read-only) |
| `xp` | `Record<string, unknown>` | 经验 {level, progress, total}；仅本地玩家有值。 (read-only) |

## Methods

### `snapshot()`

返回时点快照；玩家未加载时返回 null。

**Returns** `EntitySnapshot`

Since: 0.1.0 · MC: * · Loader: *

### `toJSON()`

JSON 形式；本地玩家经玩家视图输出。

**Returns** `Record<string, unknown>`

Since: 0.1.0 · MC: * · Loader: *

### `toString()`

人类可读形式。

**Returns** `string`


## Examples

self 是本地玩家的活句柄（离开世界时读取为 undefined），opened 是当前打开的容器界面。

```js
const { player } = neo;

// self is a live handle; it reads as undefined outside a world
if (player.self) {
  const { health, hunger, gamemode } = player.self; // current vitals
}

// The container screen currently open, if any
if (player.opened) {
  const pearls = player.opened.countOf('ender_pearl'); // namespace optional
  if (pearls > 0) player.opened.close(); // close it from the script
}
```
