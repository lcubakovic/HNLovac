package cubakoviclv1.ferit.hnlovac.api
import cubakoviclv1.ferit.hnlovac.models.incidentModel.incidentModel
import cubakoviclv1.ferit.hnlovac.models.liveModel.liveModel
import cubakoviclv1.ferit.hnlovac.models.matchesModel.finishedRounds.finishedRounds
import cubakoviclv1.ferit.hnlovac.models.matchesModel.nextRounds.nextRounds
import cubakoviclv1.ferit.hnlovac.models.standingsModel.standigsModel
import cubakoviclv1.ferit.hnlovac.models.topScorersModel.playerStatisticsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/statistics?limit=20&order=-goals&accumulation=total&group=attack")
    suspend fun getPlayerStatistics
            (): Response<playerStatisticsModel>

    @GET("https://gnkdinamo.hr/api/Competition/Table?CompId=85")
    suspend fun getStandings
                (): Response<standigsModel>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/next/0")
    suspend fun getMatches4_9
                (): Response<nextRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/next/1")
    suspend fun getMatches10_16
            (): Response<nextRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/next/2")
    suspend fun getMatches16_22
            (): Response<nextRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/next/3")
    suspend fun getMatches22_28
            (): Response<nextRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/next/4")
    suspend fun getMatches28_34
            (): Response<nextRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/next/5")
    suspend fun getMatches34_36
            (): Response<nextRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/1")
    suspend fun getRound1
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/2")
    suspend fun getRound2
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/3")
    suspend fun getRound3
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/4")
    suspend fun getRound4
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/5")
    suspend fun getRound5
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/6")
    suspend fun getRound6
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/7")
    suspend fun getRound7
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/8")
    suspend fun getRound8
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/9")
    suspend fun getRound9
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/10")
    suspend fun getRound10
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/11")
    suspend fun getRound11
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/12")
    suspend fun getRound12
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/13")
    suspend fun getRound13
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/14")
    suspend fun getRound14
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/15")
    suspend fun getRound15
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/16")
    suspend fun getRound16
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/17")
    suspend fun getRound17
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/18")
    suspend fun getRound18
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/19")
    suspend fun getRound19
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/20")
    suspend fun getRound20
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/21")
    suspend fun getRound21
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/22")
    suspend fun getRound22
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/23")
    suspend fun getRound23
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/24")
    suspend fun getRound24
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/25")
    suspend fun getRound25
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/26")
    suspend fun getRound26
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/27")
    suspend fun getRound27
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/28")
    suspend fun getRound28
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/29")
    suspend fun getRound29
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/30")
    suspend fun getRound30
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/31")
    suspend fun getRound31
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/32")
    suspend fun getRound32
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/33")
    suspend fun getRound33
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/34")
    suspend fun getRound34
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/35")
    suspend fun getRound35
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/unique-tournament/170/season/42138/events/round/36")
    suspend fun getRound36
            (): Response<finishedRounds>

    @GET("https://api.sofascore.com/api/v1/sport/football/events/live")
    suspend fun getLiveEvents
            (): Response<liveModel>
    }
