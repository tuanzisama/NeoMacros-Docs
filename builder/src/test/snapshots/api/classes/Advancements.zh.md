---
title: "Advancements"
description: "活进度句柄：树查询加逐条进度，每次访问实时回读。需要服务器连接（含单机内置服务端）。"
---

::api-declaration{ kind="handle" name="Advancements" wraps="net.minecraft.client.multiplayer.ClientAdvancements"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `completed` | `Array<string>` | 已全部完成的进度 id。 :api-badge{kind="readonly"} |
| `ids` | `Array<string>` | 客户端已知的全部进度 id（按注册序）。 :api-badge{kind="readonly"} |
| `roots` | `Array<string>` | 根进度 id（无父节点的进度）。 :api-badge{kind="readonly"} |
| `started` | `Array<string>` | 已开始但未完成的进度 id。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `children`

指定进度的直接子进度 id（按注册序）；未知 id 返回空列表。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `id` | `string` |  | — | — |

**Returns** `Array<string>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `get`

指定 id 的活进度句柄；未知时为 undefined。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `id` | `string` |  | — | — |

**Returns** :api-type{text='Advancement' refs='Advancement=classes/advancement'}

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

