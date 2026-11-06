---
title: "reflect"
description: "The neo.reflect facade: meta-level tools for the escape layer. Where neo.java proxies objects, this facade resolves exact signatures (including private members), invokes reflectively, and constructs instances. The whole module rides the java permission gate."
---

:api-module-header{ category="System" global="true" neo-name="neo.reflect" esm-name="@neomacros/reflect" since="0.2.0" mc="*" loader="*"}

## Methods

### `className(value: unknown)`

The fully-qualified class name of any Java value (works on non-proxied values too), or undefined for undefined/null.

**Parameters**

- `value` `unknown`: 

**Returns** `string`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `field(target: unknown, name: string)`

Resolves one declared field, including private fields. Returns the java.lang.reflect.Field proxy, or undefined on a miss.

**Parameters**

- `target` `unknown`: 实例或类（JavaClass）
- `name` `string`: 字段名

**Returns** `unknown`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `invoke(method: unknown, target: unknown, args: unknown)`

Invokes one resolved reflect method. Omitting the target invokes a static method; numeric arguments convert to the declared parameter types.

**Parameters**

- `method` `unknown`: method() 返回的 Method
- `target` `unknown`: 接收者实例；静态调用省略
- `args` `unknown`: 参数数组（可省略）

**Returns** `unknown`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `method(target: unknown, name: string, paramTypes: unknown)`

Resolves one declared method with an exact parameter signature, including private overloads. Parameter types arrive as an array of class-name strings or JavaClass values. Returns the java.lang.reflect.Method proxy, or undefined on a miss.

**Parameters**

- `target` `unknown`: 实例或类（JavaClass）
- `name` `string`: 方法名
- `paramTypes` `unknown`: 参数类型数组（可省略）

**Returns** `unknown`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `newInstance(cls: unknown, args: unknown)`

Reflectively constructs one instance of the class with the matching constructor.

**Parameters**

- `cls` `unknown`: JavaClass 或类名字符串
- `args` `unknown`: 构造参数数组（可省略）

**Returns** `unknown`

:api-badges{ since="0.2.0" mc="*" loader="*"}


## Examples

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
