package nao.toyama.mvrxicecream

import nao.toyama.mvrxicecream.uddf.Provider
import zendesk.suas.*

abstract class SuasProvider(override val application: BaseApplication) : Provider<Store> {

    final override lateinit var store: Store

    final override fun initialize() {
        store = Suas.createStore(getReducers())
            .withMiddleware(getMiddlewares())
            .build()

        onStoreCreated()
    }

    open fun getReducers(): List<Reducer<*>> = listOf()

    open fun getMiddlewares(): List<Middleware> = listOf(
        AsyncMiddleware(),
        LoggerMiddleware()//,
//        MonitorMiddleware(this)
    )

    open fun onStoreCreated() {
    }
}
