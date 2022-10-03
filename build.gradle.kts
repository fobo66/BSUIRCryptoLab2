plugins {
    kotlin("jvm") version "1.7.20"
    application
}

application {
    mainClass.set("io.fobo66.crypto.Lab2")
}

allprojects{
    repositories {
        mavenCentral()
    }
}

dependencies {
    implementation("commons-cli:commons-cli:1.5.0")
}
