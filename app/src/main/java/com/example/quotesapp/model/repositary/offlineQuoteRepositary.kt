package com.example.quotesapp.model.repositary

import com.example.quotesapp.model.ApiServiceQuote
import com.example.quotesapp.model.data.Quote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class offlineQuoteRepositary(private val apiServiceQuote: ApiServiceQuote) : QuoteRepositary {
    override suspend fun getAllQuotes(): Flow<List<Quote>> {
        return flow {
            val quotefromapi=try {
                apiServiceQuote.getAllQuotes()
            } catch (e: Exception)
            {
                e.printStackTrace()
                return@flow
            }
            emit(quotefromapi.quotes)

        }
    }
}