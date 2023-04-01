package com.example.mygame.infrastructure.persistence

import com.example.mygame.domain.Game
import javax.persistence.*

@Entity
@Table(name = "game")
data class GameEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    val name: String,

    val description: String,

    @Column(name = "word_to_guess")
    val wordToGuess: String,

    @Column(name = "is_started")
    val isStarted: Boolean
) {
    fun toGame() = Game(
        id = this.id,
        name = this.name,
        description = this.description,
        wordToGuess = this.wordToGuess,
        isStarted = this.isStarted
    )
}
