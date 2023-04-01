package com.example.mygame.adapters.inbound.web.controllers

import com.example.mygame.adapters.inbound.web.dto.GameDto
import com.example.mygame.application.services.GameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/games")
class GameController(@Autowired private val gameService: GameService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createGame(@RequestBody gameDto: GameDto): GameDto? {
        return gameService.createGame(gameDto)
    }

    @GetMapping("/{id}")
    fun getGame(@PathVariable id: Long): GameDto? {
        return gameService.getGameById(id)
    }
}
