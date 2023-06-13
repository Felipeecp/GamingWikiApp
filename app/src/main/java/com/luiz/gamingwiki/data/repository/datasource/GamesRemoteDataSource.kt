package com.luiz.gamingwiki.data.repository.datasource

import com.luiz.gamingwiki.data.model.Games
import retrofit2.Response

interface GamesRemoteDataSource {

    suspend fun getBestRatingGames(body:String):Response<Games>

}