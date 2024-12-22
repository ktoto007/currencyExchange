package com.example.currencyexchange.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyexchange.data.model.Currency
import com.example.currencyexchange.data.network.CurrencyApi
import kotlinx.coroutines.launch

class CurrencyViewModel : ViewModel() {

    private val _selectedDate = MutableLiveData<String?>()
    val selectedDate: LiveData<String?> get() = _selectedDate

    private val _currencies = MutableLiveData<List<Currency>>()
    val currencies: LiveData<List<Currency>> get() = _currencies

    fun setDate(date: String) {
        _selectedDate.value = date
        fetchCurrencies(date)
    }

    private fun fetchCurrencies(date: String) {
        viewModelScope.launch {
            try {
                val response = CurrencyApi.retrofitService.getExchangeRates(date)
                _currencies.value = response.exchangeRate
            } catch (e: Exception) {
                _currencies.value = emptyList()
            }
        }
    }
}