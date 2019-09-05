package nao.toyama.mvrxicecream

import nao.toyama.mvrxicecream.di.Provider
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

abstract class KoinProvider(
    override val application: BaseApplication
) : Provider {

    init {
        startKoin {
            androidLogger()
            androidContext(application)

            modules(getModules())
        }
    }

    abstract fun getModules(): List<Module>
}
