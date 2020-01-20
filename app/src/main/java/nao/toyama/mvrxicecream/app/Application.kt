package nao.toyama.mvrxicecream.app

import nao.toyama.mvrxicecream.BaseApplication
import nao.toyama.mvrxicecream.KoinProvider
import nao.toyama.mvrxicecream.SuasProvider
import org.koin.core.module.Module

class Application : BaseApplication() {

    override fun initDI() {
        diProvider = object : KoinProvider(this) {

            override fun getModules(): List<Module> = listOf()
        }
    }

    override fun initUDDF() {
        uddfProvider = object : SuasProvider(this) {
        }
    }
}
