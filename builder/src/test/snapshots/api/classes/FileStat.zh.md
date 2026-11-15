---
title: "FileStat"
description: "单个文件的元信息快照：字节大小、最后修改epoch毫秒与目录/常规文件标记。"
---

::api-declaration{ kind="data" name="FileStat"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `isDir` | `boolean` |  :api-badge{kind="readonly"} |
| `isFile` | `boolean` |  :api-badge{kind="readonly"} |
| `mtimeMs` | `number` |  :api-badge{kind="readonly"} |
| `size` | `number` |  :api-badge{kind="readonly"} |

