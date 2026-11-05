package ink.tuanzi.neomacros.docs.fixture;

/**
 * Fixture record referenced only from an event field, exercising the
 * event-referenced record collection path.
 */
public record FixtureStamp(long tick, String source) {
}
