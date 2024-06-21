plugins {
    id("java")
}

group = "edu.ukma"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("com.squareup:javapoet:1.13.0")
    annotationProcessor("com.google.auto.service:auto-service:1.0.1")
    compileOnly("com.google.auto.service:auto-service:1.0.1")
}

tasks.withType<JavaCompile> {
    options.annotationProcessorPath = configurations.annotationProcessor.get().asFileTree
}

tasks.test {
    useJUnitPlatform()
}