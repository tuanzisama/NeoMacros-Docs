用 after 把一阵高频调用防抖合并成一次延迟执行，再用 sleep 在异步流程中按真实时间暂停。

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
