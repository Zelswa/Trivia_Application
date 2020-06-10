package com.example.zelswa_180112_triviaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.option_item.view.*


class OptionAdapter(
    private val categoryList: List<OptionItem>,
    var mClickListener: OnOptionItemClickListener
) : RecyclerView.Adapter<OptionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.option_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.initializer(categoryList.get(position), mClickListener)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView : TextView = itemView.option_categories
        fun initializer(optionItem: OptionItem, action: OnOptionItemClickListener){
            textView.text = optionItem.text
            textView.setOnClickListener { view ->
                action.onOptionClick(optionItem, adapterPosition, view)
            }
        }
    }
}

interface OnOptionItemClickListener {
    fun onOptionClick(category: OptionItem, position: Int, view: View)
}