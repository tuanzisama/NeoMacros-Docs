package ink.tuanzi.neomacros.docs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Snapshot regression over the fixture API, in the spirit of the JsMacros
 * testTsRenderer setup: generated artifacts are compared byte-for-byte
 * against committed baselines, and warning/fallback behavior is asserted
 * explicitly. Update the baselines deliberately (inspect the diff first!)
 * when the renderers change.
 */
class DocsGenerationTest {

    // Fixed directory (not @TempDir) so generated artifacts stay inspectable
    // and can be promoted to snapshots after review; cleaned by `clean`.
    static Path outDir = Path.of("build", "manual-gen");

    @BeforeAll
    static void generateAll() throws IOException {
        DocsGenerationTest.outMd = GenerationHarness.generate(MDDoclet.class, outDir.resolve("md"));
        DocsGenerationTest.outTs = GenerationHarness.generate(TSDoclet.class, outDir.resolve("ts"));
    }

    static GenerationHarness.Run outMd;
    static GenerationHarness.Run outTs;

    @Test
    void generationSucceedsWithoutErrors() {
        assertTrue(outMd.ok(), () -> "MD generation failed: " + outMd.errors());
        assertTrue(outTs.ok(), () -> "TS generation failed: " + outTs.errors());
    }

    @Test
    void englishPagesMatchSnapshots() throws IOException {
        for (String module : new String[]{"world", "partial"}) {
            assertEquals(readSnapshot("api/" + module + ".md"),
                    read(outMd.outDir().resolve("api/" + module + ".md")),
                    "English page for " + module + " drifted from the committed snapshot");
        }
    }

    @Test
    void chinesePagesMatchSnapshots() throws IOException {
        for (String module : new String[]{"world", "partial"}) {
            assertEquals(readSnapshot("api/" + module + ".zh.md"),
                    read(outMd.outDir().resolve("api/" + module + ".zh.md")),
                    "Chinese page for " + module + " drifted from the committed snapshot");
        }
    }

    @Test
    void warningsListMatchesSnapshot() throws IOException {
        String warnings = read(outMd.outDir().resolve("api/" + DocletSupport.WARNINGS_FILE));
        assertEquals(readSnapshot("api/" + DocletSupport.WARNINGS_FILE), warnings);
        assertTrue(warnings.contains("partial: module doc has no @zh body"));
        assertTrue(warnings.contains("partial.untagged: method has no @zh docs"));
        assertTrue(warnings.contains("partial.untagged: missing @ApiSince"));
        assertTrue(warnings.contains("partial: module is missing @ApiSince"));
    }

    @Test
    void chinesePageFallsBackToEnglishPerMember() throws IOException {
        String page = read(outMd.outDir().resolve("api/partial.zh.md"));
        assertTrue(page.contains("Returns a value whose member lacks translation and version annotation"),
                "untagged member falls back to the English text");
        assertTrue(page.contains("返回完整文档化的值。"),
                "translated member keeps its Chinese text");
    }

    @Test
    void badgesAndBadgesOnlyRenderedWhereAnnotated() throws IOException {
        String world = read(outMd.outDir().resolve("api/world.md"));
        assertTrue(world.contains(":api-badges{ since=\"0.1.0\" permission=\"command\" experimental=\"true\"}"),
                "experimental badge rendered");
        assertTrue(world.contains(":api-badges{ since=\"0.1.0\" mc=\">=1.20.6\"}"),
                "MC range badge rendered");
        assertFalse(world.contains("hiddenInternal"), "internal members stay hidden");
        assertTrue(world.contains(":api-badge{kind=\"readonly\"}"), "read-only badge rendered");
    }

    @Test
    void zhExampleRenderedOnlyInChinesePage() throws IOException {
        String zh = read(outMd.outDir().resolve("api/world.zh.md"));
        String en = read(outMd.outDir().resolve("api/world.md"));
        assertTrue(zh.contains("world.mark(new Pos3d(1, 64, 1));"), "example in the Chinese page");
        assertFalse(en.contains("**Example**"), "example stays out of the English page");
    }

    @Test
    void methodParamDescriptionsFollowLocaleConvention() throws IOException {
        String zh = read(outMd.outDir().resolve("api/world.zh.md"));
        assertTrue(zh.contains("要标记的方块位置"), "@zh-param wins on the Chinese page");
        String en = read(outMd.outDir().resolve("api/world.md"));
        assertTrue(en.contains("the block position to mark"), "@param wins on the English page");
        assertFalse(en.contains("方块位置"), "English page never leaks Chinese param text");
    }

    @Test
    void modulePagesLinkToClassPages() throws IOException {
        String world = read(outMd.outDir().resolve("api/world.md"));
        assertTrue(world.contains("**Classes**"), "classes link section rendered");
        assertTrue(world.contains("[`WorldHandle`](classes/WorldHandle.html)"),
                "class link rendered");
        assertFalse(world.contains("## Class WorldHandle"), "class sections moved to their own pages");
    }

    @Test
    void classPagesRenderKindWrapsAndInheritance() throws IOException {
        String handle = read(outMd.outDir().resolve("api/classes/WorldHandle.md"));
        assertTrue(handle.contains("title: \"WorldHandle\""), "class page frontmatter rendered");
        assertTrue(handle.contains("description: \""), "class page description frontmatter rendered");
        assertTrue(handle.contains("::api-declaration{ kind=\"handle\" name=\"WorldHandle\" wraps=\"net.minecraft.world.fixture.World\"}"),
                "kind and wraps meta rendered");
        assertTrue(handle.contains("#extended-by\n[`RegionHandle`](RegionHandle.html)"),
                "parent lists its subclasses");
        String region = read(outMd.outDir().resolve("api/classes/RegionHandle.md"));
        assertTrue(region.contains("#extends\n[`WorldHandle`](WorldHandle.html)"),
                "subclass lists its parent");
        String info = read(outMd.outDir().resolve("api/classes/WorldInfo.md"));
        assertTrue(info.contains("kind=\"data\""), "data kind badge rendered");
        String pos = read(outMd.outDir().resolve("api/classes/FixturePos.md"));
        assertTrue(pos.contains("Record type referenced in API signatures."),
                "referenced record type page rendered");
    }

    @Test
    void classPagesKeepEnglishTermsOnChinesePages() throws IOException {
        String zh = read(outMd.outDir().resolve("api/classes/WorldHandle.zh.md"));
        assertTrue(zh.contains("::api-declaration{ kind=\"handle\" name=\"WorldHandle\" wraps=\"net.minecraft.world.fixture.World\"}"),
                "kind and wraps terms stay English on the Chinese page");
        assertTrue(zh.contains("#extended-by\n[`RegionHandle`](RegionHandle.html)"),
                "inheritance terms stay English on the Chinese page");
        assertTrue(zh.contains("fixture 世界的活引用句柄"), "translated body kept");
    }

    @Test
    void standaloneClassPageRendered() throws IOException {
        String vec = read(outMd.outDir().resolve("api/classes/StandaloneVec.md"));
        assertTrue(vec.contains("title: \"StandaloneVec\""), "standalone class page rendered");
        assertTrue(vec.contains("kind=\"data\""), "data kind badge rendered");
    }

    @Test
    void constructibleClassPageCarriesCtorAndExample() throws IOException {
        String en = read(outMd.outDir().resolve("api/classes/StandaloneVec.md"));
        assertTrue(en.contains("ctor=\"new StandaloneVec(x: number, y: number, z: number)\""),
                "constructible class declares its constructor signature");
        assertFalse(en.contains("**Example**"), "class example stays out of the English page");
        String zh = read(outMd.outDir().resolve("api/classes/StandaloneVec.zh.md"));
        assertTrue(zh.contains("ctor=\"new StandaloneVec(x: number, y: number, z: number)\""),
                "constructor signature stays on the Chinese page");
        assertTrue(zh.contains("const v = new StandaloneVec(1, 2, 3);"),
                "class-level example rendered at the bottom of the Chinese page");
        String handle = read(outMd.outDir().resolve("api/classes/WorldHandle.md"));
        assertFalse(handle.contains("ctor="), "engine-handed class is not marked constructible");
    }

    @Test
    void eventPagesRendered() throws IOException {
        String marked = read(outMd.outDir().resolve("api/events/fixture-marked.md"));
        assertTrue(marked.contains("title: \"fixture:marked\""), "event page rendered");
        assertTrue(marked.contains("::api-event-header{ event=\"fixture:marked\" direction=\"c2s\" cancellable=\"true\" since=\"0.1.0\"}"),
                "direction attribute and cancellable badge rendered");
        assertTrue(marked.contains("[`FixtureMarkedEvent`](../types/FixtureMarkedEvent.html)"),
                "payload class link rendered");
        assertTrue(marked.contains("the message carried by the event"),
                "field description rendered from @param");
        assertTrue(marked.contains("| `message` | `string` | the message carried by the event :api-badge{kind=\"writable\"} |"),
                "writable fields carry the writable badge");
        assertTrue(marked.contains("| `cancelled` | `boolean` |"),
                "cancelled state documented on cancellable event pages");
        assertTrue(marked.contains(":api-type{text='FixturePos' refs='FixturePos=classes/fixturepos'}"),
                "record-typed field links to its class page");
        String stamp = read(outMd.outDir().resolve("api/classes/FixtureStamp.md"));
        assertTrue(stamp.contains("Record type referenced in API signatures."),
                "record referenced only from an event gets its own page");
        assertTrue(marked.contains(":api-type{text='FixtureStamp' refs='FixtureStamp=classes/fixturestamp'}"),
                "event-only record field links to its new page");
        String zh = read(outMd.outDir().resolve("api/events/fixture-marked.zh.md"));
        assertTrue(zh.contains("cancellable=\"true\""), "cancellable badge stays English on the Chinese page");
        assertTrue(zh.contains("练习用的可取消事件描述符"), "translated body kept");
        assertTrue(zh.contains("事件携带的消息"),
                "field description rendered from @zh-param");
    }

    @Test
    void eventTypePagesRendered() throws IOException {
        String cls = read(outMd.outDir().resolve("api/types/FixtureMarkedEvent.md"));
        assertTrue(cls.contains("title: \"FixtureMarkedEvent\""), "payload class page rendered");
        assertTrue(cls.contains("::api-type-header{ since=\"0.1.0\"}\n#extends\n[`InputEvent`](InputEvent.html)\n#raised-by\n[`fixture:marked`](../events/fixture/fixture-marked.html)"),
                "direction class extends and raised-by links rendered in the type header");
        assertTrue(cls.contains("| `severity` | `number` | the severity level of the event |"),
                "field table rendered on the payload class page");
        assertTrue(cls.contains("| `cancelled` | `boolean` |")
                        && cls.contains("::api-method")
                        && cls.contains("### `cancel()`"),
                "cancellable payload pages document the cancelled state"
                        + " and the cancel() method");
        String base = read(outMd.outDir().resolve("api/types/BaseEvent.md"));
        assertTrue(base.contains("title: \"BaseEvent\""), "base event page rendered");
        assertTrue(base.contains("| `cancellable` | `boolean` |"), "base fields rendered");
    }

    @Test
    void tsDefinitionsEmitClassDeclarations() throws IOException {
        String ts = read(outTs.outDir().resolve("types/neomacros.d.ts"));
        assertTrue(ts.contains("interface WorldHandle"), "classes emitted as instance interfaces");
        assertFalse(ts.contains("class WorldHandle"), "no global class values (entry is neo.<Name>)");
        assertTrue(ts.contains("interface RegionHandle extends WorldHandle"),
                "extends chain rendered");
        assertTrue(ts.contains("interface WorldInfo"), "data kind renders the same way");
        assertTrue(ts.contains("interface FixtureStamp"),
                "records referenced only from events are defined in the global scope");
    }

    @Test
    void tsDefinitionsMatchSnapshot() throws IOException {
        assertEquals(readSnapshot("types/neomacros.d.ts"),
                read(outTs.outDir().resolve("types/neomacros.d.ts")),
                "TypeScript definitions drifted from the committed snapshot");
    }

    @Test
    void tsDefinitionsDeclareGlobalRoot() throws IOException {
        String ts = read(outTs.outDir().resolve("types/neomacros.d.ts"));
        assertTrue(ts.contains("interface NeoRoot"), "named root interface present");
        assertTrue(ts.contains("declare const neo: NeoRoot;"), "global aggregate present");
        assertTrue(ts.contains("    world: WorldApi;"), "module facade reachable on the root");
        assertTrue(ts.contains("    partial: PartialApi;"), "every module hangs on the root");
        assertTrue(ts.contains("    StandaloneVec: { new(x: number, y: number, z: number): StandaloneVec; };"),
                "self-constructing cell carries a typed constructor face");
        assertTrue(ts.contains("    WorldHandle: Function & { readonly prototype: WorldHandle; };"),
                "engine-handed class carries only an instanceof face");
        assertFalse(ts.contains("new(...args: unknown[])"),
                "no blanket constructor face leaks onto non-constructible classes");
        assertFalse(ts.contains("declare module '@neomacros/"),
                "no importable module blocks are declared");
        assertFalse(ts.contains("import("), "single scope needs no import-type qualification");
    }

    @Test
    void tsEventsFacadeDeclaresTypedEventMap() throws IOException {
        String ts = read(outTs.outDir().resolve("types/neomacros.d.ts"));
        assertTrue(ts.contains("interface EventPayloadMap"), "event name map emitted");
        assertTrue(ts.contains("'fixture:marked': FixtureMarkedEvent;"),
                "every event name declared with its payload class");
        assertTrue(ts.contains("interface CancellableEventMap"), "cancellable name map emitted");
        assertTrue(ts.contains("'fixture:marked': MutableFixtureMarkedEvent;"),
                "cancellable names resolve to the writable mutable face");
        assertTrue(ts.contains("on<E extends keyof EventPayloadMap>(name: E, "
                        + "handler: (event: EventPayloadMap[E]) => void): unknown;"),
                "on resolves payload types per known event name");
        assertTrue(ts.contains("onSync<E extends keyof CancellableEventMap>(name: E, "
                        + "handler: (event: CancellableEventMap[E]) => void, options?: SyncOptions): void;"),
                "onSync delivers the mutable face with dispatch options");
        assertTrue(ts.contains("waitFor<E extends keyof EventPayloadMap>(name: E): Promise<EventPayloadMap[E]>;"),
                "waitFor resolves payload types per known event name");
        assertTrue(ts.contains("on(name: string, handler: (event: BaseEvent) "
                        + "=> void): unknown;"),
                "string overload kept for wildcards and custom events");
        assertTrue(ts.contains("    BaseEvent: Function & { readonly prototype: BaseEvent; };")
                && ts.contains("    FixtureMarkedEvent: Function & { readonly prototype: FixtureMarkedEvent; };"),
                "event payloads hang on the neo root with an instanceof-only face");
    }

    private static String read(Path file) throws IOException {
        return Files.readString(file, StandardCharsets.UTF_8);
    }

    private static String readSnapshot(String relative) throws IOException {
        return read(Paths.get("src", "test", "snapshots").resolve(relative));
    }
}
