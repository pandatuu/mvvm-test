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

    // AndroidX
    implementation(thirdPartyLibraries["androidxCore"] ?: error(""))
    implementation(thirdPartyLibraries["androidxLifecycle"] ?: error(""))
    implementation(thirdPartyLibraries["androidxLifecycleLiveData"] ?: error(""))
    implementation(thirdPartyLibraries["androidxLifecycleViewModel"] ?: error(""))
    kapt(thirdPartyLibraries["androidxLifecycleCompiler"] ?: error(""))
    implementation(thirdPartyLibraries["androidxRoom"] ?: error(""))
    implementation(thirdPartyLibraries["androidxRoomRxJava"] ?: error(""))
    kapt(thirdPartyLibraries["androidxRoomCompiler"] ?: error(""))
    implementation(thirdPartyLibraries["androidxAppCompat"] ?: error(""))
    implementation(thirdPartyLibraries["androidxRecyclerView"] ?: error(""))
    implementation(thirdPartyLibraries["androidxCardView"] ?: error(""))
    implementation(thirdPartyLibraries["androidxConstraintLayout"] ?: error(""))
    implementation(thirdPartyLibraries["androidxCoreKtx"] ?: error(""))
    implementation(thirdPartyLibraries["androidxFragmentKtx"] ?: error(""))
    implementation(thirdPartyLibraries["androidxLifecycleViewModelKtx"] ?: error(""))

    // MvRx
    implementation(thirdPartyLibraries["mvrx"] ?: error(""))
    // Epoxy
    implementation(thirdPartyLibraries["epoxy"] ?: error(""))
    implementation(thirdPartyLibraries["epoxyDatabinding"] ?: error(""))
    kapt(thirdPartyLibraries["epoxyProcessor"] ?: error(""))
    // Paris
    implementation(thirdPartyLibraries["paris"] ?: error(""))
    kapt(thirdPartyLibraries["parisProcessor"] ?: error(""))

    // Fragmentation
    implementation(thirdPartyLibraries["fragmentationx"] ?: error(""))

    // Test
    testImplementation(thirdPartyLibraries["junit"] ?: error(""))
    androidTestImplementation(thirdPartyLibraries["androidxTestRunner"] ?: error(""))
    androidTestImplementation(thirdPartyLibraries["androidxTestEspresso"] ?: error(""))
}
