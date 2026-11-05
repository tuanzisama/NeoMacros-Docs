---
title: NeoMacros
description: 面向 Minecraft（Fabric）的客户端 ECMAScript 脚本模组
---

::u-page-hero
#title
NeoMacros
#description
用原生 JavaScript 为 Minecraft 客户端编写脚本。ES 模块、49 个游戏事件、
HUD 覆盖层、任意自动化——全部沙箱化，由显式的权限模型守护。
#links
  :::u-button
  ---
  size: xl
  to: /zh-cn/guide/getting-started
  trailing-icon: i-lucide-arrow-right
  ---
  快速开始
  :::

  :::u-button
  ---
  color: neutral
  size: xl
  to: /zh-cn/examples/overview/
  variant: outline
  ---
  示例
  :::

  :::u-button
  ---
  color: neutral
  size: xl
  to: /zh-cn/api/overview/
  variant: outline
  ---
  API 参考
  :::
::

::u-page-section
  :::u-page-grid
    ::::u-page-card
    ---
    spotlight: true
    to: /zh-cn/guide/first-script
    ---
    #title
    真正的 JavaScript，而非方言
    #description
    基于 GraalJS：ES 模块、Promise、async/await，每个脚本拥有独立的事件
    循环。配合生成的 `neomacros.d.ts` 类型定义，用熟悉的工具链开发调试。
    ::::

    ::::u-page-card
    ---
    spotlight: true
    to: /zh-cn/guide/events
    ---
    #title
    挂钩游戏事件
    #description
    覆盖聊天、玩家、实体、世界、输入、界面共 49 个客户端事件——用
    `neo.events.on` 订阅，过滤高频事件流，并在动作边界上拦截取消。
    ::::

    ::::u-page-card
    ---
    spotlight: true
    to: /zh-cn/guide/hud-rendering
    ---
    #title
    屏幕与世界绘制
    #description
    持久化的 HUD 文本覆盖层与世界空间线框，跨帧保留，脚本卸载时自动清理。
    ::::

    ::::u-page-card
    ---
    spotlight: true
    to: /zh-cn/guide/permissions-trust
    ---
    #title
    天生沙箱化
    #description
    文件、网络与 Java 互操作全部由能力门禁控制。通过信任系统给每个脚本
    恰好所需的权限——不多一分。
    ::::

    ::::u-page-card
    ---
    spotlight: true
    to: /zh-cn/guide/storage
    ---
    #title
    内建持久化状态
    #description
    每个脚本拥有独立的 JSON 存储，重载与重启游戏后依然保留。无需管理
    文件，无需迁移数据结构。
    ::::

    ::::u-page-card
    ---
    spotlight: true
    to: /zh-cn/api/overview/version-matrix
    ---
    #title
    一份代码，全版本支持
    #description
    NeoMacros 从同一份源码构建 Minecraft 1.18.2 到 26.3 的全部版本。
    API 在各版本上的可用性见兼容矩阵。
    ::::
  :::
::

::u-page-section
---
links:
  - label: 编写你的第一个脚本
    to: /zh-cn/guide/first-script
    size: lg
    trailing-icon: i-lucide-arrow-right
---
#title
五分钟上手
#description
安装 jar，把脚本文件夹放进 `config/neomacros/macros`，重载即可——
无需构建步骤，无需工具链。
::