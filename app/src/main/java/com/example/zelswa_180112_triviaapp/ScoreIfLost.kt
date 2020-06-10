package com.example.zelswa_180112_triviaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.zelswa_180112_triviaapp.databinding.FragmentScoreBinding
import com.example.zelswa_180112_triviaapp.databinding.FragmentScoreIfLostBinding

/**
 * A simple [Fragment] subclass.
 */
class ScoreIfLost : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentScoreIfLostBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_score_if_lost, container,false)
        binding.button.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_scoreIfLost_to_homePage)
        )
        return binding.root
    }

}