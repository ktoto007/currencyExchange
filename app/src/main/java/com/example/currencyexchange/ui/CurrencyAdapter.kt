package com.example.currencyexchange.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyexchange.data.model.Currency
import com.example.currencyexchange.databinding.CurrencyItemBinding

class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    private var currencies: List<Currency> = emptyList()

    fun submitList(data: List<Currency>) {
        currencies = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val binding = CurrencyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrencyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(currencies[position])
    }

    override fun getItemCount(): Int = currencies.size

    class CurrencyViewHolder(private val binding: CurrencyItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currency: Currency) {
            binding.currencyName.text = currency.currency
            binding.currencyRate.text = currency.saleRate?.toString() ?: "N/A"
        }
    }
}