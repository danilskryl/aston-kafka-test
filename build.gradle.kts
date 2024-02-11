plugins {
    java
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
}

allprojects {
    repositories {
        mavenCentral()
    }
}


tasks {
    bootJar {
        enabled = false
    }

    jar {
        enabled = true
    }
}

subprojects {
    group = "org.danilskryl.aston"
    version = "0.0.1-SNAPSHOT"
    extra["springCloudVersion"] = "2023.0.0"

    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    java {
        sourceCompatibility = JavaVersion.VERSION_17
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-web")
//        implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
//        implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server")
        implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
        implementation("org.springframework.kafka:spring-kafka")
        compileOnly("org.projectlombok:lombok")
        runtimeOnly("org.postgresql:postgresql")
        annotationProcessor("org.projectlombok:lombok")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.springframework.kafka:spring-kafka-test")
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    configurations {
        compileOnly {
            extendsFrom(annotationProcessor.get())
        }
    }
}
