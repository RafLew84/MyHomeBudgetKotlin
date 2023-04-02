package com.example.myhomebudgetkotlin.ui.fragments.overview

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.myhomebudgetkotlin.R
import com.example.myhomebudgetkotlin.data.DataProvider
import com.example.myhomebudgetkotlin.databinding.FragmentOverviewBinding
import com.example.myhomebudgetkotlin.ui.fragments.accounts.AccountsAdapter
import com.example.myhomebudgetkotlin.ui.fragments.bills.BillsAdapter
import com.example.myhomebudgetkotlin.util.formatter

class OverviewFragment : Fragment() {

    private lateinit var binding: FragmentOverviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOverviewBinding.inflate(layoutInflater)

        setupAlertSection()
        setupAccountsSection()
        setupBillsSection()

        return binding.root
    }

    private fun setupBillsSection() {
        binding.apply {
            billsRecyclerView.apply {
                adapter = BillsAdapter()
                layoutManager = LinearLayoutManager(this.context)
            }

            billsButton.setOnClickListener {
                requireActivity().findViewById<ViewPager2>(R.id.viewPager)?.currentItem = 2
            }

            billsTotalAmountTextView.text = "${formatter.format(DataProvider.totalBillsAmount)} zł"
        }
    }

    private fun setupAccountsSection() {
        binding.apply {
            accountsRecyclerView.apply {
                adapter = AccountsAdapter()
                layoutManager = LinearLayoutManager(this.context)
            }

            accountsButton.setOnClickListener {
                requireActivity().findViewById<ViewPager2>(R.id.viewPager)?.currentItem = 1
            }

            accountTotalAmountTextView.text = "${formatter.format(DataProvider.totalAccountsAmount)} zł"
        }
    }

    private fun setupAlertSection() {
        binding.seeMoreButton.setOnClickListener {
                AlertDialog.Builder(context, R.style.MyDialogTheme)
                    .setTitle(getString(R.string.alerts)) // tytuł
                    .setView(layoutInflater.inflate(R.layout.alert_dialog, null)) // layout
                    .setPositiveButton("OK") { _, _ -> } // domyślna implementacja przycisku wyłączającego Dialog
                    .create() // utworzenie obiektu AlertDialog
                    .show() // wyświetlenie AlertDialog
        }
    }
}