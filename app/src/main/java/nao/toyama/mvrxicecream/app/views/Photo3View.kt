package nao.toyama.mvrxicecream.app.views

import android.view.View
import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import nao.toyama.mvrxicecream.app.BR
import nao.toyama.mvrxicecream.app.R
import nao.toyama.mvrxicecream.app.databinding.PhotoView3Binding

@EpoxyModelClass(layout = R.layout.photo_view_3)
abstract class Photo3View : DataBindingEpoxyModel() {

    @EpoxyAttribute
    var title: CharSequence? = null

    @EpoxyAttribute
    var imageUrl: CharSequence? = null

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var clickListener: View.OnClickListener? = null

    override fun setDataBindingVariables(binding: ViewDataBinding?) {
        val photoView3Binding = binding as PhotoView3Binding?

        photoView3Binding?.setVariable(BR.title, title)
        photoView3Binding?.setVariable(BR.imageUrl, imageUrl)
        photoView3Binding?.imageView?.setOnClickListener(clickListener)
    }
}
