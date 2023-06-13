package com.luiz.gamingwiki.data.repository

import com.luiz.gamingwiki.data.model.Games
import com.luiz.gamingwiki.data.model.GamesItem
import com.luiz.gamingwiki.data.repository.datasource.GamesRemoteDataSource
import com.luiz.gamingwiki.data.util.Resource
import com.luiz.gamingwiki.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.Body

class GamesRepositoryImpl(
    private val gamesRemoteDataSource: GamesRemoteDataSource
):GameRepository {

    override suspend fun getGames(body: String): Resource<Games> {
        return responseToResource(gamesRemoteDataSource.getBestRatingGames(body))
    }

    override suspend fun saveGame(gamesItem: GamesItem) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteGame(gamesItem: GamesItem) {
        TODO("Not yet implemented")
    }

    override fun getSavedGames(): Flow<List<GamesItem>> {
        TODO("Not yet implemented")
    }

    private fun responseToResource(response: Response<Games>):Resource<Games>{
        if(response.isSuccessful){
            response.body()?.let {
                return Resource.Sucess(it)
            }
        }
        return Resource.Error(response.message())
    }

}