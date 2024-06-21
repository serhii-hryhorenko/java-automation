plugins {
    id("java")
}

group = "edu.ukma"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

sourceSets {
    main {
        java.srcDirs("src/main/kotlin", "src/generated/kotlin")
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation(project(":annotation-processor"))
    annotationProcessor(project(":annotation-processor"))
}

tasks.test {
    useJUnitPlatform()
}
