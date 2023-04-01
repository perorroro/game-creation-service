package com.example.mygame.infrastructure.persistence

import com.example.mygame.domain.Game

interface GameRepository {
    fun create(game: Game): Game?
    fun findById(id: Long): Game?
}
