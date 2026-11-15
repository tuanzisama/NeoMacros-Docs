---
title: "Advancement"
description: "Live advancement handle: the display data and progress of one advancement, re-read on every access."
---

::api-declaration{ kind="handle" name="Advancement" wraps="net.minecraft.advancements.AdvancementHolder"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `description` | `string` | The display description plain text. :api-badge{kind="readonly"} |
| `frame` | `string` | The display frame (task, goal, challenge). :api-badge{kind="readonly"} |
| `hidden` | `boolean` | Whether the advancement is hidden until completed. :api-badge{kind="readonly"} |
| `id` | `string` | The namespaced advancement id. :api-badge{kind="readonly"} |
| `parentId` | `string` | The parent advancement id, or undefined on roots. :api-badge{kind="readonly"} |
| `progress` | :api-type{text='AdvancementProgress' refs='AdvancementProgress=classes/advancementprogress'} | The live progress, or undefined without server progress data. :api-badge{kind="readonly"} |
| `title` | `string` | The display title plain text. :api-badge{kind="readonly"} |

