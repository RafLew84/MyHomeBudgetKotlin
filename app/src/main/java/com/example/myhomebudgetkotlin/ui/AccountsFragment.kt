package com.example.myhomebudgetkotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myhomebudgetkotlin.R
import com.example.myhomebudgetkotlin.databinding.FragmentAccountsBinding

class AccountsFragment : Fragment() {

    private lateinit var binding: FragmentAccountsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountsBinding.inflate(inflater)
        return binding.root
    }
}