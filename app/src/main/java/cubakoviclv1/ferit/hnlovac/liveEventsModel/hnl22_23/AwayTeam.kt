package cubakoviclv1.ferit.hnlovac.liveEventsModel.hnl22_23

data class AwayTeam(
    val disabled: Boolean,
    val gender: String,
    val id: Int,
    val name: String,
    val nameCode: String,
    val national: Boolean,
    val shortName: String,
    val slug: String,
    val sport: Sport,
    val subTeams: List<Any>,
    val teamColors: TeamColors,
    val type: Int,
    val userCount: Int
)