# API 术语表(中文参考)

完整版:https://neomacros.tuanzi.ink/zh-cn/api/glossary

## 类与值

### Handle(句柄)

游戏对象的活引用。句柄 getter 每次访问都重查游戏状态,消失的实体读回
`undefined` 而不是抛错。`snapshot()` 把当前值冻结成普通 record
(Entity → EntitySnapshot)。类页声明框以 `Handle` 徽章标记。
例:Player、FileHandle。

### Data(数据)

不可变纯数据类——坐标、方块、物品栈、文本。值不会被悄悄改掉,JSON 安全,
可随意存储、比较、序列化。例:Pos2D、BlockPos、ItemStack、Text。

### Record(记录)

普通复合类型,渲染为字段表——无方法、无活状态。主要出现在签名与事件
载荷里。例:EntitySnapshot、Pos3D。类页以 `Record` 徽章标记。

## 事件

### Event(事件)

脚本可订阅的游戏侧发生,经 events 门面(`on` / `once` / `waitFor`)。
事件名驼峰且带域前缀,如 `player:attackBlock`。事件页列出载荷与是否
可取消;订阅随脚本卸载自动清理。

### Payload(载荷)

处理器收到的冻结事件对象——`…Event extends BaseEvent` 实例,字段携带
细节。只读;每个载荷在侧栏 Classes & types 组有自己的页面,如
ChatSendEvent。

### Cancellable(可取消)

可被否决的事件徽章:处理器返回 truthy `cancel` 即阻止原版动作
(拦截聊天发送、攻击……)。不可取消的事件照常发生。

## 模块与暴露

### Facade module(门面模块)

一个域的脚本可见表面——`chat`、`world`、`hud`……每个一页,按类别分组在
侧栏 Modules 树。门面是脚本触碰游戏的唯一途径,一切挂在 `neo.<module>`。

### Global object(全局对象)

每个门面以 `neo.<module>` 暴露在全局对象上,最简单的脚本无需 import
(`neo.chat.log("hi")`);所有脚本可见类挂在同一根(`neo.Entity`、
`neo.Pos3D`)。配 `neomacros.d.ts` 获得编辑器自动补全。

## 可用性与徽章

### 可用性徽章(三枚)

每个模块与成员带三枚:**NeoMacro**(引入的发布版)、**Minecraft**(下方
表达式的版本可用性)、**Fabric Loader**。`*` 表示全部。

### MC 版本表达式

Minecraft 徽章背后的值(模组侧 `@ApiMC`):`*` 全版本、比较式
`>=1.20.6`、闭区间 `1.18-1.21`、精确版本。版本矩阵页把每个表达式对每个
受支持构建求值。

### Read-only(只读)

属性徽章:该属性观察脚本不可赋值的状态(实体的 `eyePos`、键绑定的
绑定键)。

### Experimental(实验性)

徽章警告该成员可能在发布之间变动或消失——可用,但不是稳定性承诺。

### Permission(权限)

逃生口(文件系统、网络、JVM 互操作、反射)跑在信任系统后;权限徽章
标明脚本需要的授予。参见权限与信任指南。

## 平台背景

### GraalJS

Oracle GraalVM 的 JavaScript 引擎。NeoMacros 内嵌它作为客户端脚本运行时,
脚本既能以普通 JavaScript 工作,又能(经受限逃生口)与真实 Java 对象
互传值。

### Fabric(Fabric Loader)

NeoMacros 发布所用的轻量模组加载器生态;**Fabric Loader** 徽章记录模组
构建所对准的加载器版本。NeoMacros 本身是客户端侧 Fabric 模组。

### One build per Minecraft version(每版本一个构建)

NeoMacros 对每个受支持的 Minecraft 版本发布一个 jar(客户端内部在版本
间移动);模组的 Stonecutter 配置编排同一份源码跨版本编译。版本矩阵就是
由此得到的兼容图。

### `neomacros.d.ts`

镜像整个生成 API 的 TypeScript 定义文件,放在脚本旁即可获得自动补全与
类型检查。下载:https://neomacros.tuanzi.ink/neomacros.d.ts
