self 是本地玩家的活句柄（离开世界时读取为 undefined），opened 是当前打开的容器界面；另含统计、进度与准星选取的用法。

```js
const { player } = neo;

// self is a live handle; it reads as undefined outside a world
if (player.self) {
  const { health, hunger, gamemode } = player.self; // current vitals
}

// The container screen currently open, if any
if (player.inventory) {
  const pearls = player.inventory.countOf('ender_pearl'); // namespace optional
  if (pearls > 0) player.inventory.close(); // close it from the script
}

// 统计：活计数器上的分类查询
const stats = player.self?.statistics;
if (stats) {
  const mined = stats.mined('stone');            // 命名空间可省略
  const walked = stats.custom('walk_one_cm');    // 自定义统计
  const deaths = stats.value('minecraft:custom', 'minecraft:deaths');
}

// 进度：树查询加逐条进度
const adv = player.self?.advancements;
if (adv) {
  const done = adv.completed.length;             // 已完成的进度 id
  const root = adv.get('minecraft:story/root');
  if (root) {
    const { title, frame } = root;               // 展示数据
    const { done: finished, remaining } = root.progress ?? {};
  }
}

// 准星选取：交互距离内指向的目标
const aim = player.self?.target;
if (aim?.hit) {
  if (aim.block) await player.self.interactBlock(aim.block.pos);
  else if (aim.entity) await player.self.interactEntity(aim.entity);
}
```
