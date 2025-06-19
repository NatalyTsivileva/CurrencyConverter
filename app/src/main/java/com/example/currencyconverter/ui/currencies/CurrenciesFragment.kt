package com.example.currencyconverter.ui.currencies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyconverter.data.mapper.CurrencyMapper
import com.example.currencyconverter.databinding.FragmentCurrencyBinding
import com.example.currencyconverter.ui.data.Currency
import com.example.currencyconverter.ui.list.CurrenciesAdapter
import com.example.currencyconverter.ui.list.CurrenciesClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CurrenciesFragment : Fragment() {

    private val viewModel: CurrenciesViewModel by viewModels()

    private var binding: FragmentCurrencyBinding? = null

    private var listAdapter: CurrenciesAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrencyBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerAdapter()
        subscribeOnStatesFlow()
    }

    private fun subscribeOnStatesFlow(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.currencyStateFlow.collect { state ->
                    when (state) {
                        is Failed -> {
                            Log.d("ERROR!", state.message ?: "неизвестная ошибка")
                        }

                        Initial -> {/*nothing to do*/ }

                        is Success -> {
                            Log.d("SUCCESS!", state.data.joinToString())

                            listAdapter?.submitList(state.data)
                        }
                    }
                }
            }
        }
    }

    private fun setupRecyclerAdapter() {
        binding?.currenciesList?.let {
            listAdapter = CurrenciesAdapter(object : CurrenciesClickListener {
                override fun onCurrencyCardClickListener(currency: Currency) {
                    viewModel.onFromCurrencyChanged(currency.abbreviation)
                /*    val action = CurrenciesFragmentDirections
                        .actionCurrenciesFragmentToExchangeFragment(
                            *//*fromCurrency*//*listAdapter?.currentList?.firstOrNull(),
                            *//*toCurrency*//*currency
                        )*/
                   // findNavController().navigate(action)
                }

                override fun onAmountTextChanged(amount: Double) {
                    viewModel.onFromCurrencyAmountChanged(amount)
                    Log.d("onFromCurrencyChanged","CHANGED")
                }
            })
            it.adapter = listAdapter
            it.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        listAdapter = null
    }
}