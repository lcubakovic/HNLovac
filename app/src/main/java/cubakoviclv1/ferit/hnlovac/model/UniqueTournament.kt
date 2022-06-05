package cubakoviclv1.ferit.hnlovac.model

data class UniqueTournament(
    val category: CategoryX,
    val id: Int,
    val name: String,
    val slug: String,
    val userCount: Int
)