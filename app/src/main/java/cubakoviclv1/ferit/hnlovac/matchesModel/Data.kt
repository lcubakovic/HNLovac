package cubakoviclv1.ferit.hnlovac.matchesModel

data class Data(
    val away_team: AwayTeam,
    val group: Group,
    val home_team: HomeTeam,
    val league_id: Int,
    val match_id: Int,
    val match_start: String,
    val match_start_iso: String,
    val minute: Int,
    val referee_id: Any,
    val round: Round,
    val season_id: Int,
    val stage: Stage,
    val stats: Stats,
    val status: String,
    val status_code: Int,
    val venue: Venue
)