plugins {
    java
    `maven-publish`
}

group = "io.github.orioncraftmc"
version = "1.0.1"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.jetbrains:annotations:20.1.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

java {
    withSourcesJar()
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

publishing {
    repositories {
        val lightCraftRepoDir = project.findProperty("lightcraft.repo.location")
        if (lightCraftRepoDir != null) {
            maven {
                name = "LightCraftRepo"
                url = File(lightCraftRepoDir.toString()).toURI()
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}