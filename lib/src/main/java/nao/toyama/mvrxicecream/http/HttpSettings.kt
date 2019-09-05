package nao.toyama.mvrxicecream.http

import com.facebook.stetho.okhttp3.StethoInterceptor
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import nao.toyama.mvrxicecream.http.interceptors.DefaultNetworkInterceptor
import nao.toyama.mvrxicecream.http.interceptors.HeadersInterceptor
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier

class HttpSettings private constructor(private val builder: Builder) {

    val isMonitorEnabled: Boolean
        get() = builder.isMonitorEnabled

    val isLoggingEnabled: Boolean
        get() = builder.isLoggingEnabled

    val baseUrl: String
        get() = builder.baseUrl

    val convertFactories: List<Converter.Factory>
        get() = builder.converterFactories.toList()

    val okHttpClientBuilder: OkHttpClient.Builder
        get() = builder.httpBuilder

    class Builder {

        lateinit var baseUrl: String
        var isMonitorEnabled: Boolean = false
        var isLoggingEnabled: Boolean = false
        val converterFactories: MutableList<Converter.Factory> = mutableListOf()
        var httpBuilder: OkHttpClient.Builder =
            RetrofitUrlManager.getInstance()
                .with(OkHttpClient.Builder())
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addNetworkInterceptor(DefaultNetworkInterceptor())
                .hostnameVerifier(HostnameVerifier { _, _ -> true })

//        fun with(application: Application): Builder {
//            // TODO: 增加其他配置（如：缓存，网络，等）
//
//            return this
//        }

        fun builder(builder: OkHttpClient.Builder): Builder {
            httpBuilder = builder

            return this
        }

        fun baseUrl(url: String): Builder {
            this.baseUrl = url

            return this
        }

        fun cache(cache: Cache): Builder {
            httpBuilder.cache(cache)

            return this
        }

        fun enableMonitor(): Builder {
            isMonitorEnabled = true
            httpBuilder.addNetworkInterceptor(StethoInterceptor())

            return this
        }

        fun enableLogging(): Builder {
            isLoggingEnabled = true

            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            httpBuilder.addInterceptor(loggingInterceptor)

            return this
        }

        fun connectTimeout(timeout: Long, unit: TimeUnit = TimeUnit.SECONDS): Builder {
            httpBuilder.connectTimeout(timeout, unit)

            return this
        }

        fun readTimeout(timeout: Long, unit: TimeUnit = TimeUnit.SECONDS): Builder {
            httpBuilder.readTimeout(timeout, unit)

            return this
        }

        fun writeTimeout(timeout: Long, unit: TimeUnit = TimeUnit.SECONDS): Builder {
            httpBuilder.writeTimeout(timeout, unit)

            return this
        }

        fun addInterceptor(interceptor: Interceptor): Builder {
            httpBuilder.addInterceptor(interceptor)

            return this
        }

        fun addHeadersInterceptor(interceptor: HeadersInterceptor): Builder {
            addInterceptor(interceptor)

            return this
        }

        fun addNetworkInterceptor(interceptor: Interceptor): Builder {
            httpBuilder.addNetworkInterceptor(interceptor)

            return this
        }

        fun addConverterFactory(factory: Converter.Factory): Builder {
            converterFactories.add(factory)

            return this
        }

        fun putDomain(name: String, url: String): Builder {
            RetrofitUrlManager.getInstance().putDomain(name, url)

            return this
        }

        fun build(): HttpSettings = HttpSettings(this)
    }
}
