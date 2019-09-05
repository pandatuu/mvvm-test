package nao.toyama.mvrxicecream.di

import nao.toyama.mvrxicecream.BaseApplication

interface Provider {

    // 应用
    val application: BaseApplication

//    // 初始化
//    fun initialize(context: Context)
}
