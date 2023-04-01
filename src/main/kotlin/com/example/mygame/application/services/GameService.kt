package com.example.mygame.application.services

import com.example.mygame.adapters.inbound.web.dto.GameDto


interface GameService {
    fun createGame(gameDto: GameDto): GameDto?
    fun getGameById(id: Long): GameDto?
}