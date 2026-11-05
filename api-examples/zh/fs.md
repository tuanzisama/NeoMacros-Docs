读写游戏目录下的 JSON 文件：全部调用为异步，且需要 fs 能力（经 /neomacros trust 授予）。

```js
const { fs } = neo;

// Requires the fs capability; paths resolve against the game directory
const path = 'config/neomacros/my-macro.json';

if (await fs.exists(path)) {
  const config = await fs.readJSON(path); // neutral JSON values
  const info = await fs.stat(path); // { size, mtimeMs, isDir, isFile }
} else {
  await fs.writeJSON(path, { enabled: true, volume: 0.5 }); // parents created
}
```
