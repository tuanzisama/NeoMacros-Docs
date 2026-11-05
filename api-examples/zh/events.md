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
