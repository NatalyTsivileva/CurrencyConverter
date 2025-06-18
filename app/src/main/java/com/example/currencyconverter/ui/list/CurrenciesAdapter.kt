package com.example.currencyconverter.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.currencyconverter.databinding.CurrencyItemLayoutBinding
import com.example.currencyconverter.ui.data.Currency

class CurrenciesAdapter(
    private val listener: CurrenciesClickListener
) : ListAdapter<Currency, CurrenciesAdapter.CurrenciesViewHolder>(diffUtil) {

    class CurrenciesViewHolder(
        binding: CurrencyItemLayoutBinding,
        private val listener: CurrenciesClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {

        private val bindingItem: CurrencyItemLayoutBinding = binding

        fun bind(currency: Currency) {
            Glide.with(bindingItem.flagImage.context)
                .load(currency.flag)
                .centerCrop()
                .into(bindingItem.flagImage);

            bindingItem.currencyNameText.text = currency.name
            bindingItem.currencySignText.text = currency.sign
            bindingItem.currencyAbbreviationText.text = currency.abbreviation

            bindingItem.root.setOnClickListener { listener.onCurrencyCardClickListener(currency) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrenciesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CurrencyItemLayoutBinding.inflate(inflater, parent, false)
        return CurrenciesViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: CurrenciesViewHolder, position: Int) {
        val currency = getItem(position)
        holder.bind(currency)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Currency>() {
            override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean {
                return oldItem.abbreviation == newItem.abbreviation
            }

            override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean {
                return oldItem == newItem
            }

        }
    }

}