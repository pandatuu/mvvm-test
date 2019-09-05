package nao.toyama.mvrxicecream

import android.app.Application
import com.jeepc.jsoniterconverter.JsoniterConverterFactory
import com.tencent.mmkv.MMKV
import me.yokeyword.fragmentation.Fragmentation
import nao.toyama.mvrxicecream.http.HttpClient
import nao.toyama.mvrxicecream.http.HttpSettings
import nao.toyama.mvrxicecream.http.interceptors.HeadersInterceptor
import retrofit2.Converter
import retrofit2.converter.scalars.ScalarsConverterFactory

typealias DIProvider = nao.toyama.mvrxicecream.di.Provider
typealias UDDFProvider<T> = nao.toyama.mvrxicecream.uddf.Provider<T>

abstract class BaseApplication : Application() {

    var diProvider: DIProvider? = null
    var uddfProvider: UDDFProvider<*>? = null

    // 基础 HTTP URL
    open val baseHttpUrl: String
        get() = throw NotImplementedError("Please set base URL before using HTTP client.")

    override fun onCreate() {
        super.onCreate()

        initDI()

        initMMKV()

        initHttpClient()

        initUDDF()

        initFragmentation()
    }

    // 初始化 DI
    open fun initDI() {
    }

    // 初始化 MMKV
    open fun initMMKV() {
        MMKV.initialize(this)
    }

    // 初始化 HTTP 客户端
    open fun initHttpClient() {
        val httpSettingsBuilder = HttpSettings.Builder()
            // 设置基础 URL
            .baseUrl(baseHttpUrl)
            // 启用日志
            .enableLogging()
            // 启用监控
            .enableMonitor()

        // 增加动态域
        getHttpDynamicDomains().forEach { httpSettingsBuilder.putDomain(it.key, it.value) }

        // 增加头解析器
        getHttpHeadersInterceptors().forEach { httpSettingsBuilder.addHeadersInterceptor(it) }

        // 增加转换器
        getHttpConverterFactories().forEach { httpSettingsBuilder.addConverterFactory(it) }

        HttpClient.init(httpSettingsBuilder.build())
    }

    // 获取 HTTP 动态域
    open fun getHttpDynamicDomains(): Map<String, String> = mapOf()

    // 获取 HTTP 头解析器
    open fun getHttpHeadersInterceptors(): List<HeadersInterceptor> {
        val interceptor = getHttpHeadersInterceptor() ?: return listOf()

        return listOf(interceptor)
    }

    open fun getHttpHeadersInterceptor(): HeadersInterceptor? = null

    // 获取 HTTP 转换器
    open fun getHttpConverterFactories(): List<Converter.Factory> {
        val scalarsConverterFactory = getHttpScalarsConverterFactory()
        val jsonConverterFactory = getHttpJsonConverterFactory()

        val converterFactories = mutableListOf<Converter.Factory>()
        if (scalarsConverterFactory != null) {
            converterFactories.add(scalarsConverterFactory)
        }
        if (jsonConverterFactory != null) {
            converterFactories.add(jsonConverterFactory)
        }

        return converterFactories
    }

    open fun getHttpScalarsConverterFactory(): Converter.Factory? =
        ScalarsConverterFactory.create()

    open fun getHttpJsonConverterFactory(): Converter.Factory? =
        JsoniterConverterFactory.create()

    // 初始化单向数据流
    open fun initUDDF() {
    }

    // 初始化 Fragmentation
    open fun initFragmentation() {
        Fragmentation.builder()
            .stackViewMode(fragmentationStackViewMode)
            .debug(isFragmentationDebugEnabled)
            .install()
    }

    // Fragmentation 堆栈试图模式
    open val fragmentationStackViewMode: Int
        get() = Fragmentation.BUBBLE

    // 是否开启 Fragmentation 调试
    open val isFragmentationDebugEnabled: Boolean
        get() = true
}
