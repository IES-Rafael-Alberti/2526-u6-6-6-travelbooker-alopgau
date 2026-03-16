plugins {
    kotlin("jvm") version "2.0.20"
}

group = "es.prog2425.u4u5u6libre"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // Source: https://mvnrepository.com/artifact/com.github.ajalt.mordant/mordant
    implementation("com.github.ajalt.mordant:mordant:3.0.2")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
