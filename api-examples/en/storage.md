Persist script state across reloads: read, write, check and remove keys whose values are JSON-serializable.

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
