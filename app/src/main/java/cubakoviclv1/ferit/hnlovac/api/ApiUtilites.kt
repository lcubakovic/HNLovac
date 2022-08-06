package cubakoviclv1.ferit.hnlovac.api
import com.squareup.okhttp.Interceptor
import com.squareup.okhttp.Response
import cubakoviclv1.ferit.hnlovac.api.Api_inf.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.coroutineContext

object ApiUtilites {


    fun getInstance(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

}