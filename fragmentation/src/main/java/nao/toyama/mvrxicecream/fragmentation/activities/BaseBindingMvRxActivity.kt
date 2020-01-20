package nao.toyama.mvrxicecream.fragmentation.activities

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseBindingMvRxActivity<T : ViewDataBinding> : BaseMvRxActivity() {

    lateinit var binding: T

    override fun createView() {
        binding = DataBindingUtil.setContentView(this, layoutId)
    }
}
