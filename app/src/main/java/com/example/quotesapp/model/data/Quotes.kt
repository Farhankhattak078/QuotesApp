package com.example.quotesapp.model.data

data class Quotes(
    val quotes: List<Quote> = emptyList(),
    val favorites: List<Quote> = emptyList()


)