package nao.toyama.mvrxicecream.fragmentation.activities

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.EpoxyController

abstract class BaseBindingMvRxEpoxyActivity<T : ViewDataBinding, C : EpoxyController>
    : BaseMvRxEpoxyActivity<C>() {

    lateinit var binding: T

    override fun createView() {
        binding = DataBindingUtil.setContentView(this, layoutId)
    }
}
