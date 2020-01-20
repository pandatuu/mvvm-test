package nao.toyama.mvrxicecream.app.fragments

import com.airbnb.mvrx.fragmentViewModel
import com.blankj.utilcode.util.ToastUtils
import nao.toyama.mvrxicecream.MvRxEpoxyController
import nao.toyama.mvrxicecream.app.R
import nao.toyama.mvrxicecream.app.databinding.FragmentPhotoListBinding
import nao.toyama.mvrxicecream.app.extensions.onLoadMore
import nao.toyama.mvrxicecream.app.extensions.onRefresh
import nao.toyama.mvrxicecream.app.photoView
import nao.toyama.mvrxicecream.app.viewmodels.PhotoListViewModel
import nao.toyama.mvrxicecream.app.views.photo2View
import nao.toyama.mvrxicecream.app.views.photo3View
import nao.toyama.mvrxicecream.fragments.BaseBindingMvRxEpoxyFragment
import nao.toyama.mvrxicecream.simpleController

class PhotoListFragment
    : BaseBindingMvRxEpoxyFragment<FragmentPhotoListBinding, MvRxEpoxyController>() {

    override val layoutId: Int = R.layout.fragment_photo_list

    private val viewModel: PhotoListViewModel by fragmentViewModel()

    override fun epoxyController(): MvRxEpoxyController = simpleController(viewModel) { state ->
        state.photos.forEachIndexed { index, photo ->
            when (index % 3) {
                0 -> photoView {
                    id(photo.id)
                    imageUrl(photo.url)
                    clickListener { _ ->
                        ToastUtils.showLong(photo.id as CharSequence)
                    }
                }
                1 -> photo2View {
                    id(photo.id)
                    description(photo.description)
                    imageUrl(photo.url)
                    clickListener { _ ->
                        ToastUtils.showLong(photo.description as CharSequence)
                    }
                }
                2 -> photo3View {
                    id(photo.id)
                    title(photo.name)
                    imageUrl(photo.url)
                    clickListener { _ ->
                        ToastUtils.showLong(photo.url as CharSequence)
                    }
                }
            }
        }
    }

    override fun postViewCreated() {
        recyclerView = binding.recyclerView

        val refreshLayout = binding.refreshLayout
        refreshLayout.onRefresh {
            viewModel.getPhotos(true)
        }
        refreshLayout.onLoadMore {
            viewModel.getPhotos(false)
        }

        refreshLayout.autoRefresh()
    }
}
