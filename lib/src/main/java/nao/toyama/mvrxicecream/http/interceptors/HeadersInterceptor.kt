package nao.toyama.mvrxicecream.http.interceptors

import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.Response

abstract class HeadersInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .headers(getHeaders(chain))
            .build()

        return chain.proceed(request)
    }

    abstract fun getHeaders(chain: Interceptor.Chain): Headers
}
