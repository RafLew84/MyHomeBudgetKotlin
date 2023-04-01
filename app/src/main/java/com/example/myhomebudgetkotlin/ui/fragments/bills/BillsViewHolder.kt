package com.example.myhomebudgetkotlin.ui.fragments.bills

import androidx.recyclerview.widget.RecyclerView
import com.example.myhomebudgetkotlin.data.model.Bill
import com.example.myhomebudgetkotlin.databinding.RecyclerItemViewBinding
import com.example.myhomebudgetkotlin.util.dateFormatter
import com.example.myhomebudgetkotlin.util.formatter

class BillsViewHolder (private val binding: RecyclerItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Bill){
        binding.apply {
            RVNameTextView.text = item.name
            RVNumberTextView.text = item.endDate.format(dateFormatter)
            RVValueTextView.text = "${formatter.format(item.amount)}zł"
            RVcolorBarView.setBackgroundColor(item.color)
        }
    }
}