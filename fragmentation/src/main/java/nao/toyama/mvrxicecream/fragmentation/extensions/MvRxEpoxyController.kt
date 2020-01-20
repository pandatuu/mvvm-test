package nao.toyama.mvrxicecream.fragmentation.extensions

import com.airbnb.epoxy.EpoxyController
import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.withState
import nao.toyama.mvrxicecream.MvRxEpoxyController
import nao.toyama.mvrxicecream.fragmentation.activities.BaseMvRxEpoxyActivity
import nao.toyama.mvrxicecream.fragmentation.fragments.BaseMvRxEpoxyFragment

/**
 * Create a [MvRxEpoxyController] that builds models with the given callback.
 */
fun <T : EpoxyController> BaseMvRxEpoxyFragment<T>.simpleController(
    buildModels: MvRxEpoxyController.() -> Unit
) = MvRxEpoxyController {
    if (view == null || isRemoving) return@MvRxEpoxyController
    buildModels()
}

/**
 * Create a [MvRxEpoxyController] that builds models with the given callback.
 * When models are built the current state of the viewModel will be provided.
 */
fun <
        T : EpoxyController,
        S : MvRxState, A : BaseMvRxViewModel<S>
> BaseMvRxEpoxyFragment<T>.simpleController(
    viewModel: A,
    buildModels: MvRxEpoxyController.(state: S) -> Unit
) = MvRxEpoxyController {
    if (view == null || isRemoving) return@MvRxEpoxyController
    withState(viewModel) { buildModels(it) }
}

/**
 * Create a [MvRxEpoxyController] that builds models with the given callback.
 * When models are built the current state of the viewModels will be provided.
 */
fun <
        T : EpoxyController,
        A : BaseMvRxViewModel<B>, B : MvRxState,
        C : BaseMvRxViewModel<D>, D : MvRxState
> BaseMvRxEpoxyFragment<T>.simpleController(
    viewModel1: A,
    viewModel2: C,
    buildModels: MvRxEpoxyController.(state1: B, state2: D) -> Unit
) = MvRxEpoxyController {
    if (view == null || isRemoving) return@MvRxEpoxyController
    withState(viewModel1, viewModel2) { state1, state2 ->
        buildModels(state1, state2)
    }
}

/**
 * Create a [MvRxEpoxyController] that builds models with the given callback.
 * When models are built the current state of the viewModels will be provided.
 */
fun <
        T : EpoxyController,
        A : BaseMvRxViewModel<B>, B : MvRxState,
        C : BaseMvRxViewModel<D>, D : MvRxState,
        E : BaseMvRxViewModel<F>, F : MvRxState
> BaseMvRxEpoxyFragment<T>.simpleController(
    viewModel1: A,
    viewModel2: C,
    viewModel3: E,
    buildModels: MvRxEpoxyController.(state1: B, state2: D, state3: F) -> Unit
) = MvRxEpoxyController {
    if (view == null || isRemoving) return@MvRxEpoxyController
    withState(viewModel1, viewModel2, viewModel3) { state1, state2, state3 ->
        buildModels(state1, state2, state3)
    }
}

/**
 * Create a [MvRxEpoxyController] that builds models with the given callback.
 */
fun <T : EpoxyController> BaseMvRxEpoxyActivity<T>.simpleController(
    buildModels: MvRxEpoxyController.() -> Unit
) = MvRxEpoxyController {
    if (isDestroyed) return@MvRxEpoxyController
    buildModels()
}

/**
 * Create a [MvRxEpoxyController] that builds models with the given callback.
 * When models are built the current state of the viewModel will be provided.
 */
fun <
        T : EpoxyController,
        S : MvRxState, A : BaseMvRxViewModel<S>
> BaseMvRxEpoxyActivity<T>.simpleController(
    viewModel: A,
    buildModels: MvRxEpoxyController.(state: S) -> Unit
) = MvRxEpoxyController {
    if (isDestroyed) return@MvRxEpoxyController
    withState(viewModel) { buildModels(it) }
}

/**
 * Create a [MvRxEpoxyController] that builds models with the given callback.
 * When models are built the current state of the viewModels will be provided.
 */
fun <
        T : EpoxyController,
        A : BaseMvRxViewModel<B>, B : MvRxState,
        C : BaseMvRxViewModel<D>, D : MvRxState
> BaseMvRxEpoxyActivity<T>.simpleController(
    viewModel1: A,
    viewModel2: C,
    buildModels: MvRxEpoxyController.(state1: B, state2: D) -> Unit
) = MvRxEpoxyController {
    if (isDestroyed) return@MvRxEpoxyController
    withState(viewModel1, viewModel2) { state1, state2 ->
        buildModels(state1, state2)
    }
}

/**
 * Create a [MvRxEpoxyController] that builds models with the given callback.
 * When models are built the current state of the viewModels will be provided.
 */
fun <
        T : EpoxyController,
        A : BaseMvRxViewModel<B>, B : MvRxState,
        C : BaseMvRxViewModel<D>, D : MvRxState,
        E : BaseMvRxViewModel<F>, F : MvRxState
> BaseMvRxEpoxyActivity<T>.simpleController(
    viewModel1: A,
    viewModel2: C,
    viewModel3: E,
    buildModels: MvRxEpoxyController.(state1: B, state2: D, state3: F) -> Unit
) = MvRxEpoxyController {
    if (isDestroyed) return@MvRxEpoxyController
    withState(viewModel1, viewModel2, viewModel3) { state1, state2, state3 ->
        buildModels(state1, state2, state3)
    }
}
