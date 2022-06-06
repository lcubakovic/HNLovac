package cubakoviclv1.ferit.hnlovac.model

data class Data(
    val has_groups: Int,
    val league_id: Int,
    val season_id: Int,
    val standings: List<Standing>
)