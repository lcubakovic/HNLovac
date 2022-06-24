package cubakoviclv1.ferit.hnlovac.matchesModel

import cubakoviclv1.ferit.hnlovac.matchesModel.CountryX

data class HomeTeam(
    val common_name: String,
    val country: CountryX,
    val logo: String,
    val name: String,
    val short_code: String,
    val team_id: Int
)