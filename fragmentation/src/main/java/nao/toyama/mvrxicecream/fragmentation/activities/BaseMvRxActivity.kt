package nao.toyama.mvrxicecream.fragmentation.activities

import android.os.Bundle
import android.os.PersistableBundle
import com.airbnb.mvrx.MvRxView
import com.airbnb.mvrx.MvRxViewModelStore
import me.yokeyword.fragmentation.BuildConfig
import me.yokeyword.fragmentation.Fragmentation
import me.yokeyword.fragmentation.SupportActivity
import nao.toyama.mvrxicecream.MvRxViewId

abstract class BaseMvRxActivity : SupportActivity(), MvRxView {

    override val mvrxViewModelStore: MvRxViewModelStore by lazy {
        MvRxViewModelStore(viewModelStore)
    }

    open val layoutId: Int = 0

    private val mvrxViewIdProperty = MvRxViewId()
    final override val mvrxViewId: String by mvrxViewIdProperty

    open val stackViewMode: Int
        get() = Fragmentation.NONE

    open val isDebugEnabled: Boolean
        get() = BuildConfig.DEBUG

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        mvrxViewModelStore.restoreViewModels(this, savedInstanceState)
        mvrxViewIdProperty.restoreFrom(savedInstanceState)

        super.onCreate(savedInstanceState, persistentState)

        // 初始化 Fragmentation
        Fragmentation.builder()
            .stackViewMode(stackViewMode)
            .debug(isDebugEnabled)
            .install()

        initStatusBar()

        createView()
    }

    override fun onStart() {
        super.onStart()

        // This ensures that invalidate() is called for static screens that don't
        // subscribe to a ViewModel.
        postInvalidate()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        mvrxViewModelStore.saveViewModels(outState)
        mvrxViewIdProperty.saveTo(outState)
    }

    // 初始化状态栏
    open fun initStatusBar() {
    }

    // 创建视图
    abstract fun createView()
}
