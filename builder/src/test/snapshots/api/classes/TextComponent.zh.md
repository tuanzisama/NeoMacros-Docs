---
title: "TextComponent"
description: "不可变富文本节点：字面内容加可选颜色、装饰、悬停内容、点击动作与嵌套子节点。由 build() 产出；也作为 chat:receive 的事件载荷。JSON.stringify 输出原版组件树（{text, color, …, extra: [...]}）。"
---

::api-declaration{ kind="data" name="TextComponent"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `children` | :api-type{text='Array<TextComponent>' refs='TextComponent=classes/textcomponent'} | 按序嵌套的子节点。 :api-badge{kind="readonly"} |
| `content` | `string` | 本节点的字面内容。 :api-badge{kind="readonly"} |
| `plain` | `string` | 整棵树的纯文本拼接。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `toJSON`

JSON.stringify 使用的原版组件树渲染；未设置的样式键省略。

**Returns** `string`

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

**Example**

```js
const link = new Component("点我回城")
  .clickCommand("/home")
  .hover("传送到主城")
  .build();
```

