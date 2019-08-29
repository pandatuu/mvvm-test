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

    // RxJava
    implementation(thirdPartyLibraries["rxJava"] ?: error(""))
    implementation(thirdPartyLibraries["rxAndroid"] ?: error(""))
    implementation(thirdPartyLibraries["rxKotlin"] ?: error(""))

    // JSON
    implementation(thirdPartyLibraries["jsoniter"] ?: error(""))

    // Glide
    implementation(thirdPartyLibraries["glide"] ?: error(""))
    kapt(thirdPartyLibraries["glideCompiler"] ?: error(""))
    implementation(thirdPartyLibraries["glideOkHttp3"] ?: error(""))
    implementation(thirdPartyLibraries["glideRecyclerView"] ?: error("")) {
        // Excludes the support library because it's already included by Glide.
        isTransitive = false
    }

    // OkHttp & Retrofit
    implementation(thirdPartyLibraries["okHttp"] ?: error(""))
    implementation(thirdPartyLibraries["okHttpLogging"] ?: error(""))
    implementation(thirdPartyLibraries["stethoOkHttp"] ?: error(""))
    implementation(thirdPartyLibraries["retrofit"] ?: error(""))
    implementation(thirdPartyLibraries["retrofitAdapterRxJava"] ?: error(""))
    implementation(thirdPartyLibraries["retrofitConverterScalars"] ?: error(""))
    implementation(thirdPartyLibraries["retrofitConverterJsoniter"] ?: error("")) {
        exclude(module = "okhttp")
        exclude(module = "okio")
        exclude(module = "retrofit")
    }
    implementation(thirdPartyLibraries["retrofitUrlManager"] ?: error(""))

    // Suas-Android
    implementation(thirdPartyLibraries["suas"] ?: error(""))
    implementation(thirdPartyLibraries["suasThunk"] ?: error(""))
    implementation(thirdPartyLibraries["suasLogger"] ?: error(""))
    implementation(thirdPartyLibraries["suasMonitor"] ?: error(""))

    // MMKV
    implementation(thirdPartyLibraries["mmkv"] ?: error(""))

    // MvRx
    implementation(thirdPartyLibraries["mvrx"] ?: error(""))
    // Epoxy
    implementation(thirdPartyLibraries["epoxy"] ?: error(""))
    kapt(thirdPartyLibraries["epoxyProcessor"] ?: error(""))
    // Paris
    implementation(thirdPartyLibraries["paris"] ?: error(""))
    kapt(thirdPartyLibraries["parisProcessor"] ?: error(""))

    // Utils
    implementation(thirdPartyLibraries["utilCode"] ?: error(""))

    // Test
    testImplementation(thirdPartyLibraries["junit"] ?: error(""))
    androidTestImplementation(thirdPartyLibraries["androidxTestRunner"] ?: error(""))
    androidTestImplementation(thirdPartyLibraries["androidxTestEspresso"] ?: error(""))
}
