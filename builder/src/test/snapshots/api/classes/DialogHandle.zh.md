---
title: "DialogHandle"
description: "对话框句柄：读取实时解析，动作在主线程派发。"
---

::api-declaration{ kind="handle" name="DialogHandle" wraps="net.minecraft.server.dialog.Dialog"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `actions` | :api-type{text='Array<DialogAction>' refs='DialogAction=classes/dialogaction'} | 动作按钮（按展平点击顺序）。 :api-badge{kind="readonly"} |
| `body` | `Array<string>` | 对话框正文文本（按序）。 :api-badge{kind="readonly"} |
| `canCloseWithEscape` | `boolean` | 是否可按 Esc 关闭。 :api-badge{kind="readonly"} |
| `inputs` | :api-type{text='Array<DialogInput>' refs='DialogInput=classes/dialoginput'} | 声明的输入控件。 :api-badge{kind="readonly"} |
| `kind` | `string` | 对话框类别（notice、confirmation、multi_action 等）。 :api-badge{kind="readonly"} |
| `title` | `string` | 对话框标题。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `clickAction`

按展平序号点击动作按钮（脚本弹窗会以该动作 id 落定 showDialog 的 future）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `index` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc=">=1.21.6" loader="*"}

::

::api-method

### `close`

关闭对话框（Esc 路径；脚本弹窗以 null 落定 showDialog）。

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc=">=1.21.6" loader="*"}

::

