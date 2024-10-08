import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version libs.versions.kotlin
    application
    `jvm-test-suite`
    id("io.gitlab.arturbosch.detekt").version("1.23.7")
}

application {
    mainClass = "dev.fobo66.crypto.Lab2Kt"
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
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
