package com.example.myhomebudgetkotlin.util

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
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

private const val tabScaleLow = 0.7f
private const val tabScaleHigh = 1f

fun tabLayoutSetup(context: Context, tabLayout: TabLayout, viewPager2: ViewPager2) {
    setupTabLayoutMediator(context, tabLayout, viewPager2)
    initialTabsSetup(tabLayout)
    setupTabSelection(context, tabLayout)
}

private fun setupTabLayoutMediator(context: Context, tabLayout: TabLayout, viewPager2: ViewPager2) {
    TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
        tab.icon = ContextCompat.getDrawable(context, tabIcons[position])
        if (position == 0) tab.apply {
            text = context.getString(tabTitles[position])
            icon?.setTint(Color.WHITE)
        }
    }.attach()
}

private fun initialTabsSetup(tabLayout: TabLayout){
    val viewGroup = tabLayout.getChildAt(0) as ViewGroup
    for (i in 0 until viewGroup.childCount) {
        if (i == tabLayout.selectedTabPosition) continue
        val child = viewGroup.getChildAt(i)
        child.scaleX = tabScaleLow
        child.scaleY = tabScaleLow
    }
}

private fun setupTabSelection(context: Context, tabLayout: TabLayout){
    val viewGroup = tabLayout.getChildAt(0) as ViewGroup
    tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) {
            tab.apply {
                text = context.getString(tabTitles[tab.position])
                icon?.setTint(Color.WHITE)
            }

            val currentChild = viewGroup.getChildAt(tab.position)
            val duration = context.resources.getInteger(android.R.integer.config_mediumAnimTime).toLong()
            setupAnimation(currentChild, tabScaleHigh, duration)
        }

        override fun onTabUnselected(tab: TabLayout.Tab) {
            tab.text = ""
            val currentChild = viewGroup.getChildAt(tab.position)
            val duration = 1L
            setupAnimation(currentChild, tabScaleLow, duration)
        }

        override fun onTabReselected(tab: TabLayout.Tab) {}
    })
}

private fun setupAnimation(view: View, scale: Float, duration: Long){
    view.animate()
        .scaleX(scale)
        .scaleY(scale)
        .setInterpolator(FastOutSlowInInterpolator())
        .setDuration(duration)
        .start()
}