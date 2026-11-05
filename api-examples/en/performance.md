Segment timing around a hot loop — measures accept mark names or raw timestamps:

```js
const { performance } = neo.performance;

performance.mark("batch");
for (let i = 0; i < 100; i++) processOne();
const batch = performance.measure("batch-x100", "batch");
chat.log(`100 items in ${batch.duration.toFixed(2)}ms`);

// Split one span using the timestamps of two marks:
performance.mark("split");
const half = performance.measure("first-half", "batch", "split");
```

Per-tick profiling stays cheap: the buffer is a per-script ring of the
newest 4096 entries, so long sessions never need manual cleanup:

```js
events.on("tick", () => {
  performance.mark("tick-start");
  step();
  performance.measure("step", "tick-start");
});

// Read the latest samples whenever you want:
const recent = performance.entriesByName("step", "measure").slice(-20);
const avg = recent.reduce((sum, entry) => sum + entry.duration, 0) / recent.length;
chat.log(`avg step ${avg.toFixed(3)}ms`);
```
