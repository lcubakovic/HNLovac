package cubakoviclv1.ferit.hnlovac.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cubakoviclv1.ferit.hnlovac.R
import cubakoviclv1.ferit.hnlovac.TopScorersAdapter
import cubakoviclv1.ferit.hnlovac.api.ApiInterface
import cubakoviclv1.ferit.hnlovac.api.ApiUtilites
import cubakoviclv1.ferit.hnlovac.databinding.FragmentScorersBinding
import cubakoviclv1.ferit.hnlovac.models.topScorersModel.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TopScorersFragment: Fragment() {
    private lateinit var recyclerView_topScorers: RecyclerView
    private lateinit var binding: FragmentScorersBinding
    private lateinit var adapter: TopScorersAdapter
    private lateinit var scorersList: List<Result>

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScorersBinding.inflate(inflater, container, false)
        recyclerView_topScorers = binding.root.findViewById(R.id.recyclerView_topScorers)
        scorersList = mutableListOf()
        adapter = TopScorersAdapter(requireContext(), scorersList)

        val scorersApi = ApiUtilites.getInstance().create(ApiInterface::class.java)

        recyclerView_topScorers.adapter = adapter
        recyclerView_topScorers.layoutManager = LinearLayoutManager(requireContext())


        lifecycleScope.launch (Dispatchers.IO) {

            val scorers = scorersApi.getPlayerStatistics()

            if (scorers.body() != null) {
                Log.d("scorers", "onCreate: ${scorers.body()!!.results}" )

                withContext(Dispatchers.Main) {
                    binding.recyclerViewTopScorers.adapter = TopScorersAdapter(requireActivity(),scorers.body()!!.results)
                }
            }
        }

        return binding.root
    }


}
