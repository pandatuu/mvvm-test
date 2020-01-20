package nao.toyama.mvrxicecream.fragmentation.fragments

import android.os.Bundle
import android.view.View
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyRecyclerView
import nao.toyama.mvrxicecream.extensions.isNotTyped

abstract class BaseMvRxEpoxyFragment<C : EpoxyController> : BaseMvRxFragment() {

    protected lateinit var recyclerView: EpoxyRecyclerView
    protected val epoxyController: C by lazy { epoxyController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        epoxyController.onRestoreInstanceState(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postViewCreated()

        recyclerView.setController(epoxyController)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        epoxyController.onSaveInstanceState(outState)
    }

    override fun invalidate() {
        if (epoxyController.isNotTyped) {
            epoxyController.requestModelBuild()
        }
    }

    abstract fun epoxyController(): C

    abstract fun postViewCreated()
}
