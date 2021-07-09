package com.example.ktbook802.model

import com.google.gson.annotations.SerializedName

data class BestSellerDTO (
    @SerializedName("title") val title: String,
    @SerializedName("item") val books: List<Book> //"item"은 구조체 였으니까!
)