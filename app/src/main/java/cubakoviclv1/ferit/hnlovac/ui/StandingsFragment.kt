package cubakoviclv1.ferit.hnlovac.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import cubakoviclv1.ferit.hnlovac.R
import cubakoviclv1.ferit.hnlovac.api.ApiInterface
import cubakoviclv1.ferit.hnlovac.api.ApiUtilites
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.recyclerview.widget.RecyclerView
import cubakoviclv1.ferit.hnlovac.StandingsAdapter
import cubakoviclv1.ferit.hnlovac.databinding.FragmentStandingsBinding
import cubakoviclv1.ferit.hnlovac.models.standingsModel.Item



class StandingsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentStandingsBinding
    private lateinit var adapter: StandingsAdapter
    private lateinit var standingList: List<Item>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentStandingsBinding.inflate(inflater, container, false)
        recyclerView = binding.root.findViewById(R.id.recyclerView)
        standingList = mutableListOf()
        adapter = StandingsAdapter(requireContext(), standingList)

        val standingsApi = ApiUtilites.getInstance().create(ApiInterface::class.java)

        recyclerView.adapter =adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        lifecycleScope.launch (Dispatchers.IO) {

            val result = standingsApi.getStandings()

            if (result.body() != null) {
                Log.d("stand", "onCreate: ${result.body()!!.Items}" )

                withContext(Dispatchers.Main) {
                    binding.recyclerView.adapter = StandingsAdapter(requireActivity(), result.body()!!.Items)
                }
            }
        }

        return binding.root
    }

}