plugins {
    java
    id("org.springframework.boot") version "3.1.4"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "br.univille"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencyManagement {
    imports {
        mavenBom("com.azure.spring:spring-cloud-azure-dependencies:5.5.0")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.azure.spring:spring-cloud-azure-starter-data-cosmos:5.5.0")
    implementation("com.azure:azure-spring-data-cosmos:5.5.0")
    implementation("com.azure:azure-identity:1.10.0")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.named<org.springframework.boot.gradle.tasks.run.BootRun>("bootRun") {
    jvmArgs = listOf(
        "-Djavax.net.ssl.trustStore=/workspaces/tapr-2024-turmaa-cursodeextensao-java/native.jks",
        "-Djavax.net.ssl.trustStorePassword=univille"
    )
}

tasks.withType<Test> {
    useJUnitPlatform()
}
