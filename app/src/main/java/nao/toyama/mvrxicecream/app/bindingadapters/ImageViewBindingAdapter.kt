package nao.toyama.mvrxicecream.app.bindingadapters

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object ImageViewBindingAdapter {

    @JvmStatic
    @BindingAdapter(
        "android:imageUrl",
        "android:placeholder",
        "android:placeholderRes",
        "android:error",
        "android:errorRes",
        "android:fallback",
        "android:fallbackRes",
        "android:isCircle",
        requireAll = false
    )
    fun setImageUrl(
        imageView: ImageView,
        imageUrl: String?,
        placeholder: Drawable?,
        placeholderRes: Int,
        error: Drawable?,
        errorRes: Int,
        fallback: Drawable?,
        fallbackRes: Int,
        isCircle: Boolean
    ) {
        var requestOptions = RequestOptions()
            .placeholder(placeholder)
            .error(error)
            .fallback(fallback)
        if (placeholderRes != 0) {
            requestOptions = requestOptions.placeholder(placeholderRes)
        }
        if (errorRes != 0) {
            requestOptions = requestOptions.error(errorRes)
        }
        if (fallbackRes != 0) {
            requestOptions = requestOptions.fallback(fallbackRes)
        }
        if (isCircle) {
            requestOptions = requestOptions.circleCrop()
        }

        Glide.with(imageView)
            .load(imageUrl)
            .apply(requestOptions)
            .into(imageView)
    }
}
