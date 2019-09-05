package nao.toyama.mvrxicecream.uddf

import nao.toyama.mvrxicecream.BaseApplication

interface Provider<T> {

    val application: BaseApplication

    val store: T

    fun initialize()
}
