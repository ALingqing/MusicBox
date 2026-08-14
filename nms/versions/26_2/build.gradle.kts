plugins {
    id("io.papermc.paperweight.userdev")
}
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
}
dependencies {
    // Paper 26.2 (new versioning scheme, dev bundle data version 8 requires paperweight 2.x)
    paperweight.paperDevBundle("26.2.build.112-stable")
}
