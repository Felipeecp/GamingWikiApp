package com.luiz.gamingwiki.data.model


import com.google.gson.annotations.SerializedName

data class Artwork(
    @SerializedName("id")
    val id: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)