package com.example.myhomebudgetkotlin.ui.fragments.accounts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myhomebudgetkotlin.databinding.FragmentDetailInfoBinding

class AccountsFragment : Fragment() {

    private lateinit var binding: FragmentDetailInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailInfoBinding.inflate(inflater)

        binding.recyclerView.apply {
            adapter = AccountsAdapter()
            layoutManager = LinearLayoutManager(this@AccountsFragment.requireContext())
        }

        return binding.root
    }
}