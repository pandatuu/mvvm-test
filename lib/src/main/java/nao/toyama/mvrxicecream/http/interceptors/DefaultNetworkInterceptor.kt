package nao.toyama.mvrxicecream.http.interceptors

import com.blankj.utilcode.util.NetworkUtils
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

class DefaultNetworkInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (NetworkUtils.isConnected()) {
            val maxAge = 10

            // 有网络不会使用缓存数据
            return chain.proceed(request)
                .newBuilder()
                .removeHeader("Pragma")
                .removeHeader("Cache-Control")
                .header("Cache-Control", "public, only-if-cached, max-stale=$maxAge")
                .build()
        } else {
            val maxStale = 60 * 60 * 24 * 3

            request = request
                .newBuilder()
                .cacheControl(CacheControl.FORCE_CACHE)
                .build()

            // 无网络时强制使用缓存数据
            return chain.proceed(request)
                .newBuilder()
                .removeHeader("Pragma")
                .removeHeader("Cache-Control")
                .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                .build()
        }
    }
}
