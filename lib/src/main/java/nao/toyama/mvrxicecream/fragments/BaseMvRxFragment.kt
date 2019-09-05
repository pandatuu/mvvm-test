package nao.toyama.mvrxicecream.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.airbnb.mvrx.MvRxView
import com.airbnb.mvrx.MvRxViewModelStore
import nao.toyama.mvrxicecream.MvRxViewId

abstract class BaseMvRxFragment : Fragment(), MvRxView {

    override val mvrxViewModelStore: MvRxViewModelStore by lazy {
        MvRxViewModelStore(viewModelStore)
    }

    open val layoutId: Int = 0

    private val mvrxViewIdProperty = MvRxViewId()
    final override val mvrxViewId: String by mvrxViewIdProperty

    /**
     * Fragments should override the subscriptionLifecycle owner so that subscriptions made after onCreate
     * are properly disposed as fragments are moved from/to the backstack.
     */
    override val subscriptionLifecycleOwner: LifecycleOwner
        get() = viewLifecycleOwnerLiveData.value ?: this

    override fun onCreate(savedInstanceState: Bundle?) {
        mvrxViewModelStore.restoreViewModels(this, savedInstanceState)
        mvrxViewIdProperty.restoreFrom(savedInstanceState)

        super.onCreate(savedInstanceState)

        initStatusBar()
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
}
