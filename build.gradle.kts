plugins {
	java
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
	id("org.graalvm.buildtools.native") version "0.9.28"
}

group = "com.kakao.tech"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
