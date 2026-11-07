# 异步线程与持久化存储(中文参考)

完整指南:https://neomacros.tuanzi.ink/zh-cn/guide/async-threading 与
https://neomacros.tuanzi.ink/zh-cn/guide/storage

## 线程模型

每个脚本拥有独立事件循环。Promise、`async`/`await`、计时器都在这条循环
上运行——一个脚本 sleep 五秒不影响任何其他脚本。调度原语在 `neo.thread`。

### 用等待代替阻塞

```js
await thread.sleep(1000);    // 真实毫秒,与游戏 tick 无关
await thread.ticks(20);      // 20 个客户端 tick
await thread.nextTick();     // 当前 tick 结束时
```

`sleep` 按墙钟计时;`ticks` / `nextTick` 按 tick 边界。行为要跟随游戏
节奏用 ticks,跟随真实时间用 sleep。

### 主线程调度(最重要的一条规则)

Minecraft 的世界与实体状态在游戏主线程上。脚本的异步代码在脚本循环上
运行,可能在游戏写入同一状态时醒来——从异步代码读写游戏状态就是与客户端
本体竞态。

```js
const health = await thread.runOnMain(() => neo.player.self?.health);
```

`thread.runOnMain(task)` 在主线程执行函数,Promise 以返回值落定;已在
主线程时内联执行。**经验法则:计算与等待留在脚本循环,一切游戏状态读写
放进 `runOnMain`。**

### 定时与循环

四个调度函数都返回可 cancel 的句柄:

- `thread.after(millis, task)` — 延迟执行一次
- `thread.every(millis, task)` — 重复执行直到取消
- `thread.afterTick(count, task)` / `thread.everyTick(count, task)` — tick 边界版本

```js
const beat = thread.every(5000, () => chat.actionbar('still here'));
thread.after(60000, () => beat.cancel());
```

`TimerHandle.cancel()` 停止未决与后续运行。

### 保持 startup 响应

`startup` 可以是 async,await 不会拖慢游戏。真正卡死循环的是同步忙等:
没有 `await` 的紧密 `while` 让自己的计时器和事件处理器全部排队。

```js
export async function startup() {
    while (true) {
        await thread.ticks(40);                  // 每 2 秒让出
        chat.actionbar(`fps ${Math.round(neo.client.fps)}`);
    }
}
```

每次迭代一个 `await`;重载时循环随模块干净拆除。

## 持久化存储

每个脚本在 `neo.storage` 上有隔离键值仓:只存 JSON 可序列化值,
跨 `/neomacros reload` 与重启保留,按脚本隔离(别的脚本读写不到你的键)。

### 四个成员

```js
storage.put('joined', true);            // 写
const v = storage.get('joined');        // 读,缺失返回 null
storage.has('joined');                  // 存在?
storage.remove('joined');               // 删一个键
```

`put(key, null)` 也删除键。仓库按脚本源文件定位——文件夹改名但入口文件
名不变时数据保留。

### 只存可序列化数据

仅限纯 JSON:对象、数组、字符串、数字、布尔,`null` 表示删除。类实例、
Map、函数、活句柄都存不了。存位置要存字段而不是句柄:

```js
const p = player.self.pos;
storage.put('lastPos', { x: p.x, y: p.y, z: p.z });
```

存入不可序列化数据是最常见的 storage bug;`JSON.stringify` 能活着往返
的值才是合法的。

### 设置对象模式

```js
const DEFAULTS = { welcome: true, warnHealth: 6 };

export function startup() {
    const saved = storage.get('settings') ?? {};
    const settings = { ...DEFAULTS, ...saved };    // 默认在下,保存的在上
    storage.put('settings', settings);
}
```

`?? {}` 兜首跑;展开顺序让保存文件只需携带被改动过的字段,新增默认字段
对老用户自动生效。

### 计数器与冷却

```js
const n = (storage.get('msgCount') ?? 0) + 1;
storage.put('msgCount', n);

const now = Date.now();                       // Date.now() 可用
const last = storage.get('lastPing') ?? 0;
if (now - last < 5000) return;                // 5 秒冷却未过
storage.put('lastPing', now);
```

**写放大**:`tick` 里每 tick 写存储等于每秒 20 次写——先用局部变量累计,
定期刷入。

### storage 还是文件

storage 适合脚本自己读回的结构化状态(设置、计数、冷却、缓存),无需
权限、对玩家不可见。给人看的数据(笔记、日志、导出)用 `neo.fs` 写文件,
但需要 `fs` 能力与对应信任。
