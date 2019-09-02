apply("../config.gradle.kts")

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

kapt {
    correctErrorTypes = true
}

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.2")

    defaultConfig {
        setMinSdkVersion(21)
        setTargetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    dataBinding {
        isEnabled = true
    }
}

dependencies {
    val thirdPartyLibraries: Map<String, String> by extra

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(":lib"))

    // Kotlin
    implementation(kotlin("stdlib-jdk8"))
    implementation(thirdPartyLibraries["ktxCoroutines"] ?: error(""))
    implementation(thirdPartyLibraries["ktxCoroutinesAndroid"] ?: error(""))

    // Koin
    implementation(thirdPartyLibraries["koinAndroid"] ?: error(""))
    implementation(thirdPartyLibraries["koinAndroidxScope"] ?: error(""))
    implementation(thirdPartyLibraries["koinAndroidxViewModel"] ?: error(""))

    // Test
    testImplementation(thirdPartyLibraries["junit"] ?: error(""))
    androidTestImplementation(thirdPartyLibraries["androidxTestRunner"] ?: error(""))
    androidTestImplementation(thirdPartyLibraries["androidxTestEspresso"] ?: error(""))
}
