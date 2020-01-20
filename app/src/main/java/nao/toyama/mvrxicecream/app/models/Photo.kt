package nao.toyama.mvrxicecream.app.models

data class Photo(
    val id: String,
    val name: String,
    val url: String,
    val description: String = ""
)
