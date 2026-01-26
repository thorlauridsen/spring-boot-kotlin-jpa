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

    // Kotlin Reflection required by Spring Data JPA
    implementation(local.kotlin.reflect)
}

// Disabling bootJar and bootRun is necessary for a subproject/module
// that uses the Spring Boot plugin but is not supposed to be executable.
tasks.bootJar {
    enabled = false
}
tasks.bootRun {
    enabled = false
}
