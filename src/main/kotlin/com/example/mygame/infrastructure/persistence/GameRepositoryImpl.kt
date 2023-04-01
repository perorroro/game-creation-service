package com.example.mygame.infrastructure.persistence

import com.example.mygame.domain.Game
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
open class GameRepositoryImpl : GameRepository {

    private val gameJpaRepository: GameJpaRepository

    @Autowired
    constructor(gameJpaRepository: GameJpaRepository) {
        this.gameJpaRepository = gameJpaRepository
    }

    override fun create(game: Game): Game {
        return gameJpaRepository.save(game.toEntity()).toGame()
    }

    override fun findById(id: Long): Game? {
        return gameJpaRepository.findByIdOrNull(id)?.toGame()
    }
}

