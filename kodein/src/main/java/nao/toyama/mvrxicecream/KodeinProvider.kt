package nao.toyama.mvrxicecream

import nao.toyama.mvrxicecream.di.Provider
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXContextTranslators
import org.kodein.di.android.x.androidXModule

abstract class KodeinProvider(
    override val application: BaseApplication
) : Provider, KodeinAware {

    override val kodein: Kodein by Kodein.lazy {
        import(androidXModule(application))
        import(androidXContextTranslators)

        bindBuilder(this)

        getModules().forEach { import(it) }
    }

    open fun bindBuilder(builder: Kodein.MainBuilder) {
    }

    abstract fun getModules(): List<Kodein.Module>
}
