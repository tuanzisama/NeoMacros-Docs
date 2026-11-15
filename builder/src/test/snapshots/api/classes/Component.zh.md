---
title: "Component"
description: "不可变 的构建器；脚本富文本的唯一构造路径。样式方法就地修改草稿并返回同一 builder；build() 非破坏——草稿可继续链式修改后再次产出。点击动作与悬停内容互斥，后设的覆盖先设的。"
---

::api-declaration{ kind="data" name="Component" ctor="new Component(text: string)"}
::

## Methods

::api-method

### `append`

追加一个子节点：另一个草稿（立即 build）、已建成值或纯文本。子节点继承本节点样式，除非自行设置。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `child` | :api-type{text='Component \| TextComponent \| string' refs='Component=classes/component,TextComponent=classes/textcomponent'} | 子草稿、子组件或纯文本 | — | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `bold`

设为粗体（无参调用默认 true）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `value` | `boolean` | true/false；缺省视为 true | ✓ | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `build`

产出不可变组件；草稿仍可继续使用。

**Returns** :api-type{text='TextComponent' refs='TextComponent=classes/textcomponent'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `clickCommand`

点击以本地玩家身份执行命令。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `command` | `string` | 命令 | — | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `clickCopyToClipboard`

点击把文本复制到剪贴板。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `text` | `string` | 要复制的文本 | — | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `clickSuggestCommand`

点击把命令填入聊天输入框而不发送。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `command` | `string` | 命令 | — | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `clickUrl`

点击在浏览器打开链接（原版确认提示照常）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `url` | `string` | 目标链接 | — | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `color`

设置颜色：原版格式色名或 #rrggbb。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `value` | `string` | 色名或十六进制颜色 | — | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `copyFrom`

以现有组件为底稿拷贝内容、自有样式与子节点，随后链式调用逐项覆盖。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='TextComponent' refs='TextComponent=classes/textcomponent'} | 要拷贝的组件 | — | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `hover`

设置文本悬停；覆盖已有的物品悬停。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `text` | `string` | 悬停文本 | — | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `hoverItem`

设置物品悬停；覆盖已有的文本悬停。字符串按物品 id（数量 1）；ItemStack 按完整快照。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `item` | :api-type{text='ItemStack \| string' refs='ItemStack=classes/itemstack'} | 物品 id 或 ItemStack | — | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `italic`

设置斜体的开或关。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `value` | `boolean` | true/false；缺省视为 true | ✓ | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `obfuscated`

设置混淆字符的开或关。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `value` | `boolean` | true/false；缺省视为 true | ✓ | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `strikethrough`

设置删除线的开或关。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `value` | `boolean` | true/false；缺省视为 true | ✓ | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `underlined`

设置下划线的开或关。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `value` | `boolean` | true/false；缺省视为 true | ✓ | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

**Example**

```js
const comp = new Component("警告：")
  .color("red")
  .bold(true)
  .append(new Component("库存不足").underlined())
  .build();
chat.log(comp);
```

