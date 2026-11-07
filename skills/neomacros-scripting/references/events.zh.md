# 事件系统(中文参考)

完整指南:https://neomacros.tuanzi.ink/zh-cn/guide/events
事件目录:https://neomacros.tuanzi.ink/zh-cn/api/overview (Events 分节)

## events.on 订阅

`events.on(name, handler)` 注册异步监听器,处理器在脚本自己的事件循环上
运行,收到普通对象形式的载荷:

```js
const { events, chat } = neo;

const handle = events.on('player:health', (payload) => {
    chat.actionbar(`health: ${payload.health}`);
});
```

**命名规则**:`domain:name` 驼峰式——`chat:receive`、`player:health`、
`key:press`、`world:blockUpdate`。裸的内置 `tick` 是唯一无域前缀的例外。
缺失 `domain:` 前缀(如只写 `receive`)在清单校验时即被拒。

**通配符**:`domain:*` 匹配整域,`*` 匹配全部;`tick`、`world:sound`、
`world:blockUpdate` 等高流量事件默认不参与通配符分发。

**退订**:

```js
events.off(handle);              // 按句柄
events.off('player:health');     // 或按事件名
```

模块加载期间创建的订阅归属该模块,卸载时自动退订,重载不泄漏。

## 让清单订阅(manifest 声明式)

事件宏在 `config.event.on` 声明事件,引擎对每次发生调用导出的
`startup(payload)`——与手动 `events.on` 收到同一快照对象。两种方式可共存;
services、通配符监听、自控生命周期的订阅用手动 `on`。

## onSync 同步取消

仅少数可取消事件接受同步订阅:`key:press`、`chat:send`、
`player:attackBlock`、`player:attackEntity`、`player:interactBlock`、
`player:interactEntity`。

```js
events.onSync('chat:send', (payload) => {
    return payload.message.includes('secret');   // truthy 否决发送
});
```

回调在分发线程上运行,起否决作用:返回 truthy 取消事件,falsy 放行。
必须短小——游戏在它返回前无法继续,不要 `await`、不要循环。

## 一次性等待

- `events.once(name, handler)` 只触发一次并自动退订。
- `events.waitFor(name)` 返回 Promise,以下一次载荷落定。
- `events.waitForUntil(name, filter, timeoutMillis)` 以第一个满足 filter
  的载荷 resolve,超时 reject。filter 在分发线程运行,务必轻量。

```js
try {
    await events.waitForUntil('player:health', (p) => p.health < 6, 30000);
    chat.actionbar('low health!');
} catch {
    chat.log('no low-health moment within 30s');
}
```

## 高频事件节流

`tick` 每秒 20 次,`world:blockUpdate` 每次方块状态变化都触发。用早退
守卫把昂贵工作降到最低:

```js
let n = 0;
events.on('tick', () => {
    n += 1;
    if (n % 20 !== 0) return;        // 20 tick 跳过 19 次
    chat.actionbar('once a second');
});
```

`tick` 载荷带 `count` 字段,可直接对 `payload.count` 取模,不必本地计数。

## 自定义事件

`events.register('myscript:burst')` 注册带命名空间的名字(不得遮蔽内置
域),之后 `events.emit('myscript:burst', payload)` 经异步通道投递给其他
监听器。载荷键不得用保留字 `type`、`timestamp`、`cancellable`。

## 载荷字段查询

全部内置事件的载荷字段表在 API 参考的 events 目录下,按域分组:
chat / entity / game / input / key / player / screen / tick / world,
例如 https://neomacros.tuanzi.ink/en/api/events/chat/chat-receive 。
事件名映射规则:页面 URL 为小写连字符
(`/api/events/player/player-attackblock`),事件名是驼峰
`player:attackBlock`。
