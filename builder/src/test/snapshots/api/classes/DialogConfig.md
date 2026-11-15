---
title: "DialogConfig"
description: "One script-shown dialog config: the kind, the title, the body lines (string or string array), the Esc behavior, the action buttons, and the action column count."
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

