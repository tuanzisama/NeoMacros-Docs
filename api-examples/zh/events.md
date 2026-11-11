订阅事件总线上的事件：注册一个监听、等待一次满足条件的触发，完成后再按句柄退订。

```js
const { events } = neo;

// React to every player join; delivery is async on the script loop
const joinHandle = events.on('player:join', (ev) => {
  // payload fields arrive on ev; subscriptions auto-drop on module unload
});

// Resolve as soon as health tops 15, or reject after 30 seconds
await events.waitForUntil('player:health', (e) => e.health > 15, 30_000);

// No longer needed? Unsubscribe by handle (or by event name)
events.off(joinHandle);
```

用 `events.onSync` 拦截可取消事件：处理器收到的载荷可写——改写白名单字段、用 `e.cancel()` 取消，并用 `neo.EventPriority` 常量排定链上顺序。

```js
events.onSync('chat:send', (e) => {
  if (e.message === 'spam') e.cancel();          // 否决这条消息
  if (e.message === 'typo') e.message = 'fixed'; // 改写上行文本
}, { priority: neo.EventPriority.HIGH, ignoreCancelled: true });
```
