package nao.toyama.mvrxicecream.app.extensions

import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

fun SmartRefreshLayout.onRefresh(
    context: CoroutineContext = Dispatchers.IO,
    block: suspend () -> Unit
) {
    setOnRefreshListener {
        GlobalScope.launch(context) {
            block()

            this@onRefresh.finishRefresh()
        }
    }
}

fun SmartRefreshLayout.onLoadMore(
    context: CoroutineContext = Dispatchers.IO,
    block: suspend () -> Unit
) {
    setOnLoadMoreListener {
        GlobalScope.launch(context) {
            block()

            this@onLoadMore.finishLoadMore()
        }
    }
}
