Send one message to the server while keeping other output strictly local.

```js
const { chat, Component } = neo;

// say() targets the server, as if typed by the player (commands too)
chat.say('/home');

// log() and actionbar() render locally and never reach the server
chat.log('Only you can read this line');
chat.actionbar('Follow the torch markers'); // drawn above the hotbar
```

Rich text is built with `Component`: chain the style setters, `append`
children, and `build()` produces the immutable `TextComponent`.

```js
const { chat, Component } = neo;

// A simple styled line
chat.log(new Component('Warning:').color('red').bold(true));

// Composition + interaction: click to warp, hover for a tooltip
const link = new Component('Click to warp home')
  .clickCommand('/home')
  .hover('Teleports to the main base')
  .underlined();

chat.actionbar(new Component('System:').color('#ffaa00').append(link));

// Echo: splice a TextComponent received from chat:receive into a new message
neo.events.on('chat:receive', (e) => {
  if (e.message.plain.includes('refresh')) {
    chat.say(new Component('Refreshing…').append(e.message));
  }
});
```
