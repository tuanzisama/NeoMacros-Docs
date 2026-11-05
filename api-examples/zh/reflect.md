按精确签名（含私有成员）解析并以反射方式调用，整个模块走 java 权限门禁。

```js
const { reflect } = neo;

// Rides the java permission gate: exact signatures, private members included
const list = reflect.newInstance('java.util.ArrayList'); // class by name

// Resolve a method by exact parameter signature, then invoke reflectively
const add = reflect.method(list, 'add', ['java.lang.Object']);
reflect.invoke(add, list, ['torch']); // instance call: pass the receiver

const kind = reflect.className(list); // 'java.util.ArrayList'
```
