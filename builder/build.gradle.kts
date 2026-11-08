plugins {
    `java-library`
}

repositories {
    // Resolves the doc-api annotation jar by coordinates (published via
    // ./gradlew :doc-api:publishToMavenLocal in the parent build): the
    // documentation generator consumes the same annotations the runtime
    // binding builder consumes, from a single source of truth.
    mavenLocal()
    mavenCentral()
}

java {
    // Runs on the same JDK the mod build's Gradle daemon uses (fabric-loom
    // needs JVM 25); the doclet sources stay compatible with both 17 and 25.
    toolchain.languageVersion = JavaLanguageVersion.of(25)
}

dependencies {
    implementation("ink.tuanzi.neomacros:doc-api:0.1.0")
    // Same version as the main build's catalog; used by NpmTypesPackager.
    implementation("com.google.code.gson:gson:2.11.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.10.2")
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    // Path to a TypeScript compiler entry (the bin/tsc JS file); the TS
    // compile test runs it through node, e.g.
    // ./gradlew -p docs-builder check -PtscPath=C:/path/to/typescript/bin/tsc
    systemProperty("tscPath", providers.gradleProperty("tscPath").orElse("").get())
    // Fixture sources and snapshot baselines are read at test runtime, outside
    // any source set; declare them as inputs or edits skip the test task.
    inputs.dir(layout.projectDirectory.dir("src/test/fixtures"))
    inputs.dir(layout.projectDirectory.dir("src/test/snapshots"))
}

// Generates the bilingual API pages and TypeScript definitions from the
// NeoMacros mod repository's core and ports facade sources. Requires the
// doc-api annotation jar in the local repository (./gradlew
// :doc-api:publishToMavenLocal from the mod repository's build). Outputs
// build/gen/md/api/*.md (+ warnings.txt) and
// build/gen/ts/types/neomacros.d.ts.
tasks.register<JavaExec>("generateApiDocs") {
    group = "documentation"
    description = "Generates API documentation from the real facade sources (core + ports)"

    classpath = sourceSets.main.get().runtimeClasspath
    mainClass = "ink.tuanzi.neomacros.docs.ApiDocsGenerate"

    // The mod repository holding the scanned facade sources: a sibling
    // checkout (../neomacros) by default, overridable for other layouts
    // (-PneomacrosRoot=<path> or the NEOMACROS_ROOT environment variable,
    // e.g. the CI workspace).
    val modRoot = File(
        providers.gradleProperty("neomacrosRoot")
            .orElse(providers.environmentVariable("NEOMACROS_ROOT"))
            .orElse(layout.projectDirectory.dir("../../neomacros").asFile.absolutePath)
            .get()
    ).toPath()
    val mdOut = layout.buildDirectory.dir("gen/md")
    val tsOut = layout.buildDirectory.dir("gen/ts")
    val genArgs = mutableListOf(
        mdOut.get().asFile.absolutePath,
        tsOut.get().asFile.absolutePath,
        modRoot.resolve("core/src/main/java").toString(),
        modRoot.resolve("ports/src/main/java").toString(),
    )
    // The version-compatibility matrix covers exactly the Stonecutter nodes
    // the mod build declares under versions/*, ascending by version number.
    val versionNodes = modRoot.resolve("versions").toFile()
        .listFiles { it.isDirectory }
        ?.map { it.name }
        ?.sortedWith { a, b ->
            val pa = a.split(".").map { it.toIntOrNull() ?: 0 }
            val pb = b.split(".").map { it.toIntOrNull() ?: 0 }
            var cmp = 0
            for (i in 0 until maxOf(pa.size, pb.size)) {
                cmp = pa.getOrElse(i) { 0 } - pb.getOrElse(i) { 0 }
                if (cmp != 0) break
            }
            cmp
        }
        ?: emptyList()
    if (versionNodes.isNotEmpty()) {
        genArgs.add(versionNodes.joinToString(","))
    }
    args(genArgs)

    inputs.dir(modRoot.resolve("core/src/main/java/ink/tuanzi/neomacros/core/api"))
    inputs.dir(modRoot.resolve("ports/src/main/java/ink/tuanzi/neomacros/port"))
    inputs.files(modRoot.resolve("core/src/main/java/ink/tuanzi/neomacros/core/event/Subscription.java"))
    inputs.files(modRoot.resolve("core/src/main/java/ink/tuanzi/neomacros/core/runtime/TimerHandle.java"))
    outputs.dir(mdOut)
    outputs.dir(tsOut)
}
