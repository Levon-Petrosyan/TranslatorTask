package com.levonlight.translatortask.data

import com.google.gson.annotations.SerializedName

data class TranslateResponseItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("meanings")
    val meanings: List<Meaning>,
    @SerializedName("text")
    val text: String
)