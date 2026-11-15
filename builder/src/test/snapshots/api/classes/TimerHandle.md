---
title: "TimerHandle"
description: "Handle of one pending or repeating timer created through the thread module; cancelling stops the schedule (idempotent)."
---

::api-declaration{ kind="handle" name="TimerHandle"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `active` | `boolean` | Whether the timer is still scheduled (or mid-fire). :api-badge{kind="readonly"} |

## Methods

::api-method

### `cancel`

Cancels the timer; later fires never run.

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

