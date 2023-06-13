package com.luiz.gamingwiki.domain.repository

import com.luiz.gamingwiki.data.model.Games
import com.luiz.gamingwiki.data.model.GamesItem
import com.luiz.gamingwiki.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface GameRepository {

        suspend fun getGames(body: String):Resource<Games>

        suspend fun saveGame(gamesItem: GamesItem)

        suspend fun deleteGame(gamesItem: GamesItem)

        fun getSavedGames(): Flow<List<GamesItem>>
}