package com.luiz.gamingwiki.domain.usecases

import com.luiz.gamingwiki.data.model.GamesItem
import com.luiz.gamingwiki.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow

class GetSavedGames(private val gameRepository: GameRepository) {

    suspend fun execute(): Flow<List<GamesItem>>{
        return gameRepository.getSavedGames()
    }

}