package com.luiz.gamingwiki.data.model


import com.google.gson.annotations.SerializedName

data class GamesItem(
    @SerializedName("artworks")
    val artworks: List<Artwork>,
    @SerializedName("category")
    val category: Int,
    @SerializedName("created_at")
    val createdAt: Int,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("platforms")
    val platforms: List<Platform>,
    @SerializedName("similar_games")
    val similarGames: List<GamesItem>,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("storyline")
    val storyline: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("themes")
    val themes: List<Theme>
)