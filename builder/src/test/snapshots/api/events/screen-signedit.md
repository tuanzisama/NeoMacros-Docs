---
title: "screen:signEdit"
description: "Payload of the sign-edit open event; synchronous subscribers may cancel the editor, rewrite the four lines, or set closeScreen to submit the (possibly replaced) text directly instead of opening the editor."
---

::api-event-header{ event="screen:signEdit" direction="s2c" cancellable="true" since="0.4.0" mc="*" loader="*"}
#payload
[`ScreenSignEditEvent`](../types/ScreenSignEditEvent.html)
::

**Direction**: `s2c` — server-to-client display interception: cancelling suppresses the display; whitelisted fields may be rewritten locally.

| Field | Type | Description |
| --- | --- | --- |
| `closeScreen` | `boolean` |  (rewritable on the sync channel) |
| `front` | `boolean` |  |
| `lines` | `Array<string>` |  (rewritable on the sync channel) |
| `x` | `number` |  |
| `y` | `number` |  |
| `z` | `number` |  |

