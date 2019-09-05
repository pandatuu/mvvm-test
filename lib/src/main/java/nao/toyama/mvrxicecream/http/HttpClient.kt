package nao.toyama.mvrxicecream.http

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object HttpClient {

    private lateinit var retrofit: Retrofit

    fun init(settings: HttpSettings) {
        val builder = Retrofit.Builder()
            .client(settings.okHttpClientBuilder.build())
            .baseUrl(settings.baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        settings.convertFactories.forEach { builder.addConverterFactory(it) }

        retrofit = builder.build()
    }

    fun <T> getService(clazz: Class<T>): T = retrofit.create(clazz)
}
