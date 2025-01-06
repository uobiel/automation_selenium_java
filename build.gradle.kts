plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.7.1")
    implementation("org.seleniumhq.selenium:selenium-java:4.10.0")
    implementation("io.cucumber:cucumber-java:7.13.0")
    implementation("io.cucumber:cucumber-testng:7.13.0")
    implementation("io.github.bonigarcia:webdrivermanager:5.4.0")
}

tasks.test {
    useTestNG()
}

tasks.register<Test>("run") {
    dependsOn("assemble", "testClasses")
    doLast {
        javaexec {
            mainClass.set("io.cucumber.core.cli.Main")
            classpath = sourceSets["test"].runtimeClasspath
            args = listOf(
                "--plugin", "pretty",
                "--plugin", "html:target/cucumber-report.html",
                "--glue", "steps",
                "--glue", "steps/BaseTest",
                "src/test/resources/features"
            )
            systemProperties = mapOf("headless" to "true")
        }
    }
}

tasks.register<Test>("open") {
    dependsOn("assemble", "testClasses")
    doLast {
        javaexec {
            mainClass.set("io.cucumber.core.cli.Main")
            classpath = sourceSets["test"].runtimeClasspath
            args = listOf(
                "--plugin", "pretty",
                "--plugin", "html:target/cucumber-report.html",
                "--glue", "steps",
                "--glue", "steps/BaseTest",
                "src/test/resources/features"
            )
            systemProperties = mapOf("headless" to "false")
        }
    }
}