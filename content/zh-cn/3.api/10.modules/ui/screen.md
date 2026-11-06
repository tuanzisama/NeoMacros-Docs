---
title: "screen"
description: "neo.screen 门面：当前打开屏幕的元信息。脚本自建 GUI 属后续阶段设计。"
---

:api-module-header{ category="界面" global="true" neo-name="neo.screen" esm-name="@neomacros/screen" since="0.2.0" mc="*" loader="*"}

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `opened` | `Record<string, unknown>` | 当前打开的屏幕 {title, kind}；无屏幕时为 null。容器屏幕的 kind 为容器类别（chest、crafting 等），其余为 screen；容器本体经 player.opened 获取。 :api-badge{kind="readonly"} |

