跨重载持久化脚本状态：读取、写入、检查与删除键值，值须为可 JSON 序列化的纯数据。

```js
const { storage } = neo;

// Values must be JSON-serializable; the store survives reloads and restarts
let stats = storage.get('stats') ?? { kills: 0, deaths: 0 };

stats.kills += 1;
storage.put('stats', stats);

if (storage.has('obsolete')) {
  storage.remove('obsolete'); // drop keys the new version no longer uses
}
```
