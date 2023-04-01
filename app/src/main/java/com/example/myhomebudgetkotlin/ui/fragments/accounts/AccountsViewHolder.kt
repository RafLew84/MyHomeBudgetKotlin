package com.example.myhomebudgetkotlin.ui.fragments.accounts

import androidx.recyclerview.widget.RecyclerView
import com.example.myhomebudgetkotlin.data.model.Account
import com.example.myhomebudgetkotlin.databinding.RecyclerItemViewBinding
import com.example.myhomebudgetkotlin.util.formatter

class AccountsViewHolder (private val binding: RecyclerItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Account){
        binding.apply {
            RVNameTextView.text = item.name
            RVNumberTextView.text = item.number.replaceRange(0 until 6, "******")
            RVValueTextView.text = "${formatter.format(item.amount)} zł"
            RVcolorBarView.setBackgroundColor(item.color)
        }
    }
}