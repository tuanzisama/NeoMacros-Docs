Subscribe on the event bus: register a listener, wait for one qualifying firing, and unsubscribe by handle when done.

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

Intercept cancellable events with `events.onSync`: the handler receives a
writable payload — rewrite whitelisted fields, cancel with `e.cancel()`,
and order the chain with `neo.EventPriority` priorities.

```js
events.onSync('chat:send', (e) => {
  if (e.message === 'spam') e.cancel();          // veto the send
  if (e.message === 'typo') e.message = 'fixed'; // rewrite the outgoing text
}, { priority: neo.EventPriority.HIGH, ignoreCancelled: true });
```
