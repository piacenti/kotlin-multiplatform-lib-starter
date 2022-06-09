
val kotest_version: String by project

plugins {
    kotlin("multiplatform") version "1.6.21"
    kotlin("plugin.serialization") version "1.6.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}
kotlin {
    jvm()
    js() {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                }
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib"))
                implementation(kotlin("reflect"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
            }
        }
        val commonTest by getting {
            dependencies {
//              implementation("io.kotest:kotest-famework:$kotest_version")
                implementation("io.kotest:kotest-assertions-core:$kotest_version")
                implementation("io.kotest:kotest-property:$kotest_version")
                implementation("io.kotest:kotest-framework-engine:$kotest_version")
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation("io.kotest:kotest-runner-junit5:$kotest_version")
            }
        }
    }
}
tasks.withType<Test> {
    useJUnitPlatform()
}