package cubakoviclv1.ferit.hnlovac.standingsModel

data class Data(
    val has_groups: Int,
    val league_id: Int,
    val season_id: Int,
    val standings: List<Standing>
)