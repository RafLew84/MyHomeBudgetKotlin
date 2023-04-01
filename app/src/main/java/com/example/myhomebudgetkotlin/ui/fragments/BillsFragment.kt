package com.example.myhomebudgetkotlin.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myhomebudgetkotlin.R
import com.example.myhomebudgetkotlin.databinding.FragmentBillsBinding

class BillsFragment : Fragment() {

    private lateinit var binding: FragmentBillsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBillsBinding.inflate(layoutInflater)
        return binding.root
    }
}