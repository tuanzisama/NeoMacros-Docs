---
title: "Advancement"
description: "活进度条目句柄：单个进度的展示数据与进度，每次访问实时回读。"
---

::api-declaration{ kind="handle" name="Advancement" wraps="net.minecraft.advancements.AdvancementHolder"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `description` | `string` | 展示描述纯文本。 :api-badge{kind="readonly"} |
| `frame` | `string` | 展示框样式（task/goal/challenge）。 :api-badge{kind="readonly"} |
| `hidden` | `boolean` | 进度是否在完成前隐藏。 :api-badge{kind="readonly"} |
| `id` | `string` | 进度的命名空间 id。 :api-badge{kind="readonly"} |
| `parentId` | `string` | 父进度 id；根进度为 undefined。 :api-badge{kind="readonly"} |
| `progress` | :api-type{text='AdvancementProgress' refs='AdvancementProgress=classes/advancementprogress'} | 实时进度；无服务器进度数据时为 undefined。 :api-badge{kind="readonly"} |
| `title` | `string` | 展示标题纯文本。 :api-badge{kind="readonly"} |

