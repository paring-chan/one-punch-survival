plugins {
    kotlin("jvm") version "1.3.71"
}
sourceSets {
    main {
        java.srcDirs("src/main/kotlin")
        resources.srcDirs("src/main/resources")
    }
}
group = "tk.pshub.parangee"
version = "3.0"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://jitpack.io")
}
dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.destroystokyo.paper:paper-api:1.15.2-R0.1-SNAPSHOT")
    implementation("com.github.noonmaru:tap:2.3.3")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}