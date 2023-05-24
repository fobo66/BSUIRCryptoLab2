plugins {
    kotlin("jvm") version libs.versions.kotlin
    application
    `jvm-test-suite`
    id("io.gitlab.arturbosch.detekt").version("1.23.0")
}

application {
    mainClass.set("dev.fobo66.crypto.Lab2Kt")
}

kotlin {
    jvmToolchain(17)
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useKotlinTest(libs.versions.kotlin)
        }
    }
}

dependencies {
    implementation(libs.cli)
}
