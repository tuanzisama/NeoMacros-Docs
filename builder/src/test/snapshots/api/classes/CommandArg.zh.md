---
title: "CommandArg"
description: "注册命令的一个类型化参数槽。槽位经动态 command.arg 工厂构建（int() float() bool() word() string() greedy() player() pos()），可链式 optional() 与 default(v)。解析按声明顺序对原始余串进行；greedy 吞掉剩余全部。"
---

::api-declaration{ kind="handle" name="CommandArg"}
::

## Methods

::api-method

### `defaultTo`

为可选槽位提供回退值。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `value` | `number | string | boolean` |  | — | — |

**Returns** :api-type{text='CommandArg' refs='CommandArg=classes/commandarg'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `optional`

将槽位标记为可选（输入缺失时回退，不抛错）。

**Returns** :api-type{text='CommandArg' refs='CommandArg=classes/commandarg'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

