package com.example.mygame.domain

import com.example.mygame.adapters.inbound.web.dto.GameDto
import com.example.mygame.infrastructure.persistence.GameEntity

data class Game(
    val id: Long?,
    val name: String,
    val description: String,
    val wordToGuess: String,
    val isStarted: Boolean
) {
    fun toGameDto() = GameDto(
        id = this.id,
        name = this.name,
        description = this.description,
        wordToGuess = this.wordToGuess,
        isStarted = this.isStarted
    )

    fun toEntity() = GameEntity(
        id = this.id,
        name = this.name,
        description = this.description,
        wordToGuess = this.wordToGuess,
        isStarted = this.isStarted
    )
}
