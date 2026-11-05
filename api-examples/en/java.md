Reach into the host JVM — this requires the java permission; class proxies expose statics directly and construct through new(...).

```js
const { java } = neo;

// Requires the java permission: full host JVM access, no class filtering
const UUID = java.type('java.util.UUID');
const token = UUID.randomUUID().toString(); // statics dispatch directly

const ArrayList = java.type('java.util.ArrayList');
const list = ArrayList.new(); // construct through the new(...) member
list.add('torch'); // instance methods via the object proxy
```
