package nao.toyama.mvrxicecream.extensions

import com.airbnb.epoxy.*

val EpoxyController.isTyped: Boolean
    get() = (this is TypedEpoxyController<*>) ||
            (this is Typed2EpoxyController<*, *>) ||
            (this is Typed3EpoxyController<*, *, *>) ||
            (this is Typed4EpoxyController<*, *, *, *>)

val EpoxyController.isNotTyped: Boolean
    get() = !isTyped
