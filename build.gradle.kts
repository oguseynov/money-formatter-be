plugins {
    kotlin("jvm") version "1.4.10"
}

group = "com.github.oguseynov"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.http4k:http4k-core:3.268.0")
    implementation("org.http4k:http4k-client-okhttp:3.268.0")
    implementation("org.http4k:http4k-server-netty:3.268.0")
    testImplementation("org.http4k:http4k-testing-hamkrest:3.268.0")
    testImplementation("org.http4k:http4k-testing-kotest:3.268.0")

    testImplementation("io.kotest:kotest-runner-junit5:4.3.0")
    testImplementation("io.kotest:kotest-assertions-core:4.3.0")
    testImplementation("io.kotest:kotest-property:4.3.0")

    implementation("com.michael-bull.kotlin-result:kotlin-result:1.1.6")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    withType<Test> {
        useJUnitPlatform()
    }
}