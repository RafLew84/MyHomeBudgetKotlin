package com.example.myhomebudgetkotlin.ui.fragments.accounts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myhomebudgetkotlin.data.DataProvider
import com.example.myhomebudgetkotlin.databinding.RecyclerItemViewBinding

class AccountsAdapter : RecyclerView.Adapter<AccountsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountsViewHolder {
        return AccountsViewHolder(RecyclerItemViewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: AccountsViewHolder, position: Int) {
        val item = DataProvider.accounts[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = DataProvider.accounts.size
}