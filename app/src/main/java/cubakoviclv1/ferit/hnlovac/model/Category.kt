package cubakoviclv1.ferit.hnlovac.model

data class Category(
    val alpha2: String,
    val flag: String,
    val id: Int,
    val name: String,
    val slug: String,
    val sport: SportX
)