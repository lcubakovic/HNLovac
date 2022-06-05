package cubakoviclv1.ferit.hnlovac.model

data class Team(
    val disabled: Boolean,
    val gender: String,
    val id: Int,
    val name: String,
    val nameCode: String,
    val national: Boolean,
    val shortName: String,
    val slug: String,
    val sport: Sport,
    val teamColors: TeamColors,
    val type: Int,
    val userCount: Int
)