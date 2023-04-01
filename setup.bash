#!/bin/bash

# create test directory
mkdir -p src/test/kotlin/com/example/demo

# create test file for GameService
cat >src/test/kotlin/com/example/demo/GameServiceTest.kt <<EOF
package com.example.demo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class GameServiceTest {
    private lateinit var gameRepository: GameRepository
    private lateinit var gameService: GameService

    @BeforeEach
    fun setUp() {
        gameRepository = mock(GameRepository::class.java)
        gameService = GameServiceImpl(gameRepository)
    }

    @Test
    fun \`test create game\`() {
        val gameDto = GameDto(null, "test", "test description")
        val game = Game(1, "test", "test description", "", false)
        $(when)(gameRepository.save(gameDto.toGame())).thenReturn(game)
        assertEquals(game.id, gameService.createGame(gameDto).id)
    }

    @Test
    fun \`test create game with invalid input\`() {
        val gameDto = GameDto(null, "", "")
        assertThrows(IllegalArgumentException::class.java) { gameService.createGame(gameDto) }
    }

    @Test
    fun \`test get game by id\`() {
        val game = Game(1, "test", "test description", "", false)
        $(when)(gameRepository.findById(1)).thenReturn(game)
        assertEquals(game.id, gameService.getGameById(1).id)
    }

    @Test
    fun \`test get game by id not found\`() {
        $(when)(gameRepository.findById(1)).thenReturn(null)
        assertThrows(GameNotFoundException::class.java) { gameService.getGameById(1) }
    }
}
EOF
