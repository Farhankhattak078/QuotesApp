package com.example.quotesapp.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object QuoteapiInstance {
    val quoteapi= Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BaseUrl.baseurl)
        .build()
        .create(ApiServiceQuote::class.java)
}