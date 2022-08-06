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
import cubakoviclv1.ferit.hnlovac.models.matchesModel.nextRounds.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class FinishedMatchesFragment : Fragment(){
    private lateinit var recyclerView_fixtures: RecyclerView
    private lateinit var binding: FragmentFixturesBinding
    private lateinit var adapter: FinishedRoundsAdapter
    private lateinit var finishedMatchesList: List<cubakoviclv1.ferit.hnlovac.models.matchesModel.finishedRounds.Event>
    private lateinit var spinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFixturesBinding.inflate(inflater, container, false)

        recyclerView_fixtures = binding.root.findViewById(R.id.recyclerView_fixtures)
        recyclerView_fixtures.setHasFixedSize(true)

        finishedMatchesList = mutableListOf()
        adapter = FinishedRoundsAdapter(requireContext(), finishedMatchesList)

        spinner = binding.root.findViewById(R.id.spinner_kola)


        val matchesApi = ApiUtilites.getInstance().create(ApiInterface::class.java)

        fun getData1(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound1(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
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
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
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
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData4(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound4(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }


        fun getData5(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound5(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData6(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound6(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData7(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound7(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData8(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound8(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData9(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound9(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData10(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound10(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

                fun getData11(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound11(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData12(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound12(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData13(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound13(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData14(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound14(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData15(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound15(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData16(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound16(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData17(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound17(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData18(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound18(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData19(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound19(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData20(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound20(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData21(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound21(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData22(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound22(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData23(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound23(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData24(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound24(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData25(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound25(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData26(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound26(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData27(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound27(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData28(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound28(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData29(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound29(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData30(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound30(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData31(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound31(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData32(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound32(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData33(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound33(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData34(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound34(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData35(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound35(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }

        fun getData36(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = matchesApi.getRound36(
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.events}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = FinishedRoundsAdapter(
                                requireActivity(),
                                matches.body()!!.events
                        )
                    }
                }
            }
        }


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
                    getData5()
                }
                else if(position == 5) {
                    getData6()
                }
                else if(position == 6) {
                    getData7()
                }
                else if(position == 7) {
                    getData8()
                }
                else if(position == 8) {
                    getData9()
                }
                else if(position == 9) {
                    getData10()
                }
                else if(position == 10) {
                    getData11()
                }
                else if(position == 11) {
                    getData12()
                }
                else if(position == 12) {
                    getData13()
                }
                else if(position == 13) {
                    getData14()
                }
                else if(position == 14) {
                    getData15()
                }
                else if(position == 15) {
                    getData16()
                }
                else if(position == 16) {
                    getData17()
                }
                else if(position == 17) {
                    getData18()
                }
                else if(position == 18) {
                    getData19()
                }
                else if(position == 19) {
                    getData20()
                }
                else if(position == 20) {
                    getData21()
                }
                else if(position == 21) {
                    getData22()
                }
                else if(position == 22) {
                    getData23()
                }
                else if(position == 23) {
                    getData24()
                }
                else if(position == 24) {
                    getData25()
                }
                else if(position == 25) {
                    getData26()
                }
                else if(position == 26) {
                    getData27()
                }
                else if(position == 27) {
                    getData28()
                }
                else if(position == 28) {
                    getData29()
                }
                else if(position == 29) {
                    getData30()
                }
                else if(position == 30) {
                    getData31()
                }
                else if(position == 31) {
                    getData32()
                }
                else if(position == 32) {
                    getData33()
                }
                else if(position == 33) {
                    getData34()
                }
                else if(position == 34) {
                    getData35()
                }
                else if(position == 35) {
                    getData36()
                }



            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }


        return binding.root
    }


}