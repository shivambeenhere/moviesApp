package com.example.movieapp.models

data class movies(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)