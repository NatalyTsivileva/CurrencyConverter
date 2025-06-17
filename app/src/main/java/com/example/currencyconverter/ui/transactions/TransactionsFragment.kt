package com.example.currencyconverter.ui.transactions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.currencyconverter.databinding.FragmentTransactionsBinding

class TransactionsFragment : Fragment() {

    private val viewModel: TransactionsViewModel by viewModels()
    private var binding: FragmentTransactionsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTransactionsBinding.inflate(inflater, container, false)
        return binding!!.root
    }
}