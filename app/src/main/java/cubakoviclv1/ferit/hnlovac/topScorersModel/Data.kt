package cubakoviclv1.ferit.hnlovac.topScorersModel

data class Data(
    val goals: Goals,
    val league_id: Int,
    val matches_played: Int,
    val minutes_played: Int,
    val penalties: Int,
    val player: Player,
    val pos: Int,
    val season_id: Int,
    val substituted_in: Any,
    val team: Team
)