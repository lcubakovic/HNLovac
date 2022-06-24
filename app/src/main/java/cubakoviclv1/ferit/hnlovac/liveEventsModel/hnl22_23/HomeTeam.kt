package cubakoviclv1.ferit.hnlovac.liveEventsModel.hnl22_23

data class HomeTeam(
    val disabled: Boolean,
    val gender: String,
    val id: Int,
    val name: String,
    val nameCode: String,
    val national: Boolean,
    val shortName: String,
    val slug: String,
    val sport: SportX,
    val subTeams: List<Any>,
    val teamColors: TeamColorsX,
    val type: Int,
    val userCount: Int
)