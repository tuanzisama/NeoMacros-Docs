Register a client command with typed argument slots and dispatch another command as if typed (register and execute require the command permission).

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
