package com.luiz.gamingwiki.data.model


import com.google.gson.annotations.SerializedName

data class Platform(
    @SerializedName("abbreviation")
    val abbreviation: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)