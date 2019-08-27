private val androidxVersion = "1.0.0"
private val constraintLayoutVersion = "1.1.2"
private val glideVersion = "4.9.0"

val thirdPartyLibraries: Map<String, String> by extra(mapOf(
    // KotlinX
    "ktxCoroutines" to kotlinxCoroutines("core"),
    "ktxCoroutinesAndroid" to kotlinxCoroutines("android"),
    "ktxCoroutinesRx2" to kotlinxCoroutines("rx2"),
    // AndroidX
    "appCompat" to "androidx.appcompat:appcompat:$androidxVersion",
    "recyclerView" to "androidx.recyclerview:recyclerview:$androidxVersion",
    "cardView" to "androidx.cardview:cardview:$androidxVersion",
    "constraintLayout" to "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion",
    "coreKtx" to "androidx.core:core-ktx:$androidxVersion",
    "fragmentKtx" to "androidx.fragment:fragment-ktx:$androidxVersion",
    "lifecycleViewModelKtx" to "androidx.lifecycle:lifecycle-viewmodel-ktx:2.0.0"
))

fun kotlinx(module: String, version: String? = null): String =
    "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$version" } ?: ""}"

fun kotlinxCoroutines(module: String): String =
    kotlinx("coroutines-$module", "1.3.0")
