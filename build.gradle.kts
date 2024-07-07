plugins {
	kotlin("jvm") version "1.8.20"
	java
	id("org.springframework.boot") version "3.3.1"
	id("io.spring.dependency-management") version "1.1.5"
}

group = "rezeptofant"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

kotlin {
	jvmToolchain(17)
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("mysql:mysql-connector-java:8.0.33")
	implementation("org.hibernate:hibernate-core:6.5.2.Final")
	implementation("jakarta.persistence:jakarta.persistence-api:3.2.0")
	implementation("org.flywaydb:flyway-core:10.14.0")
	implementation("org.flywaydb:flyway-mysql:10.14.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	compileOnly("org.projectlombok:lombok:1.18.34")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
