plugins {
    id("org.springframework.boot") version "2.2.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("java")
    `maven-publish`
    `project-report`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}


dependencies {
    implementation("org.apache.commons:commons-math3:3.6.1")
    implementation("com.google.guava:guava:28.0-jre")
    implementation("org.springframework.boot:spring-boot-starter-web:2.2.6.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:2.2.6.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.2.6.RELEASE")
    implementation("org.codehaus.jackson:jackson-core-asl:1.9.13")
    implementation("org.modelmapper.extensions:modelmapper-spring:2.3.7")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.1")
    implementation("com.baomidou:mybatis-plus-boot-starter:3.3.1")
    implementation("com.aliyun.hbase:alihbase-client:2.0.5") {
        exclude(group = "org.slf4j", module = "slf4j-log4j12")  // Remove to avoid conflicts with logback
    }
    runtimeOnly("com.h2database:h2")
    implementation(project(":core"))
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks {
    jar {
        manifest {
            attributes(
                    mapOf("Implementation-Title" to project.name,
                          "Implementation-Version" to project.version)
            )
        }
    }
}
tasks.register("bootRunDev") {
    description = "Runs the Spring Boot application with the dev profile"
    doFirst {
        tasks.bootRun.configure {
            systemProperty("spring.profiles.active", "dev")
        }
    }
    finalizedBy("bootRun")
}

version = "1.0.0"

configure<PublishingExtension> {
    publications {
        create<MavenPublication>("myLibrary") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "myRepo"
            url = uri("file://${buildDir}/repo")
        }
    }
 }
