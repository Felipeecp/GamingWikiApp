package com.luiz.gamingwiki.domain.usecases

import com.luiz.gamingwiki.data.model.GamesItem
import com.luiz.gamingwiki.domain.repository.GameRepository

class DeleteGameUseCase(private val gameRepository: GameRepository) {

    suspend fun execute(game: GamesItem) = gameRepository.deleteGame(game)

}