package cubakoviclv1.ferit.hnlovac.ui

import FavouriteAdapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cubakoviclv1.ferit.hnlovac.R
import cubakoviclv1.ferit.hnlovac.databinding.FragmentChatBinding

class ChatActivity: Fragment()  {

    private lateinit var binding: FragmentChatBinding


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentChatBinding.inflate(layoutInflater)

        return binding.root
    }

}