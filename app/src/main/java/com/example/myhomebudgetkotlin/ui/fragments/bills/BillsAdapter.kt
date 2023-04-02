package com.example.myhomebudgetkotlin.ui.fragments.bills

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myhomebudgetkotlin.data.DataProvider
import com.example.myhomebudgetkotlin.databinding.RecyclerItemViewBinding

class BillsAdapter : RecyclerView.Adapter<BillsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BillsViewHolder {
        return BillsViewHolder(RecyclerItemViewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: BillsViewHolder, position: Int) {
        val item = DataProvider.bills[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = DataProvider.bills.size
}