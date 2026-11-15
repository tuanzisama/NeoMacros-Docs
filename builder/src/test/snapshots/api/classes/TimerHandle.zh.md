---
title: "TimerHandle"
description: "thread 定时器句柄；cancel 停止调度（幂等）。"
---

::api-declaration{ kind="handle" name="TimerHandle"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `active` | `boolean` | 定时器是否仍处于调度中。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `cancel`

取消定时器；之后的触发不再执行。

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

