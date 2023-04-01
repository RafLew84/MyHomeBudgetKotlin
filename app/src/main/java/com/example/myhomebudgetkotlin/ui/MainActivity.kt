package com.example.myhomebudgetkotlin.ui

import android.app.Activity
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.myhomebudgetkotlin.databinding.ActivityMainBinding
import com.example.myhomebudgetkotlin.ui.adapters.FinanceAdapter
import com.example.myhomebudgetkotlin.util.tabIcons
import com.example.myhomebudgetkotlin.util.tabLayoutSetup
import com.example.myhomebudgetkotlin.util.tabTitles
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.viewPager.adapter = FinanceAdapter(this)

        tabLayoutSetup(this, binding.tabLayout, binding.viewPager)
    }

}