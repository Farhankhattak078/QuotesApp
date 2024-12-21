package com.example.quotesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesapp.model.data.Quote
import com.example.quotesapp.model.data.Quotes
import com.example.quotesapp.model.repositary.QuoteRepositary
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class QuotesViewModel(private val repositary: QuoteRepositary): ViewModel() {

    private val _state = MutableStateFlow(Quotes())
    val state = _state.asStateFlow()


    init {
        getallquotes()
    }

    fun getallquotes()
    {
        viewModelScope.launch{
            repositary.getAllQuotes().collect{
                    quote->_state.update {
                    currentstate->currentstate.copy(quotes = quote)
            }
            }
        }
    }



        fun toggleFavorite(quote: Quote) {
            _state.update { currentState ->
                val updatedFavorites = if (quote in currentState.favorites) {
                    currentState.favorites - quote
                } else {
                    currentState.favorites + quote
                }
                currentState.copy(favorites = updatedFavorites)
            }
        }
    }







