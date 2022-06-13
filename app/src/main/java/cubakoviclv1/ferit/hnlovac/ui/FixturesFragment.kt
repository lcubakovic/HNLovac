package cubakoviclv1.ferit.hnlovac.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import cubakoviclv1.ferit.hnlovac.R
import cubakoviclv1.ferit.hnlovac.api.ApiInterface
import cubakoviclv1.ferit.hnlovac.api.ApiUtilites
import cubakoviclv1.ferit.hnlovac.api.Api_inf.API_KEY
import cubakoviclv1.ferit.hnlovac.api.Api_inf.SEASON_ID
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.annotations.NotNull
import retrofit2.create
import java.net.URL


class FixturesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_fixtures, container, false)
        return v
    }


}