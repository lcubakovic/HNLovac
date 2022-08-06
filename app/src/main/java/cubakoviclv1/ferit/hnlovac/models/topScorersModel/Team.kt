package cubakoviclv1.ferit.hnlovac.models.topScorersModel

data class Team(
    val id: Int,
    val name: String,
    val shortName: String,
    val slug: String,
    val sport: Sport,
    val teamColors: TeamColors,
    val type: Int,
    val userCount: Int
)