package com.example.mygame.adapters.inbound.web.dto

import com.example.mygame.domain.Game

class GameDto(
    val id: Long?,
    private val name: String,
    private val description: String,
    private val wordToGuess: String,
    private val isStarted: Boolean
) {
    fun toGame() = Game(
        id = this.id,
        name = this.name,
        description = this.description,
        wordToGuess = this.wordToGuess,
        isStarted = this.isStarted
    )
}
