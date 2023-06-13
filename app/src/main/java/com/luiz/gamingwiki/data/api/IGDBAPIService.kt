package com.luiz.gamingwiki.data.api

import com.luiz.gamingwiki.BuildConfig
import com.luiz.gamingwiki.data.model.Games
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface IGDBAPIService {

    @POST("/v4/games")
    suspend fun getBestRatingGames(
        @Body
        body:String,
        @Header("Client_ID")
        clientId:String=BuildConfig.CLIENT_ID,
        @Header("Authorization")
        authHeader:String=BuildConfig.AUTH_HEADER
    ):Response<Games>

}