import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm") version "1.9.25"
}

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.jetbrains.exposed:exposed-core:0.55.0")
    implementation("org.jetbrains.exposed:exposed-crypt:0.55.0")
    implementation("org.jetbrains.exposed:exposed-dao:0.55.0")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.55.0")

    implementation("org.jetbrains.exposed:exposed-kotlin-datetime:0.55.0")

    implementation("org.jetbrains.exposed:exposed-json:0.55.0")
    implementation("org.jetbrains.exposed:exposed-spring-boot-starter:0.55.0")
}