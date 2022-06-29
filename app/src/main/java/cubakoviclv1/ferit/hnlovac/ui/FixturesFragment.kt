package cubakoviclv1.ferit.hnlovac.ui

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.widget.*
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.protobuf.NullValue
import cubakoviclv1.ferit.hnlovac.R
import cubakoviclv1.ferit.hnlovac.adapters.MatchesAdapter
import cubakoviclv1.ferit.hnlovac.api.ApiInterface
import cubakoviclv1.ferit.hnlovac.api.ApiUtilites
import cubakoviclv1.ferit.hnlovac.api.Api_inf
import cubakoviclv1.ferit.hnlovac.databinding.FragmentFixturesBinding
import cubakoviclv1.ferit.hnlovac.matchesModel.Data
import cubakoviclv1.ferit.hnlovac.matchesModel.Round
import kotlinx.android.synthetic.main.fragment_fixtures.*
import kotlinx.android.synthetic.main.fragment_fixtures.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.ArrayList


class FixturesFragment : Fragment() {
    private lateinit var recyclerView_fixtures: RecyclerView
    private lateinit var binding: FragmentFixturesBinding
    private lateinit var adapter: MatchesAdapter
    private lateinit var matchesList: List<Data>

//    private lateinit var spinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFixturesBinding.inflate(inflater, container, false)

        recyclerView_fixtures = binding.root.findViewById(R.id.recyclerView_fixtures)
        recyclerView_fixtures.setHasFixedSize(true)
        matchesList = mutableListOf()
        adapter = MatchesAdapter(requireContext(), matchesList)
//        spinner = binding.root.findViewById(R.id.spinner_kola)

        val standingsApi = ApiUtilites.getInstance().create(ApiInterface::class.java)

        fun getData(){
            lifecycleScope.launch(Dispatchers.IO) {

                val matches = standingsApi.getMatches(
                        Api_inf.API_KEY,
                        Api_inf.SEASON_ID,
                        Api_inf.DATE_FROM
                )

                if (matches.body() != null) {
                    Log.d("matches", "onCreate: ${matches.body()!!.data}")

                    withContext(Dispatchers.Main) {
                        binding.recyclerViewFixtures.adapter = MatchesAdapter(
                                requireActivity(),
                                matches.body()!!.data
                        )
                    }
                }
            }
        }

       recyclerView_fixtures.adapter = adapter
       recyclerView_fixtures.layoutManager = LinearLayoutManager(requireContext())

//        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                if(position == 0) {
//                    getData()
//                }
//                else if(position == 1) {
//                    getData()
//                }
//
//            }
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//            }
//        }

        getData()

        return binding.root
    }


}