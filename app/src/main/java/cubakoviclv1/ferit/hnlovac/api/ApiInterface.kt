package cubakoviclv1.ferit.hnlovac.api
import cubakoviclv1.ferit.hnlovac.liveEventsModel.hnl22_23.date0
import cubakoviclv1.ferit.hnlovac.matchesModel.matchesModel
import cubakoviclv1.ferit.hnlovac.standingsModel.StandingModel
import cubakoviclv1.ferit.hnlovac.standingsModel.TeamsModel
import cubakoviclv1.ferit.hnlovac.topScorersModel.scorersModel
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

    @GET("/api/v1/soccer/topscorers")
    suspend fun getScorers
            (@Query ("apikey") apiKey: String,
             @Query("season_id") season_id: String
            ): Response<scorersModel>

    @GET("/api/v1/soccer/matches")
    suspend fun getMatches
            (@Query ("apikey") apiKey: String,
             @Query("season_id") season_id: String,
             @Query("date_from") date_from: String
            ): Response<matchesModel>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/next/0")
    suspend fun getLiveEvents
                (
    ): Response<date0>

    }
