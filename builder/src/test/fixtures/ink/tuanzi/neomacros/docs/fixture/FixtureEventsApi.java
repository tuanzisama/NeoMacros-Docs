package ink.tuanzi.neomacros.docs.fixture;

import ink.tuanzi.neomacros.doc.api.ApiModule;
import ink.tuanzi.neomacros.doc.api.ApiSince;
import ink.tuanzi.neomacros.doc.api.ApiType;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Fixture events facade mirroring the real events module shape: the
 * subscription methods are rendered as event-map-typed overloads in the
 * TypeScript definitions.
 *
 * @zh fixture 事件门面，镜像真实 events 模块形态：订阅方法在 TypeScript 定义中渲染为事件表泛型重载。
 */
@ApiModule(name = "events", category = "test")
@ApiSince("0.1.0")
public final class FixtureEventsApi {

    /**
     * Subscribes asynchronously to the named event.
     *
     * @param name the event name; wildcards are allowed
     * @param handler the payload handler
     * @return an opaque subscription handle
     * @zh 异步订阅指定事件。
     * @zh-param name 事件名，支持通配
     * @zh-param handler 载荷处理器
     * @zh-return 不透明订阅句柄
     */
    @ApiSince("0.1.0")
    public Object on(String name, Consumer<Object> handler) {
        return handler;
    }

    /**
     * Subscribes for exactly one firing of the named event.
     *
     * @param name the event name
     * @param handler the payload handler
     * @return an opaque subscription handle
     * @zh 订阅指定事件的一次触发。
     * @zh-param name 事件名
     * @zh-param handler 载荷处理器
     * @zh-return 不透明订阅句柄
     */
    @ApiSince("0.1.0")
    public Object once(String name, Consumer<Object> handler) {
        return handler;
    }

    /**
     * Registers one custom event name owned by scripts.
     *
     * @param name the custom event name to register
     * @zh 注册脚本自定义事件。
     * @zh-param name 要注册的自定义事件名
     */
    @ApiSince("0.1.0")
    public void register(String name) {
    }

    /**
     * Emits one custom event with a plain-object payload.
     *
     * @param name the registered custom event name
     * @param payload the plain-object payload (or undefined)
     * @zh 触发一个自定义事件，载荷为普通对象。
     * @zh-param name 已注册的自定义事件名
     * @zh-param payload 普通对象载荷（或 undefined）
     */
    @ApiSince("0.1.0")
    public void emit(String name, Object payload) {
    }

    /**
     * Unsubscribes by the handle returned from on / once, or by event name.
     *
     * @param handleOrName the subscription handle or an event name
     * @zh 按句柄或事件名注销订阅。
     * @zh-param handleOrName 订阅句柄或事件名
     */
    @ApiSince("0.1.0")
    public void off(Object handleOrName) {
    }

    /**
     * Subscribes synchronously; only cancellable events accept sync
     * subscriptions and the callback returns a truthy value to cancel.
     *
     * @param name the cancellable event name
     * @param handler the verdict callback returning truthy to cancel
     * @zh 同步订阅；仅可取消事件可用，回调返回 truthy 即取消。
     * @zh-param name 可取消事件名
     * @zh-param handler 判定回调，返回 truthy 取消
     */
    @ApiSince("0.1.0")
    public void onSync(String name, Predicate<Object> handler) {
    }

    /**
     * Waits for one occurrence of the event; the promise settles with the
     * event payload.
     *
     * @param name the event name
     * @return a promise settling with the event payload
     * @zh 等待事件的下一次触发，Promise 以载荷落定。
     * @zh-param name 事件名
     * @zh-return 以事件载荷落定的 Promise
     */
    @ApiSince("0.1.0")
    @ApiType("Promise<object>")
    public CompletableFuture<Object> waitFor(String name) {
        return CompletableFuture.completedFuture(null);
    }

    /**
     * Waits for an occurrence matching the filter; rejects after the timeout.
     *
     * @param name the event name
     * @param filter the predicate applied to each payload
     * @param timeoutMillis the rejection timeout in milliseconds
     * @return a promise settling with the first matching payload
     * @zh 按过滤谓词等待事件；超时后 Promise 以异常落定。
     * @zh-param name 事件名
     * @zh-param filter 应用于每个载荷的判定谓词
     * @zh-param timeoutMillis 超时毫秒数
     * @zh-return 以首个匹配载荷落定的 Promise
     */
    @ApiSince("0.1.0")
    @ApiType("Promise<object>")
    public CompletableFuture<Object> waitForUntil(String name, Predicate<Object> filter,
            long timeoutMillis) {
        return CompletableFuture.completedFuture(null);
    }
}
