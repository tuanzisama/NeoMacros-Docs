以 fetch 语义发起 HTTP 请求，需要 net 能力；响应体的读取器（text()/json()/bytes()）均为异步。

```js
const { net } = neo;

// Requires the net capability; body readers are async
const res = await net.get('https://api.example.com/status');
if (res.ok) {
  const data = await res.json(); // parsed body
}

// POST with full fetch semantics: method, headers, string body
await net.fetch('https://api.example.com/hook', {
  method: 'POST',
  headers: { 'content-type': 'application/json' },
  body: JSON.stringify({ event: 'joined' }),
});
```
