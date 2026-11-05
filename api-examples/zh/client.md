读取进程级客户端事实；访问原始客户端入口 minecraft 需要 java 权限。

```js
const { client } = neo;

// Process-level facts, readable at any time
if (client.fps < 30) {
  // client is struggling — skip heavy per-tick work
}
const version = client.gameVersion; // the game version string

// Escape hatch to the raw client; requires the java permission
const mc = client.minecraft; // ≙ java.type('net.minecraft.client.Minecraft').getInstance()
```
