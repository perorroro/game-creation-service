package com.example.mygame.infrastructure.persistence

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface GameJpaRepository : JpaRepository<GameEntity, Long> {

    override fun findById(id: Long): Optional<GameEntity>

    fun save(game: GameEntity): GameEntity
}
