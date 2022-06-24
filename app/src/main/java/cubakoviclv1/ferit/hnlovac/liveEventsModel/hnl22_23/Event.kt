package cubakoviclv1.ferit.hnlovac.liveEventsModel.hnl22_23

data class Event(
    val awayScore: AwayScore,
    val awayTeam: AwayTeam,
    val changes: Changes,
    val customId: String,
    val finalResultOnly: Boolean,
    val hasGlobalHighlights: Boolean,
    val homeScore: HomeScore,
    val homeTeam: HomeTeam,
    val id: Int,
    val roundInfo: RoundInfo,
    val slug: String,
    val startTimestamp: Int,
    val status: Status,
    val time: Time,
    val tournament: Tournament,
    val winnerCode: Int
)