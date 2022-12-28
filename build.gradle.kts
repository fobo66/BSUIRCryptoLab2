import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
    application
}

application {
    mainClass.set("dev.fobo66.crypto.Lab2Kt")
}

allprojects {
    repositories {
        mavenCentral()
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "11"
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.5")
}
