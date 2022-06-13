package cubakoviclv1.ferit.hnlovac.ui

import android.os.Bundle
import android.util.Log
import android.util.StateSet
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import cubakoviclv1.ferit.hnlovac.R
import cubakoviclv1.ferit.hnlovac.api.ApiInterface
import cubakoviclv1.ferit.hnlovac.api.ApiUtilites
import cubakoviclv1.ferit.hnlovac.api.Api_inf
import cubakoviclv1.ferit.hnlovac.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.dsl.genericFastAdapter
import cubakoviclv1.ferit.hnlovac.StandingsAdapter
import cubakoviclv1.ferit.hnlovac.databinding.FragmentStandingsBinding
import cubakoviclv1.ferit.hnlovac.model.DataX
import cubakoviclv1.ferit.hnlovac.model.Standing
import kotlinx.coroutines.channels.consumesAll
import java.util.zip.Inflater


class StandingsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentStandingsBinding
    private lateinit var adapter: StandingsAdapter
    private lateinit var standingsList: List<Standing>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentStandingsBinding.inflate(inflater, container, false)
        recyclerView = binding.root.findViewById(R.id.recyclerView)
        standingsList = mutableListOf()
        adapter = StandingsAdapter(requireContext(), standingsList)

        val standingsApi = ApiUtilites.getInstance().create(ApiInterface::class.java)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        lifecycleScope.launch (Dispatchers.IO) {

            val result = standingsApi.getStandings(Api_inf.API_KEY, Api_inf.SEASON_ID)
            val teams = standingsApi.getTeams(Api_inf.API_KEY, Api_inf.COUNTRY_ID)

            if (result.body() != null) {
                Log.d("standings", "onCreate: ${result.body()!!.data.standings}" )

                withContext(Dispatchers.Main) {
                    binding.recyclerView.adapter = StandingsAdapter(requireActivity(),result.body()!!.data.standings )
                }
            }
        }

        return binding.root
    }

}