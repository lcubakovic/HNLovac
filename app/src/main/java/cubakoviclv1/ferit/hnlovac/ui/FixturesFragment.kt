package cubakoviclv1.ferit.hnlovac.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cubakoviclv1.ferit.hnlovac.R
import java.net.URL


class FixturesFragment : Fragment() {

    private var url: String = "https://api.sofascore.com/api/v1/unique-tournament/170/season/37053/standings/total"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fixtures, container, false)
    }

}