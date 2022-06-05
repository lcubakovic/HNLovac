package cubakoviclv1.ferit.hnlovac.model

data class Standing(
    val descriptions: List<Any>,
    val id: Int,
    val name: String,
    val rows: List<Row>,
    val tieBreakingRule: TieBreakingRule,
    val tournament: Tournament,
    val type: String,
    val updatedAtTimestamp: Int
)