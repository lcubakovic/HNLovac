package cubakoviclv1.ferit.hnlovac.ui

import FavouriteAdapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cubakoviclv1.ferit.hnlovac.R
import cubakoviclv1.ferit.hnlovac.databinding.FragmentActivityBinding

class ActivityFragment: Fragment()  {

    private lateinit var binding: FragmentActivityBinding
    private lateinit var teamList : ArrayList<cubakoviclv1.ferit.hnlovac.data.Team>


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentActivityBinding.inflate(layoutInflater)

        val image = intArrayOf(
                R.drawable.dinamo, R.drawable.osijek, R.drawable.hajduk,
                R.drawable.rijeka, R.drawable.lokomotiva, R.drawable.gorica,
                R.drawable.slaven, R.drawable.istra, R.drawable.sibenik,
                R.drawable.dragovoljac
        )

        val name = arrayOf(
                "GNK Dinamo Zagreb", "NK Osijek", "HNK Hajduk Split",
                "HNK Rijeka", "NK Lokomotiva", "NK Gorica",
                "NK Slaven Belupo", "NK Istra 1961", "HNK Šibenik",
                "NK Hrvatski Dragovoljac"
        )

        teamList = ArrayList()

        for(i in name.indices) {
            val teamName = cubakoviclv1.ferit.hnlovac.data.Team(name[i], image[i])
            teamList.add(teamName)
        }

        binding.listView.isClickable = true
        binding.listView.adapter = FavouriteAdapter(requireActivity(), teamList)
        binding.listView.setOnItemClickListener { parent, view, position, id ->

            val name = name[position]
            val image = image[position]

            val i = Intent(requireContext(), FavouriteActivity::class.java)
            i.putExtra("name", name)
            i.putExtra("image", image)
            startActivity(i)
        }

        return binding.root
    }

}