package com.example.myhomebudgetkotlin.ui.fragments.bills

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

class BillsFragment : Fragment() {

    private lateinit var binding: FragmentDetailInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailInfoBinding.inflate(layoutInflater)

        setupRecyclerView()
        setupDonutChart()
        setupTextViews()

        return binding.root
    }

    private fun setupTextViews() {
        binding.totalAmountTextView.text =
            "${formatter.format(DataProvider.totalBillsAmount)} zł"
    }

    private fun setupDonutChart() {
        binding.donutViewAccount.apply {
            val values = (0 until DataProvider.bills.size).map {
                DonutSection(
                    DataProvider.bills[it].name,
                    DataProvider.bills[it].color,
                    DataProvider.bills[it].amount.toFloat() /
                            DataProvider.totalBillsAmount.toFloat()
                )
            }
            submitData(values)
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            adapter = BillsAdapter()
            layoutManager = LinearLayoutManager(this@BillsFragment.requireContext())
        }
    }
}