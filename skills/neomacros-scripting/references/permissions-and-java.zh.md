# 权限信任与 Java 互操作(中文参考)

完整指南:https://neomacros.tuanzi.ink/zh-cn/guide/permissions-trust 与
https://neomacros.tuanzi.ink/zh-cn/guide/java-interop

## 沙箱模型

脚本跑在沙箱里。读世界状态、输出聊天、画覆盖层、定时器**永远允许**
(基础面);越出基础面的能力必须由脚本声明、由玩家授予。

### 受限能力表

| 权限 | 解锁 |
| --- | --- |
| `fs` | `neo.fs` 全部成员:`readText`、`writeText`、`readJSON`、`writeJSON`、`list`、`mkdir`、`delete` 等(限定游戏目录内) |
| `net` | `neo.net` 全部成员:`fetch`、`get`、`post` |
| `command` | `neo.command.register` 与 `neo.command.execute` |
| `java` | `neo.java`、`neo.reflect`、`neo.client.minecraft` |

前三个是范围化能力——授 `fs` 只解锁文件访问。**`java` 不同:无类过滤的
完整宿主访问**,是最高信任级别,只授予已通读的脚本。

### 声明与授予

```yaml
# neomacro.yml
name: backup-notes
version: 1.0.0
author: you
description: keeps a running note file
permissions: ["fs"]

config:
  event:
    on: [chat:receive]
```

- 无 `permissions`(或空表)的脚本纯跑基础面,**永不触发弹窗**。
- 未知能力名被信任门拒绝——拼错是 fail-closed,不会悄悄扩权。
- 首次加载带声明的脚本时,聊天弹窗列出请求;决定前脚本跑在拒绝视图下,
  受限调用抛错。点弹窗或手动 `/neomacros trust <script>`。
- **信任按内容哈希锚定**:编辑文件即改哈希,受信脚本不可能悄悄长出新
  能力——弹窗重现,复查后再批。决定存 `config.json`,跨重启保留。
  改完重新 trust 是正常流程,弹窗就是复查步骤。

### 未授信脚本做不了什么

- 不能经 `neo.fs` 读写任何文件
- 不能经 `neo.net` 发起任何网络请求
- 不能注册或执行客户端命令
- 不能碰 `neo.java`、`neo.reflect`、`neo.client.minecraft`

基础面全保留:事件、计时器、聊天输出、世界与玩家读取、HUD/render
覆盖层、自己的 `neo.storage`。被拒调用在触发时抛错,显示在
`/neomacros errors`。

### 最小授权

只授脚本实际用到的;优先声明少的脚本。信别人的脚本前先读清单——
`permissions` 行告诉你代码里该盯什么。要 `java` 的脚本值得通读,
什么都不要的可以原样跑。

## Java 互操作(neo.java / neo.reflect)

:::warning
`java` 权限 = 完整宿主访问:JVM 上每个类、无过滤、经反射的任意代码。
:::

`neo.java` 是绕过策划门面的逃生口——通到游戏所在 JVM 的桥。适用:门面
不覆盖的原版内部、需要 Java 库、照搬社区里针对 Minecraft 类写的配方。

### 按二进制名查类

`java.type` 按点分名解析类,返回类代理。Minecraft 类名用 **Mojmap**
映射名,调用点自动翻译,与运行时 jar 无关:

```js
const UUID = java.type('java.util.UUID');
const id = UUID.randomUUID();          // 静态成员直接在代理上分发
chat.log(id.toString());               // 宿主对象以对象代理回入脚本

const File = java.type('java.io.File');
const f = File.new('config/neomacros');   // 构造走代理的 new 成员
```

反向桥:`java.proxy(interfaces, handlers)` 构造宿主对象,其方法分发到
脚本函数。

### 集合边界

脚本数组与 Java 集合不隐式互转,三个转换器覆盖:

```js
java.toList(['a', 'b']);                    // 脚本数组 → 活 java.util.List
java.fromList(someJavaCollection);          // 宿主集合 → 脚本数组
java.toArray(['a'], 'java.lang.String');    // 脚本数组 → 类型化宿主数组
```

### reflect 精确签名

`neo.reflect` 解析确切声明——私有成员、特定重载都可以:

```js
const m = reflect.method(target, 'getSender', ['int']);   // 精确重载
const v = reflect.invoke(m, target, [42]);                // 静态省略 target
const obj = reflect.newInstance('java.util.ArrayList');
reflect.className(v);                                     // 任意值的运行时类
```

代理查找看不见的成员靠反射调用;同样骑在 `java` 权限上。

### 原始客户端入口

原版内部配方的通常起点:`neo.client.minecraft`(需 java 权限)把原始
客户端作为对象代理交给你,等价于
`java.type('net.minecraft.client.Minecraft').getInstance()`。
**游戏状态属于主线程——读写包在 `thread.runOnMain` 里。**
