import org.springframework.boot.gradle.tasks.bundling.BootJar
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    kotlin("plugin.spring") version local.versions.kotlin
    alias(local.plugins.springboot)
    alias(local.plugins.spring.dependencies)
}

dependencies {
    // Persistence subproject needs to know about the model subproject
    implementation(projects.model)

    // Spring Boot Data JPA dependency for interacting with the database
    implementation(local.springboot.starter.jpa)
}

// Disabling bootJar and bootRun is necessary for a subproject/module
// that uses the Spring Boot plugin but is not supposed to be executable.
tasks.named<BootJar>("bootJar") {
    enabled = false
}
tasks.named<BootRun>("bootRun") {
    enabled = false
}
