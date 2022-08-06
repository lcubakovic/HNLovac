package cubakoviclv1.ferit.hnlovac.api
import cubakoviclv1.ferit.hnlovac.models.liveModel.liveModel
import cubakoviclv1.ferit.hnlovac.models.matchesModel.round1.round1
import cubakoviclv1.ferit.hnlovac.models.matchesModel.round10_16.round10_16
import cubakoviclv1.ferit.hnlovac.models.matchesModel.round16_22.round16_22
import cubakoviclv1.ferit.hnlovac.models.matchesModel.round2.round2
import cubakoviclv1.ferit.hnlovac.models.matchesModel.round22_28.round22_28
import cubakoviclv1.ferit.hnlovac.models.matchesModel.round28_34.round28_34
import cubakoviclv1.ferit.hnlovac.models.matchesModel.round3.round3
import cubakoviclv1.ferit.hnlovac.models.matchesModel.round34_36.round34_36
import cubakoviclv1.ferit.hnlovac.models.matchesModel.round4_9.round4_9
import cubakoviclv1.ferit.hnlovac.models.standingsModel.standigsModel
import cubakoviclv1.ferit.hnlovac.models.topScorersModel.playerStatisticsModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/statistics?limit=20&order=-goals&accumulation=total&group=attack")
    suspend fun getPlayerStatistics
            (): Response<playerStatisticsModel>

    @GET("https://gnkdinamo.hr/api/Competition/Table?CompId=85")
    suspend fun getStandings
                (): Response<standigsModel>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/next/0")
    suspend fun getMatches4_9
                (): Response<round4_9>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/next/1")
    suspend fun getMatches10_16
            (): Response<round10_16>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/next/2")
    suspend fun getMatches16_22
            (): Response<round16_22>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/next/3")
    suspend fun getMatches22_28
            (): Response<round22_28>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/next/4")
    suspend fun getMatches28_34
            (): Response<round28_34>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/next/5")
    suspend fun getMatches34_36
            (): Response<round34_36>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/1")
    suspend fun getRound1
            (): Response<round1>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/2")
    suspend fun getRound2
            (): Response<round2>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/3")
    suspend fun getRound3
            (): Response<round3>

    @GET("https://api.sofascore.com/api/v1/sport/football/events/live")
    suspend fun getLiveEvents
            (): Response<liveModel>


    }
