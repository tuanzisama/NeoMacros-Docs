# HUD、世界渲染与客户端命令(中文参考)

完整指南:https://neomacros.tuanzi.ink/zh-cn/guide/hud-rendering 与
https://neomacros.tuanzi.ink/zh-cn/guide/commands

## HUD 文本(neo.hud)

`hud.addText` 接收稳定 id、文本、屏幕像素坐标、ARGB 颜色:

```js
hud.addText('greeting', 'Hello, HUD!', 8, 8, 0xFFFFFFFF);   // 不透明白
```

- **ARGB 整数**:首对十六进制是 alpha,依次 R、G、B。
  `0xFFFFFFFF` 不透明白 / `0xFF00FF00` 不透明绿 / `0x80FFFFFF` 半透明白。
- **没有单独的更新调用**:同 id 再次 `addText` 原位替换。典型更新循环
  重写同一 id 即可;`hud.removeText(id)` 删除,`hud.textIds()` 列出全部。
- 脚本卸载时文本随之消失,跨重载不泄漏。

## 世界线框(neo.render)

`neo.render` 在命名图层上以世界坐标画线框:

```js
const base = player.self?.pos?.floor();       // 脚下方块
if (base) {
    render.drawBox('marker', base, base.withY(base.y + 1), 0xFF00FF00);
    render.drawLine('marker', base, base.withY(base.y + 2), 0xFFFFFF00);
}
render.clearLayer('marker');                  // 清一层
render.layerIds();                            // 列出有形状的层
```

- `drawBox(layerId, min, max, color)` 需两个对角,`drawLine(layerId,
  from, to, color)` 需两端点,都是 [Pos3D](https://neomacros.tuanzi.ink/en/api/classes/pos3d)
  值——从 `player.self.pos`、`world.blockAt(x,y,z).pos`、射线命中等处取,
  用 `floor()`、`withX/Y/Z()`、`add()` 变形。
- 形状按层累积;脚本卸载时各层自动清空。

## 从 tick 稀疏更新

屏幕与世界覆盖**不需要每帧重画**。用带守卫的 `tick` 订阅驱动:

```js
let n = 0;
events.on('tick', () => {
    n += 1;
    if (n % 10 !== 0) return;          // 每秒 2 次,不是 20 次
    const p = player.self;
    if (!p) return;                    // 不在世界里时无东西可画
    const pos = p.pos;
    hud.addText('coords', `${pos.x.toFixed(0)} ${pos.y.toFixed(0)} ${pos.z.toFixed(0)}`, 8, 8, 0xFFFFFFFF);
});
```

早退几乎零成本;同 id 替换保证显示正确且条目不累积。

## 客户端命令(neo.command,需 command 权限)

声明式规格 + 类型化参数槽 + 收到解析值的处理器:

```js
export function startup() {          // 放 services 脚本:激活时跑一次
    command.register({
        name: 'greet',
        description: 'Greets someone, N times',
        args: {
            target: command.arg.player(),
            times: command.arg.int().defaultTo(1),
            note: command.arg.greedy().optional(),
        },
        handler(ctx) {
            for (let i = 0; i < ctx.args.times; i++) {
                chat.log(`Hello, ${ctx.args.target}!`);
            }
        },
    });
}
```

### 八种参数槽

| 类型 | 消耗 |
| --- | --- |
| `int()` | 整数 |
| `float()` | 小数 |
| `bool()` | `true` / `false` |
| `word()` | 单个词 |
| `string()` | 单个词,按字符串 |
| `greedy()` | 剩余全部(放最后) |
| `player()` | 玩家风格名字 |
| `pos()` | 方块坐标 |

**松紧修饰符**:`.optional()` 缺输入时该键缺席(不是占位符);
`.defaultTo(v)` 缺输入时回退到 v。**是 `defaultTo`,不是 `default`**。
必填槽没有输入可消耗时解析报错,命令失败。`greedy` 吞掉含空格的整个
剩余串,放最后一个槽。

### 处理器上下文

- `ctx.args` — 按槽名取的类型化值(槽是 `int()` 时取出来就是数字)
- `ctx.raw` — 命令名之后的原始剩余串,未加工

### 注销

`register` 返回不透明句柄;按句柄或按名字都可注销:

```js
const handle = command.register({ name: 'greet', /* ... */ });
command.unregister(handle);    // 或 command.unregister('greet')
```

注销本身不需要权限。条件性存在的命令围绕条件 register/unregister,
不要常驻。注册与程序化执行需要 `command` 权限 + 玩家信任。
