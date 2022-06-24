package cubakoviclv1.ferit.hnlovac.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cubakoviclv1.ferit.hnlovac.R
import cubakoviclv1.ferit.hnlovac.adapters.LiveAdapter
import cubakoviclv1.ferit.hnlovac.api.ApiInterface
import cubakoviclv1.ferit.hnlovac.api.ApiUtilites
import cubakoviclv1.ferit.hnlovac.databinding.FragmentLiveBinding
import cubakoviclv1.ferit.hnlovac.liveEventsModel.hnl22_23.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LiveFragment : Fragment() {
    private lateinit var recyclerView_live: RecyclerView
    private lateinit var binding: FragmentLiveBinding
    private lateinit var adapter: LiveAdapter
    private lateinit var liveMatchesList: List<Event>

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLiveBinding.inflate(inflater, container, false)
        recyclerView_live = binding.root.findViewById(R.id.recyclerView_live)
        liveMatchesList = mutableListOf()
        adapter = LiveAdapter(requireContext(), liveMatchesList)

        val liveApi = ApiUtilites.getInstance().create(ApiInterface::class.java)

        recyclerView_live.adapter = adapter
        recyclerView_live.layoutManager = LinearLayoutManager(requireContext())


        lifecycleScope.launch (Dispatchers.IO) {

            val matches = liveApi.getLiveEvents()

            if (matches.body() != null) {
                Log.d("matches", "onCreate: ${matches.body()!!.events}" )

                withContext(Dispatchers.Main) {
                    binding.recyclerViewLive.adapter = LiveAdapter(requireActivity(),matches.body()!!.events )
                }
            }
        }

        return binding.root
    }


}