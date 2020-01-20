package nao.toyama.mvrxicecream.app.viewmodels

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import kotlinx.coroutines.delay
import nao.toyama.mvrxicecream.BuildConfig
import nao.toyama.mvrxicecream.app.models.Photo
import java.util.*

private val photoUrls = listOf(
    "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3518071394,1573821605&fm=26&gp=0.jpg",
    "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567763187633&di=08b741b6b94cffb301bf51c44684f129&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201807%2F05%2F20180705213339_wrkhi.jpg",
    "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567763221716&di=acb9fb43a5c324815c68ecde0b750a04&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201706%2F09%2F20170609194544_FAidB.jpeg",
    "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567763246520&di=0660e38d6fdabebfde2424129099bc34&imgtype=0&src=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201409%2F09%2F20140909012350_KYTjJ.thumb.700_0.jpeg",
    "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567763289567&di=a2531b66d68c1315b1d3b94e0c03c850&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201510%2F20%2F20151020235059_mtwUG.thumb.700_0.jpeg",
    "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567763327930&di=252b739fe425f337ccf0bb74a30f1238&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201410%2F15%2F20141015205737_Ut8RU.jpeg",
    "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567763412564&di=1c9fa1c459b84402258fe1e941ab811c&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fblog%2F201510%2F13%2F20151013190852_Bzrjs.thumb.700_0.jpeg",
    "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567763429165&di=da1abefa75a2b483ecf5c9c65e8f7de5&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2018-06-07%2F5b18d6f3ede4d.jpg",
    "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567763450564&di=0945931dcdf9a1ac206da3aaef02c685&imgtype=0&src=http%3A%2F%2Fimgcdn.gz01.bdysite.com%2Fupfile%2Ft01998953c4599413a9.jpg",
    "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567763484055&di=a9bedd04f287def450dceb245501c956&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fblog%2F201510%2F23%2F20151023204804_HUJfN.jpeg"
)

data class PhotoListState(val photos: List<Photo> = listOf()) : MvRxState

class PhotoListViewModel(
    initialState: PhotoListState
) : BaseMvRxViewModel<PhotoListState>(initialState, debugMode = BuildConfig.DEBUG) {

    suspend fun getPhotos(isRefresh: Boolean) {
        val newPhotos = photoUrls.map {
            Photo(UUID.randomUUID().toString(), "美女", it, it)
        }

        if (isRefresh) {
            delay(1000)

            setState {
                copy(photos = newPhotos)
            }
        } else {
            delay(1000)

            setState {
                copy(photos = photos + newPhotos)
            }
        }
    }
}
