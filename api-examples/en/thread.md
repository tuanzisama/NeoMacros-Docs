Debounce a burst of calls into one delayed run, and pause an async flow in real time.

```js
const { thread } = neo;

let scheduled = false;

// Debounce: collapse a burst of calls into one delayed run
function request() {
  if (scheduled) return;
  scheduled = true;
  thread.after(250, () => {
    scheduled = false; // do the coalesced work here
  });
}

request(); // schedules the run 250 ms out
await thread.sleep(5000); // timers double as promises
```
