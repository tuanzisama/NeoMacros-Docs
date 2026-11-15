---
title: "chat"
description: "neo.chat：聊天输出服务。say 发往所连服务器；log 与 actionbar 仅本地渲染。文本类成员接受 TextComponent | string：组件在其表面支持处按完整样式渲染，字符串按纯文本渲染。"
---

:api-module-header{ category="界面" neo-name="neo.chat" since="0.1.0" mc="*" loader="*"}

## Methods

::api-method

### `actionbar`

在快捷栏上方的动作条显示消息；组件按完整样式渲染。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `message` | :api-type{text='TextComponent \| string' refs='TextComponent=classes/textcomponent'} | 消息文本或组件 | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `getWidth`

文本在聊天字体下的渲染像素宽度。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `text` | `string` | 文本 | — | — |

**Returns** `number`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `log`

仅在本地聊天栏打印消息；组件按完整颜色/装饰/悬停/点击渲染。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `message` | :api-type{text='TextComponent \| string' refs='TextComponent=classes/textcomponent'} | 消息文本或组件 | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `say`

以玩家身份向服务器发送聊天消息。组件按纯文本形态发送（服务器聊天是纯文本）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `message` | :api-type{text='TextComponent \| string' refs='TextComponent=classes/textcomponent'} | 消息文本或组件 | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `title`

显示标题（与可选副标题）覆盖层；null 行跳过，非 null 时长（tick）覆盖原版渐变时间。行可为组件或字符串。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `title` | :api-type{text='TextComponent \| string' refs='TextComponent=classes/textcomponent'} | 主标题（可省） | ✓ | — |
| `subtitle` | :api-type{text='TextComponent \| string' refs='TextComponent=classes/textcomponent'} | 副标题（可省） | ✓ | — |
| `fadeIn` | `number` | 淡入 tick（可省） | ✓ | — |
| `stay` | `number` | 停留 tick（可省） | ✓ | — |
| `fadeOut` | `number` | 淡出 tick（可省） | ✓ | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `toast`

在屏幕角落显示系统 toast 通知；行可为组件或字符串。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `title` | :api-type{text='TextComponent \| string' refs='TextComponent=classes/textcomponent'} | 标题 | ✓ | — |
| `message` | :api-type{text='TextComponent \| string' refs='TextComponent=classes/textcomponent'} | 正文 | ✓ | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

