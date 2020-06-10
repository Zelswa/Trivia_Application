package com.example.zelswa_180112_triviaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zelswa_180112_triviaapp.databinding.FragmentHomePageBinding

class HomePage : Fragment(), OnOptionItemClickListener {

    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentHomePageBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page, container,false)
        binding.OptionList.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homePage_to_categorySelected)
        )
        val categoryList = generateDummyList(3)
        binding.OptionList.adapter = OptionAdapter(categoryList, this)
        binding.OptionList.layoutManager = LinearLayoutManager(context)
        binding.OptionList.setHasFixedSize(true)
        return binding.root
    }

    private fun generateDummyList(size: Int): List<OptionItem> {
        val list = ArrayList<OptionItem>()
        for (i in 1 until size){
            val item = OptionItem (i,"Category $i")
            list += item
        }
        return list
    }

    override fun onOptionClick(category: OptionItem, position: Int, view: View) {
        Toast.makeText(context, "This category text: ${category.text} category ID: ${category.id}", Toast.LENGTH_SHORT).show()
        viewModel.setupGame(category.id)
        view.findNavController().navigate(R.id.action_homePage_to_categorySelected)
    }
}
