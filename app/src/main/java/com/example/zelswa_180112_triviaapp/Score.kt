package com.example.zelswa_180112_triviaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.zelswa_180112_triviaapp.databinding.FragmentHomePageBinding
import com.example.zelswa_180112_triviaapp.databinding.FragmentScoreBinding

/**
 * A simple [Fragment] subclass.
 * Use the [Score.newInstance] factory method to
 * create an instance of this fragment.
 */
class Score : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentScoreBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_score, container,false)
        binding.button5.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_score_to_homePage)
        )
        return binding.root
    }

}
