package nao.toyama.mvrxicecream.app.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.airbnb.epoxy.AfterPropsSet
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.blankj.utilcode.util.SizeUtils.dp2px
import com.blankj.utilcode.util.SizeUtils.sp2px
import com.bumptech.glide.Glide

private val margin10 = dp2px(10.0f)

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class Photo2View @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    @set:TextProp
    var description: CharSequence? = null

    @TextProp
    lateinit var imageUrl: CharSequence

    @set:CallbackProp
    var clickListener: OnClickListener? = null

    private val tv: TextView = TextView(context).apply {
        text = "PhotoView2"
        textSize = 40.0f

        addView(this, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT).apply {
            bottomMargin = margin10
        })
    }
    private val textView: TextView = TextView(context).apply {
        addView(this, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT).apply {
            bottomMargin = margin10
        })
    }
    private val imageView: ImageView = ImageView(context).apply {
        scaleType = ImageView.ScaleType.FIT_CENTER
        adjustViewBounds = true

        addView(this, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT))
    }

    init {
        orientation = VERTICAL
        setPadding(margin10, margin10, margin10, margin10)
    }

    @AfterPropsSet
    fun afterPropsSet() {
        textView.text = description

        Glide.with(imageView)
            .load(imageUrl)
            .into(imageView)

        imageView.setOnClickListener(clickListener)
    }
}
