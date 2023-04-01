package com.example.myhomebudgetkotlin.ui.fragments.accounts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import app.futured.donut.DonutSection
import com.example.myhomebudgetkotlin.data.DataProvider
import com.example.myhomebudgetkotlin.databinding.FragmentDetailInfoBinding
import com.example.myhomebudgetkotlin.util.formatter

class AccountsFragment : Fragment() {

    private lateinit var binding: FragmentDetailInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailInfoBinding.inflate(inflater)

        setupRecyclerView()
        setupDonutChart()
        setupTextViews()

        return binding.root
    }

    private fun setupTextViews() {
        binding.totalAmountTextView.text =
            "${formatter.format(DataProvider.totalAccountsAmount)} zł"
    }

    private fun setupDonutChart() {
        binding.donutViewAccount.apply {
            val values = (0 until DataProvider.accounts.size).map {
                DonutSection(
                    DataProvider.accounts[it].name,
                    DataProvider.accounts[it].color,
                    DataProvider.accounts[it].amount.toFloat() /
                            DataProvider.totalAccountsAmount.toFloat()
                )
            }
            submitData(values)
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            adapter = AccountsAdapter()
            layoutManager = LinearLayoutManager(this@AccountsFragment.requireContext())
        }
    }
}