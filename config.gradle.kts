private val androidxVersion = "2.1.0-rc01"
private val androidxSupportVersion = "1.0.0"
private val constraintLayoutVersion = "1.1.2"
private val rxLifecycleVersion = "3.0.0"
private val glideVersion = "4.9.0"
private val okHttpVersion = "4.1.0"
private val stethoVersion = "1.5.1"
private val retrofitVersion = "2.6.1"
private val koinVersion = "2.0.1"
private val kodeinVersion = "6.3.3"
private val suasVersion = "1.2.0"
private val mmkvVersion = "1.0.22"
private val epoxyVersion = "3.7.0"
private val parisVersion = "1.3.0"
private val fragmentationxVersion = "1.0.1"
private val smartRefreshLayoutVersion = "1.1.0"
private val basePopupVersion = "2.2.1"
private val immersionBarVersion = "3.0.0-beta06-3"

val thirdPartyLibraries: Map<String, String> by extra(mapOf(
    // KotlinX
    "ktxCoroutines" to kotlinxCoroutines("core"),
    "ktxCoroutinesAndroid" to kotlinxCoroutines("android"),
    "ktxCoroutinesRx2" to kotlinxCoroutines("rx2"),

    // AndroidX
    "androidxCore" to "androidx.arch.core:core-common:$androidxVersion",
    "androidxLifecycle" to "androidx.lifecycle:lifecycle-common-java8:$androidxVersion",
    "androidxLifecycleLiveData" to "androidx.lifecycle:lifecycle-livedata:$androidxVersion",
    "androidxLifecycleViewModel" to "androidx.lifecycle:lifecycle-viewmodel:$androidxVersion",
    "androidxLifecycleCompiler" to "androidx.lifecycle:lifecycle-compiler:$androidxVersion",
    "androidxRoom" to "androidx.room:room-common:$androidxVersion",
    "androidxRoomRxJava" to "androidx.room:room-rxjava2:$androidxVersion",
    "androidxRoomCompiler" to "androidx.room:room-compiler:$androidxVersion",
    "androidxAppCompat" to "androidx.appcompat:appcompat:$androidxSupportVersion",
    "androidxRecyclerView" to "androidx.recyclerview:recyclerview:$androidxSupportVersion",
    "androidxCardView" to "androidx.cardview:cardview:$androidxSupportVersion",
    "androidxConstraintLayout" to "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion",
    "androidxCoreKtx" to "androidx.core:core-ktx:$androidxSupportVersion",
    "androidxFragmentKtx" to "androidx.fragment:fragment-ktx:$androidxSupportVersion",
    "androidxLifecycleViewModelKtx" to "androidx.lifecycle:lifecycle-viewmodel-ktx:2.0.0",

    // RxJava
    "rxJava" to "io.reactivex.rxjava2:rxjava:2.1.2",
    "rxAndroid" to "io.reactivex.rxjava2:rxandroid:2.1.1",
    "rxKotlin" to "io.reactivex.rxjava2:rxkotlin:2.4.0",

    // RxLifecycle
    "rxLifecycle" to "com.trello.rxlifecycle3:rxlifecycle:$rxLifecycleVersion",
    "rxLifecycleAndroid" to "com.trello.rxlifecycle3:rxlifecycle-android:$rxLifecycleVersion",
    "rxLifecycleAndroidLifecycle" to "com.trello.rxlifecycle3:rxlifecycle-android-lifecycle:$rxLifecycleVersion",
    "rxLifecycleComponent" to "com.trello.rxlifecycle3:rxlifecycle-component:$rxLifecycleVersion",
    "rxLifecycleKotlin" to "com.trello.rxlifecycle3:rxlifecycle-kotlin:$rxLifecycleVersion",

    // RxPermissions
    "rxPermissions" to "com.github.tbruyelle:rxpermissions:0.10.2",

    // JSON
    "jsoniter" to "com.jsoniter:jsoniter:0.9.23",

    // Glide
    "glide" to "com.github.bumptech.glide:glide:$glideVersion",
    "glideCompiler" to "com.github.bumptech.glide:compiler:$glideVersion",
    "glideOkHttp3" to "com.github.bumptech.glide:okhttp3-integration:$glideVersion",
    "glideRecyclerView" to "com.github.bumptech.glide:recyclerview-integration:$glideVersion",

    // OkHttp & Retrofit
    "okHttp" to "com.squareup.okhttp3:okhttp:$okHttpVersion",
    "okHttpLogging" to "com.squareup.okhttp3:logging-interceptor:$okHttpVersion",
    "stetho" to "com.facebook.stetho:stetho:$stethoVersion",
    "stethoOkHttp" to "com.facebook.stetho:stetho-okhttp3:$stethoVersion",
    "retrofit" to "com.squareup.retrofit2:retrofit:$retrofitVersion",
    "retrofitAdapterRxJava" to "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion",
    "retrofitConverterScalars" to "com.squareup.retrofit2:converter-scalars:$retrofitVersion",
    "retrofitConverterJsoniter" to "com.jeepc.retrofit2:jsoniterconverter:2.3.1",
    "retrofitUrlManager" to "me.jessyan:retrofit-url-manager:1.4.0",

    // Koin
    "koinAndroid" to "org.koin:koin-android:$koinVersion",
    "koinAndroidxScope" to "org.koin:koin-androidx-scope:$koinVersion",
    "koinAndroidxViewModel" to "org.koin:koin-androidx-viewmodel:$koinVersion",

    // Kodein
    "kodeinGeneric" to "org.kodein.di:kodein-di-generic-jvm:$kodeinVersion",
    "kodeinErased" to "org.kodein.di:kodein-di-erased-jvm:$kodeinVersion",
    "kodeinAndroidx" to "org.kodein.di:kodein-di-framework-android-x:$kodeinVersion",

    // Suas-Android
    "suas" to "com.zendesk.suas:suas:$suasVersion",
    "suasThunk" to "com.zendesk.suas:suas-thunk:$suasVersion",
    "suasLogger" to "com.zendesk.suas:suas-logger:$suasVersion",
    "suasMonitor" to "com.zendesk.suas:suas-monitor:$suasVersion",

    // MMKV
    "mmkv" to "com.tencent:mmkv:$mmkvVersion",
    "mmkvStatic" to "com.tencent:mmkv-static:$mmkvVersion",

   // MvRx
    "mvrx" to "com.airbnb.android:mvrx:1.0.2",
    // Epoxy
    "epoxy" to "com.airbnb.android:epoxy:$epoxyVersion",
    "epoxyDatabinding" to "com.airbnb.android:epoxy-databinding:$epoxyVersion",
    "epoxyGlidePreloading" to "com.airbnb.android:epoxy-glide-preloading:$epoxyVersion",
    "epoxyPaging" to "com.airbnb.android:epoxy-paging:$epoxyVersion",
    "epoxyLitho" to "com.airbnb.android:epoxy-litho:$epoxyVersion",
    "epoxyProcessor" to "com.airbnb.android:epoxy-processor:$epoxyVersion",
    // Paris
    "paris" to "com.airbnb.android:paris:$parisVersion",
    "parisProcessor" to "com.airbnb.android:paris-processor:$parisVersion",

    // Fragmentation
    "fragmentationx" to "me.yokeyword:fragmentationx:$fragmentationxVersion",
    "fragmentationxCore" to "me.yokeyword:fragmentationx-core:$fragmentationxVersion",
    "fragmentationxSwipeback" to "me.yokeyword:fragmentationx-swipeback:$fragmentationxVersion",

    // ARouter
    "arouter" to "com.alibaba:arouter-api:1.5.0",
    "arouterAnnotation" to "com.alibaba:arouter-annotation:1.0.6",
    "arouterCompiler" to "com.alibaba:arouter-compiler:1.2.2",

    // Views
    "lottie" to "com.airbnb.android:lottie:3.0.7",
    "bottomTabX" to "me.majiajie:pager-bottom-tab-strip:2.3.0X",
    "gloading" to "com.billy.android:gloading:1.0.0",
    "smartRefreshLayout" to "com.scwang.smartrefresh:SmartRefreshLayout:$smartRefreshLayoutVersion",
    "smartRefreshHeader" to "com.scwang.smartrefresh:SmartRefreshHeader:$smartRefreshLayoutVersion",
    "basePopup" to "com.github.razerdp:BasePopup:$basePopupVersion",
    "basePopupAndroidx" to "com.github.razerdp:BasePopup-compat-androidx:$basePopupVersion",
    "toast" to "com.hjq:toast:8.0",
    "immersionBar" to "com.gyf.immersionbar:immersionbar:$immersionBarVersion",
    "immersionBarComponents" to "com.gyf.immersionbar:immersionbar-components:$immersionBarVersion",
    "immersionBarKtx" to "com.gyf.immersionbar:immersionbar-ktx:$immersionBarVersion",

    // JWT
    "jwtDecode" to "com.auth0.android:jwtdecode:1.3.0",

    // Utils
    "utilCode" to "com.blankj:utilcode:1.23.7",

    // JUnit
    "junit" to "junit:junit:4.12",

    // AndroidX Test
    "androidxTestRunner" to "androidx.test:runner:1.2.0",
    "androidxTestEspresso" to "androidx.test.espresso:espresso-core:3.2.0",

    // 占位（新库请添加到前面）
    "" to ""
))

fun kotlinx(module: String, version: String? = null): String =
    "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$version" } ?: ""}"

fun kotlinxCoroutines(module: String): String =
    kotlinx("coroutines-$module", "1.3.0")
