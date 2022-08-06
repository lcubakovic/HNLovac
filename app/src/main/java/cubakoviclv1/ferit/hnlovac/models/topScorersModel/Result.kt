package cubakoviclv1.ferit.hnlovac.models.topScorersModel

data class Result(
    val bigChancesMissed: Int,
    val goalConversionPercentage: Double,
    val goals: Int,
    val player: Player,
    val rating: Double,
    val successfulDribbles: Int,
    val team: Team,
    val totalShots: Int
)