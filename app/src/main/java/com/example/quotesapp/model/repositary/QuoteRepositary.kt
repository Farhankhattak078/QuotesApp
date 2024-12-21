package com.example.quotesapp.model.repositary

import com.example.quotesapp.model.data.Quote
import kotlinx.coroutines.flow.Flow

interface QuoteRepositary {
    suspend fun getAllQuotes(): Flow<List<Quote>>
}