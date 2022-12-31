import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
    application
    `jvm-test-suite`
}

application {
    mainClass.set("dev.fobo66.crypto.Lab2Kt")
}

allprojects {
    repositories {
        mavenCentral()
    }
}

kotlin {
    jvmToolchain(17)
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useKotlinTest("1.8.0")
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.5")
}
