---
title: "java"
description: "neo.java：宿主 JVM 的穿透层。类查找使用二进制名（Minecraft 类为 Mojmap 名，调用点经映射层翻译）；本模块全部能力需 java 权限——授予权限即交给脚本完整宿主访问，无类过滤。构造经类代理的 new(...) 成员完成，结果包装为对象代理，其成员直达未包装的 Java 字段与方法。"
---

:api-module-header{ category="系统" neo-name="neo.java" since="0.1.0" mc="*" loader="*"}

## Methods

::api-method

### `fromList`

把宿主集合逐元素转为脚本数组。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `javaCollection` | :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'} |  | — | — |

**Returns** :api-type{text='Array<JsonValue \| JavaObject>' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `proxy`

构造实现指定接口的宿主对象，方法调用派发给处理表中的函数（void 派发；未处理的方法抛错）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `interfaces` | `Array<string> | string` | 接口二进制名列表 | — | — |
| `handlers` | `Record<string, Function>` | 方法名到函数的映射 | — | — |

**Returns** :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'} — 宿主代理对象

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `toArray`

把脚本数组转为指定组件类型的宿主数组（空名 → Object[]）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `scriptArray` | :api-type{text='Array<JsonValue \| JavaObject>' refs='JavaObject=classes/javaobject'} |  | — | — |
| `componentTypeName` | `string` |  | — | — |

**Returns** :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `toList`

把脚本数组包装为宿主 List 对象，可传回 Java API。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `scriptArray` | :api-type{text='Array<JsonValue \| JavaObject>' refs='JavaObject=classes/javaobject'} |  | — | — |

**Returns** :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `type`

按二进制名查找宿主类；返回的类代理可直接读静态成员并以 new(...) 构造实例。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `className` | `string` |  | — | — |
| `alternate` | `string` |  | — | — |

**Returns** :api-type{text='JavaClass' refs='JavaClass=classes/javaclass'} — 类代理

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `wrap`

把原始宿主对象包装为已注册的句柄（实体句柄、方块状态数据等）；未注册类型返回 null。与各句柄的 raw 穿透口互逆。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `raw` | :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'} | 宿主原始对象 | — | — |

**Returns** `object` — 包装句柄或 null

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

