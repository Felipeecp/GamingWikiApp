package com.luiz.gamingwiki.domain.usecases

import com.luiz.gamingwiki.data.model.Games
import com.luiz.gamingwiki.data.util.Resource
import com.luiz.gamingwiki.domain.repository.GameRepository

class GetGamesUseCase(private val gameRespository: GameRepository) {

    suspend fun execute(body:String): Resource<Games>{
        return gameRespository.getGames(body)
    }

}