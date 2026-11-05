Resolve exact signatures (private members included) and invoke reflectively — the whole module rides the java permission gate.

```js
const { reflect } = neo;

// Rides the java permission gate: exact signatures, private members included
const list = reflect.newInstance('java.util.ArrayList'); // class by name

// Resolve a method by exact parameter signature, then invoke reflectively
const add = reflect.method(list, 'add', ['java.lang.Object']);
reflect.invoke(add, list, ['torch']); // instance call: pass the receiver

const kind = reflect.className(list); // 'java.util.ArrayList'
```
