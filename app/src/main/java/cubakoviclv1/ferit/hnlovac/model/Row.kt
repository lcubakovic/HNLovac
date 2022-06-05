package cubakoviclv1.ferit.hnlovac.model

data class Row(
    val descriptions: List<Any>,
    val draws: Int,
    val id: Int,
    val losses: Int,
    val matches: Int,
    val points: Int,
    val position: Int,
    val promotion: Promotion,
    val scoresAgainst: Int,
    val scoresFor: Int,
    val team: Team,
    val wins: Int
)