package cubakoviclv1.ferit.hnlovac.liveEventsModel.hnl22_23

data class UniqueTournament(
    val category: CategoryX,
    val hasEventPlayerStatistics: Boolean,
    val hasPositionGraph: Boolean,
    val id: Int,
    val name: String,
    val slug: String,
    val userCount: Int
)