package nao.toyama.mvrxicecream.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.mvrx.MvRxView
import com.airbnb.mvrx.MvRxViewModelStore
import nao.toyama.mvrxicecream.MvRxViewId

abstract class BaseMvRxActivity : AppCompatActivity(), MvRxView {

    override val mvrxViewModelStore: MvRxViewModelStore by lazy {
        MvRxViewModelStore(viewModelStore)
    }

    open val layoutId: Int = 0

    private val mvrxViewIdProperty = MvRxViewId()
    final override val mvrxViewId: String by mvrxViewIdProperty

    override fun onCreate(savedInstanceState: Bundle?) {
        mvrxViewModelStore.restoreViewModels(this, savedInstanceState)
        mvrxViewIdProperty.restoreFrom(savedInstanceState)

        super.onCreate(savedInstanceState)

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
