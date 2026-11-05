热循环的分段计时——measure 两端可传 mark 名或原始时间戳：

```js
const { performance } = neo.performance;

performance.mark("batch");
for (let i = 0; i < 100; i++) processOne();
const batch = performance.measure("batch-x100", "batch");
chat.log(`100 件耗时 ${batch.duration.toFixed(2)}ms`);

// 用两个 mark 的时间戳拆分区间：
performance.mark("split");
const half = performance.measure("first-half", "batch", "split");
```

逐 tick 性能分析也不必手动清理：缓冲是每脚本 4096 条的环形（挤掉最旧），
长会话直接读取即可：

```js
events.on("tick", () => {
  performance.mark("tick-start");
  step();
  performance.measure("step", "tick-start");
});

// 随时读取最近的样本：
const recent = performance.entriesByName("step", "measure").slice(-20);
const avg = recent.reduce((sum, entry) => sum + entry.duration, 0) / recent.length;
chat.log(`step 平均 ${avg.toFixed(3)}ms`);
```
