---
title: "java"
description: "The neo.java facade: the escape layer over the host JVM. Class lookup uses binary names (Mojmap for Minecraft classes, translated at the call site by the mapping layer); every capability of this module requires the java permission — granting it hands the script full host access with no class filtering. Construction happens through the class proxy's new(...) member; results wrap as object proxies whose members reach unwrapped Java fields and methods."
---

:api-module-header{ category="System" global="true" neo-name="neo.java" esm-name="@neomacros/java" since="0.1.0" mc="*" loader="*"}

## Methods

### `fromList(javaCollection: unknown)`

Converts one host collection into a script array (element by element).

**Parameters**

- `javaCollection` `unknown`: 

**Returns** `unknown`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `proxy(interfaces: unknown, handlers: unknown)`

Builds one host object implementing the named interfaces, dispatching method calls to the handler map's functions (void-return dispatch; unhandled methods raise).

**Parameters**

- `interfaces` `unknown`: 接口二进制名列表
- `handlers` `unknown`: 方法名到函数的映射

**Returns** `unknown`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `toArray(scriptArray: unknown, componentTypeName: string)`

Converts one script array into a host array of the named component type (empty name → Object[]).

**Parameters**

- `scriptArray` `unknown`: 
- `componentTypeName` `string`: 

**Returns** `unknown`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `toList(scriptArray: unknown)`

Converts one script array into a host list wrapped as an interop object, so it crosses back into Java APIs as a live java.util.List.

**Parameters**

- `scriptArray` `unknown`: 

**Returns** `unknown`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `type(className: string, alternate: string)`

Looks up one host class by its binary name, e.g. java.util.UUID. The returned class proxy exposes static fields and methods directly, and new(...) constructs instances.

**Parameters**

- `className` `string`: 
- `alternate` `string`: 

**Returns** [JavaClass](../../classes/javaclass)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `wrap(raw: unknown)`

Wraps one raw host object into its registered handle (entity handles, block state data); unregistered types return null. The inverse of the handles' raw escape hatch.

**Parameters**

- `raw` `unknown`: 宿主原始对象

**Returns** `unknown`

:api-badges{ since="0.2.0" mc="*" loader="*"}


## Examples

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
