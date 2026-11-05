Read and write JSON files under the game directory; every call is async and requires the fs capability.

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
