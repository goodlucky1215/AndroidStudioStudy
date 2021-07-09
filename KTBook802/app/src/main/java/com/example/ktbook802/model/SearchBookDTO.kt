package com.example.ktbook802

import com.example.ktbook802.model.Book
import com.google.gson.annotations.SerializedName

data class SearchBookDTO (
    @SerializedName("title") val title: String,
    @SerializedName("item") val books: List<Book>
        )