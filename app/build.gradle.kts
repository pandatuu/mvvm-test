apply("../config.gradle.kts")

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.2")

    defaultConfig {
        applicationId = "nao.toyama.mvrxicecream"
        setMinSdkVersion(21)
        setTargetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    dataBinding {
        isEnabled = true
    }
}

dependencies {
    val thirdPartyLibraries: Map<String, String> by extra

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Kotlin
    implementation(kotlin("stdlib-jdk8"))
    implementation(thirdPartyLibraries["ktxCoroutines"] ?: error(""))
    implementation(thirdPartyLibraries["ktxCoroutinesAndroid"] ?: error(""))

    // AndroidX
    implementation(thirdPartyLibraries["appCompat"] ?: error(""))
    implementation(thirdPartyLibraries["recyclerView"] ?: error(""))
    implementation(thirdPartyLibraries["cardView"] ?: error(""))
    implementation(thirdPartyLibraries["constraintLayout"] ?: error(""))
    implementation(thirdPartyLibraries["coreKtx"] ?: error(""))
    implementation(thirdPartyLibraries["fragmentKtx"] ?: error(""))
    implementation(thirdPartyLibraries["lifecycleViewModelKtx"] ?: error(""))
}
