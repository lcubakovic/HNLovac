package cubakoviclv1.ferit.hnlovac.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.AdapterView
import android.widget.SearchView
import android.widget.Spinner
import androidx.core.view.contains
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cubakoviclv1.ferit.hnlovac.R
import cubakoviclv1.ferit.hnlovac.adapters.*
import cubakoviclv1.ferit.hnlovac.api.ApiInterface
import cubakoviclv1.ferit.hnlovac.api.ApiUtilites
import cubakoviclv1.ferit.hnlovac.databinding.FragmentFixturesBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class FinishedMatchesFragment : Fragment(){
    private lateinit var recyclerView_fixtures: RecyclerView
    private lateinit var binding: FragmentFixturesBinding
    private lateinit var adapter: Round1Adapter
    private lateinit var adapter2: Round2Adapter
    private lateinit var adapter3: Round3Adapter
    private lateinit var adapter4: Round4_9_Adapter
    private lateinit var adapter5: FinishedMatchesAdapter
    private lateinit var adapter10_16: Round10_16_Adapter
    private lateinit var adapter16_22: Round16_22_Adapter
    private lateinit var adapter22_28: Round22_28_Adapter
    private lateinit var adapter28_34: Round28_34_Adapter
    private lateinit var adapter34_36: Round34_36_Adapter
    private lateinit var matchesList: List<cubakoviclv1.ferit.hnlovac.models.matchesModel.round1.Event>
    private lateinit var matchesList2: List<cubakoviclv1.ferit.hnlovac.models.matchesModel.round2.Event>
    private lateinit var matchesList3: List<cubakoviclv1.ferit.hnlovac.models.matchesModel.round3.Event>
    private lateinit var matchesList4: List<cubakoviclv1.ferit.hnlovac.models.matchesModel.round4_9.Event>
    private lateinit var matchesList5: List<cubakoviclv1.ferit.hnlovac.models.matchesModel.round4_9.Event>
    private lateinit var matchesList10: List<cubakoviclv1.ferit.hnlovac.models.matchesModel.round10_16.Event>
    private lateinit var matchesList16: List<cubakoviclv1.ferit.hnlovac.models.matchesModel.round16_22.Event>
    private lateinit var matchesList22: List<cubakoviclv1.ferit.hnlovac.models.matchesModel.round22_28.Event>
    private lateinit var matchesList28: List<cubakoviclv1.ferit.hnlovac.models.matchesModel.round28_34.Event>
    private lateinit var matchesList34: List<cubakoviclv1.ferit.hnlovac.models.matchesModel.round34_36.Event>
    private lateinit var spinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFixturesBinding.inflate(inflater, container, false)

        recyclerView_fixtures = binding.root.findViewById(R.id.recyclerView_fixtures)
        recyclerView_fixtures.setHasFixedSize(true)
        matchesList = mutableListOf()
        adapter = Round1Adapter(requireContext(), matchesList)

        matchesList2 = mutableListOf()
        adapter2 = Round2Adapter(requireContext(), matchesList2)

        matchesList3 = mutableListOf()
        adapter3 = Round3Adapter(requireContext(), matchesList3)

        matchesList4 = mutableListOf()
        adapter4 = Round4_9_Adapter(requireContext(), matchesList4)

        matchesList5 = mutableListOf()
        adapter5 = FinishedMatchesAdapter(requireContext(), matchesList5)

        matchesList10 = mutableListOf()
        adapter10_16 = Round10_16_Adapter(requireContext(), matchesList10)

        matchesList16= mutableListOf()
        adapter16_22 = Round16_22_Adapter(requireContext(), matchesList16)

        matchesList22 = mutableListOf()
        adapter22_28 = Round22_28_Adapter(requireContext(), matchesList22)

        matchesList28 = mutableListOf()
        adapter28_34 = Round28_34_Adapter(requireContext(), matchesList28)

        matchesList34 = mutableListOf()
        adapter34_36 = Round34_36_Adapter(requireContext(), matchesList34)

        spinner = binding.root.findViewById(R.id.spinner_kola)


        val matchesApi = ApiUtilites.getInstance().create(ApiInterface::class.java)

        fun getData1(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound1(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = Round1Adapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData2(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound2(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = Round2Adapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData3(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound3(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = Round3Adapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData4_round(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getMatches4_9(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedMatchesAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData4(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getMatches4_9(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = Round4_9_Adapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData10(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getMatches10_16(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = Round10_16_Adapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData16(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getMatches16_22(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = Round16_22_Adapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData22(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getMatches22_28(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = Round22_28_Adapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData28(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getMatches28_34(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = Round28_34_Adapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData34(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getMatches34_36(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = Round34_36_Adapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }


        recyclerView_fixtures.adapter = adapter34_36
        recyclerView_fixtures.adapter = adapter28_34
        recyclerView_fixtures.adapter = adapter22_28
        recyclerView_fixtures.adapter = adapter16_22
        recyclerView_fixtures.adapter = adapter10_16
        recyclerView_fixtures.adapter = adapter5
        recyclerView_fixtures.adapter = adapter4
        recyclerView_fixtures.adapter = adapter3
        recyclerView_fixtures.adapter = adapter2
        recyclerView_fixtures.adapter = adapter
        recyclerView_fixtures.layoutManager = LinearLayoutManager(requireContext())

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(position == 0) {
                    getData1()
                    recyclerView_fixtures.visibility = View.VISIBLE
                }
                else if(position == 1) {
                    getData2()
                }
                else if(position == 2) {
                    getData3()
                }
                else if(position == 3) {
                    getData4()
                }
                else if(position == 4) {
                    getData10()
                }
                else if(position == 5) {
                    getData16()
                }
                else if(position == 6) {
                    getData22()
                }
                else if(position == 7) {
                    getData28()
                }
                else if(position == 8) {
                    getData34()
                } else if(position == 9) {
                    getData4_round()
                }

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }


        return binding.root
    }


}