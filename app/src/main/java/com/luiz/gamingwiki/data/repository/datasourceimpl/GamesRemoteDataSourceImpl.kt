package com.luiz.gamingwiki.data.repository.datasourceimpl

import com.luiz.gamingwiki.data.api.IGDBAPIService
import com.luiz.gamingwiki.data.model.Games
import com.luiz.gamingwiki.data.repository.datasource.GamesRemoteDataSource
import retrofit2.Response

class GamesRemoteDataSourceImpl(
    private val igdbapiService: IGDBAPIService
):GamesRemoteDataSource {
    override suspend fun getBestRatingGames(
        body: String
    ): Response<Games> {
        return igdbapiService.getBestRatingGames(body)
    }
}