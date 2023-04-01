package com.example.myhomebudgetkotlin.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myhomebudgetkotlin.ui.fragments.AccountsFragment
import com.example.myhomebudgetkotlin.ui.fragments.BillsFragment
import com.example.myhomebudgetkotlin.ui.fragments.OverviewFragment

class FinanceAdapter(fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity) {
    private val fragments = listOf(
        OverviewFragment(),
        AccountsFragment(),
        BillsFragment()
    )
    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position]
}