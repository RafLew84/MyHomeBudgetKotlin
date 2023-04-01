package com.example.myhomebudgetkotlin.ui.fragments.bills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myhomebudgetkotlin.databinding.FragmentDetailInfoBinding

class BillsFragment : Fragment() {

    private lateinit var binding: FragmentDetailInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailInfoBinding.inflate(layoutInflater)
        return binding.root
    }
}