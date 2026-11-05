深入宿主 JVM，需要 java 权限；类代理直接暴露静态成员，并经 new(...) 构造实例。

```js
const { java } = neo;

// Requires the java permission: full host JVM access, no class filtering
const UUID = java.type('java.util.UUID');
const token = UUID.randomUUID().toString(); // statics dispatch directly

const ArrayList = java.type('java.util.ArrayList');
const list = ArrayList.new(); // construct through the new(...) member
list.add('torch'); // instance methods via the object proxy
```
