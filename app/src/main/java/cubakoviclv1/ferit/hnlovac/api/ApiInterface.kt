package cubakoviclv1.ferit.hnlovac.api
import cubakoviclv1.ferit.hnlovac.model.StandingModel
import cubakoviclv1.ferit.hnlovac.model.TeamsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/api/v1/soccer/standings")
    suspend fun getStandings
            (@Query ("apikey") apiKey: String,
            @Query("season_id") season_id: String
            ): Response<StandingModel>

    @GET("/api/v1/soccer/teams")
    suspend fun getTeams
            (@Query ("apikey") apiKey: String,
             @Query("country_id") country_id: String
            ): Response<TeamsModel>
    }
