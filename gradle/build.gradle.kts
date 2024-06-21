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
}

//./gradlew checkFile -PfilePath=file.txt
tasks.register("checkFile") {
    doLast {
        val filePath = project.findProperty("filePath")?.toString() ?: throw GradleException("File path not provided.")
        val fileToCheck = file(filePath)
        if (fileToCheck.exists()) {
            println("File exists: ${fileToCheck.absolutePath}")
        } else {
            throw GradleException("File not found: ${fileToCheck.absolutePath}")
        }
    }
}

//Task for project needs
tasks.register<Copy>("copyAssets") {
    val sourceDir = file("${projectDir}/assets")
    val targetDir = file("${buildDir}/resources/main")

    from(sourceDir)
    into(targetDir)

    doFirst {
        println("Copying assets from $sourceDir to $targetDir")
    }
}

tasks.named("processResources") {
    dependsOn("copyAssets")
}

tasks.test {
    useJUnitPlatform()
}