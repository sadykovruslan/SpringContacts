plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-web:3.4.1")
    implementation("org.springframework:spring-jdbc:7.0.0-M3")

    implementation("org.apache.commons:commons-dbcp2:2.13.0")
    implementation("org.postgresql:postgresql:42.7.5")


    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}