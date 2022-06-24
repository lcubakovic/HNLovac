package cubakoviclv1.ferit.hnlovac.liveEventsModel.hnl22_23

data class Tournament(
    val category: Category,
    val id: Int,
    val name: String,
    val priority: Int,
    val slug: String,
    val uniqueTournament: UniqueTournament
)