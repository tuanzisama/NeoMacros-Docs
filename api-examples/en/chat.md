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

`events.onSync` subscribes to the cancellable display events synchronously:
return a truthy value to cancel the display, or a plain object to modify it
(`{ text }` replaces the text; `{ cancel: true }` cancels explicitly).

```js
const { events } = neo;

// chat:title fires for the main title and the subtitle (ev.kind tells them
// apart); chat:actionbar fires for server action-bar packets and locally
// produced overlay hints (ev.source is 'server' or 'local').
events.onSync('chat:title', (ev) => {
  if (ev.kind === 'title' && ev.text.plain.includes('AD')) {
    return true;                    // suppress the whole display
  }
  if (ev.kind === 'subtitle') {
    return { text: 'protected by neomacros' };  // replace the subtitle text
  }
});

events.onSync('chat:actionbar', (ev) => {
  if (ev.source === 'local' && ev.text.plain.includes('cannot drink')) {
    return true;                    // swallow the local hint
  }
  return { text: ev.text.plain.toUpperCase() };
});

// screen:signEdit fires when a sign editor is about to open. Returning
// { lines, closeScreen } replaces the four lines and skips the editor —
// the replaced text is submitted directly (auto-sign).
events.onSync('screen:signEdit', (ev) => {
  if (ev.front) {
    return { lines: [ev.x + ', ' + ev.z, 'shop', '', ''], closeScreen: true };
  }
});
```
