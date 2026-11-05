注册带类型参数槽的客户端命令，并以玩家身份派发另一条命令（register 与 execute 需要 command 权限）。

```js
const { command } = neo;

// register/execute both require the 'command' permission
command.register({
  name: 'mine',
  description: 'Announce a mining route',
  args: {
    ore: command.arg.word(), // required word slot
    seconds: command.arg.int().optional(),
  },
  handler(ctx) {
    // ctx.args: parsed values (ctx.args.ore); ctx.raw: the remainder string
  },
});

await command.execute('/neomacros list'); // dispatch as if typed
```
