package com.example.myhomebudgetkotlin.util

import android.content.Context
import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.myhomebudgetkotlin.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

val tabTitles = listOf(
    R.string.overview_name,
    R.string.accounts_name,
    R.string.bills_name)

val tabIcons = listOf(
    R.drawable.ic_overview,
    R.drawable.ic_accounts,
    R.drawable.ic_bills)

fun tabLayoutSetup(context: Context, tabLayout: TabLayout, viewPager2: ViewPager2) {
    setupTabLayoutMediator(context, tabLayout, viewPager2)
    setupTabSelection(context, tabLayout)
}

private fun setupTabLayoutMediator(
    context: Context,
    tabLayout: TabLayout,
    viewPager2: ViewPager2
) {
    TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
        tab.apply {
            icon = ContextCompat.getDrawable(context, tabIcons[position])
            text = context.getString(tabTitles[position])
            icon?.setTint(Color.WHITE)
        }
    }.attach()
}

private fun setupTabSelection(context: Context, tabLayout: TabLayout){
    tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) {
            tab.text = context.getString(tabTitles[tab.position])
        }

        override fun onTabUnselected(tab: TabLayout.Tab) {
            tab.text = ""
        }

        override fun onTabReselected(tab: TabLayout.Tab) {}
    })
}