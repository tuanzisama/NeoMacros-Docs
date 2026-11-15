---
title: "DialogConfig"
description: "脚本弹窗配置：类别、标题、正文（字符串或字符串数组）、Esc 行为、动作按钮与动作列数。"
---

::api-declaration{ kind="data" name="DialogConfig"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `actions` | :api-type{text='Array<DialogActionSpec>' refs='DialogActionSpec=classes/dialogactionspec'} |  :api-badge{kind="readonly"} |
| `body` | `string | Array<string>` |  :api-badge{kind="readonly"} |
| `canCloseWithEscape` | `boolean` |  :api-badge{kind="readonly"} |
| `columns` | `number` |  :api-badge{kind="readonly"} |
| `title` | `string` |  :api-badge{kind="readonly"} |
| `type` | `string` |  :api-badge{kind="readonly"} |

