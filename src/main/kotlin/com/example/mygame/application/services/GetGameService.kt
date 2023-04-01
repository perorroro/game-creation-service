package com.example.mygame.application.services

import com.example.mygame.adapters.inbound.web.dto.GameDto
import com.example.mygame.infrastructure.persistence.GameRepository
import org.springframework.stereotype.Service


@Service
class GameServiceImpl(private val gameRepository: GameRepository) : GameService {
    override fun createGame(gameDto: GameDto): GameDto? {
        return gameRepository.create(gameDto.toGame())?.toGameDto()
    }

    override fun getGameById(id: Long): GameDto? {
        return gameRepository.findById(id)?.toGameDto()
    }
}
