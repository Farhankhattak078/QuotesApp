package com.example.quotesapp.model

import com.example.quotesapp.model.data.Quotes
import retrofit2.http.GET

interface ApiServiceQuote {
    @GET("quotes")
    suspend fun getAllQuotes(): Quotes
}