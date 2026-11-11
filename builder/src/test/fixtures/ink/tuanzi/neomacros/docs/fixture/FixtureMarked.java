package ink.tuanzi.neomacros.docs.fixture;

import ink.tuanzi.neomacros.doc.api.ApiEvent;
import ink.tuanzi.neomacros.doc.api.ApiSince;

/**
 * Fixture event descriptor with complete bilingual documentation: a
 * cancellable event carrying a message and the position it was raised at.
 *
 * @param message the message carried by the event
 * @param severity the severity level of the event
 * @param pos the position the event was raised at
 * @param stamp the timing stamp of the event
 * @zh 练习用的可取消事件描述符，载荷为一条消息。
 * @zh-param message 事件携带的消息
 * @zh-param severity 事件的严重级别
 * @zh-param pos 事件触发的位置
 * @zh-param stamp 事件的时间戳信息
 */
@ApiSince("0.1.0")
@ApiEvent(name = "fixture:marked", direction = ApiEvent.Direction.C2S, cancellable = true, mutable = { "message" })
public record FixtureMarked(String message, int severity, FixturePos pos, FixtureStamp stamp) {
}
