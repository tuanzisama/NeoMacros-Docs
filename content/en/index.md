---
title: NeoMacros
description: ECMAScript client scripting for Minecraft (Fabric)
---

::u-page-hero
#title
NeoMacros
#description
Client-side scripting for Minecraft with plain JavaScript. Write ES modules,
hook into 49 game events, draw HUD overlays, and automate anything — all
sandboxed behind an explicit permission model.
#links
  :::u-button
  ---
  size: xl
  to: /en/guide/getting-started
  trailing-icon: i-lucide-arrow-right
  ---
  Get started
  :::

  :::u-button
  ---
  color: neutral
  size: xl
  to: /en/examples/overview/
  variant: outline
  ---
  Examples
  :::

  :::u-button
  ---
  color: neutral
  size: xl
  to: /en/api/overview/
  variant: outline
  ---
  API Reference
  :::
::

::u-page-section
  :::u-page-grid
    ::::u-page-card
    ---
    spotlight: true
  to: /en/guide/first-script
    ---
    #title
    Real JavaScript, not a dialect
    #description
    Powered by GraalJS: ES modules, promises, async/await, and a real event
    loop per script. Debug with familiar tooling and the generated
    `neomacros.d.ts` type definitions.
    ::::

    ::::u-page-card
    ---
    spotlight: true
  to: /en/guide/events
    ---
    #title
    Hook into the game
    #description
    49 client events across chat, player, entity, world, input, and screen
    domains — subscribe with `neo.events.on`, filter high-frequency streams,
    and cancel actions at the boundary.
    ::::

    ::::u-page-card
    ---
    spotlight: true
  to: /en/guide/hud-rendering
    ---
    #title
    Draw on screen and in world
    #description
    Persistent HUD text overlays and world-space wireframes that survive
    across frames, cleaned up automatically when your script unloads.
    ::::

    ::::u-page-card
    ---
    spotlight: true
  to: /en/guide/permissions-trust
    ---
    #title
    Sandboxed by design
    #description
    Filesystem, network, and Java interop are capability-gated. You grant
    each script exactly what it needs — nothing more — through the trust
    system.
    ::::

    ::::u-page-card
    ---
    spotlight: true
  to: /en/guide/storage
    ---
    #title
    Persistent state included
    #description
    Every script owns an isolated JSON store that survives reloads and game
    restarts. No files to manage, no schema to migrate.
    ::::

    ::::u-page-card
    ---
    spotlight: true
  to: /en/api/version-matrix
    ---
    #title
    One codebase, every version
    #description
    NeoMacros builds for Minecraft 1.18.2 through 26.3 from the same source.
    The API surface is documented per version in the compatibility matrix.
    ::::
  :::
::

::u-page-section
---
links:
  - label: Write your first script
  to: /en/guide/first-script
    size: lg
    trailing-icon: i-lucide-arrow-right
---
#title
Ready in five minutes
#description
Install the jar, drop a script folder into `config/neomacros/macros`, and
reload — no build step, no toolchain.
::
