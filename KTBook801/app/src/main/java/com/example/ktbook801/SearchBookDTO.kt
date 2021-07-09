package com.example.ktbook801

import com.google.gson.annotations.SerializedName

data class SearchBookDTO (
    @SerializedName("title") val title: String,
    @SerializedName("item") val books: List<Book>
        )