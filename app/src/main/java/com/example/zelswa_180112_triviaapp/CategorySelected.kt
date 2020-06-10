package com.example.zelswa_180112_triviaapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.zelswa_180112_triviaapp.databinding.FragmentCategorySelectedBinding


/**
 * A simple [Fragment] subclass.
 * Use the [CategorySelected.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategorySelected : Fragment() {

    private val viewModel: GameViewModel by activityViewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCategorySelectedBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_category_selected, container,false)
        binding.submitButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_categorySelected_to_score)
            )

        //ScoreOnCategory
        viewModel.score.observe(viewLifecycleOwner, Observer { newScore ->
            binding.scoreOnCategory.text = "Score: $newScore"
        })

        viewModel.question.observe(viewLifecycleOwner, Observer { newQuestion ->
            binding.question.text = newQuestion.question
            val rGroup = binding.radioGroup
            rGroup.removeAllViews()

            // for loop
            for ((index, answer) in newQuestion.answers.withIndex()){
                val newRadioBtn = createRadioButton(answer, index)
                rGroup.addView((newRadioBtn))
            }
        })

        binding.submitButton.setOnClickListener{ view : View ->
            val id = binding.radioGroup.checkedRadioButtonId
            viewModel.checkQuestion(id)
            Toast.makeText(context, "This is the correct iD: ${viewModel.currentQuestion.value}", Toast.LENGTH_SHORT).show()
            if(viewModel.currentQuestion.value!! < viewModel.amountOfQuestions.value!!-1){
                viewModel.updateQuestion(viewModel.currentQuestion.value ?: 0)
            } else {
                if(viewModel.score.value!! == viewModel.amountOfQuestions.value!!){
                    view.findNavController().navigate(R.id.action_categorySelected_to_score)
                } else {
                    view.findNavController().navigate(R.id.action_categorySelected_to_scoreIfLost)
                }
            }
        }
        return binding.root
    }
    private fun createRadioButton(answer: String, id: Int): RadioButton{
        val radioBtn = RadioButton(context)
        radioBtn.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        radioBtn.text = answer
        radioBtn.id = id
        return radioBtn
    }
}
