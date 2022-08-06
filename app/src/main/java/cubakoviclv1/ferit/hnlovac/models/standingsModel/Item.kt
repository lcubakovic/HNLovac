package cubakoviclv1.ferit.hnlovac.models.standingsModel

data class Item(
    val Active: Boolean,
    val CompId: Int,
    val CompetitionName: String,
    val Drew: Int,
    val GoalsConceded: Int,
    val GoalsScored: Int,
    val Id: Int,
    val LastRank: Int,
    val Lost: Int,
    val Points: Int,
    val Rank: Int,
    val Team: Team,
    val TotalMatches: Int,
    val Won: Int
)