package nao.toyama.mvrxicecream.app.controllers

import com.airbnb.epoxy.Typed2EpoxyController
import nao.toyama.mvrxicecream.app.models.Photo
import nao.toyama.mvrxicecream.app.photoView

class PhotosController : Typed2EpoxyController<List<Photo>, Boolean>() {

    override fun buildModels(photos: List<Photo>, loadingMore: Boolean) {
        photos.forEach {
            photoView {
                id(it.id)
                imageUrl(it.url)
            }
        }
    }
}
