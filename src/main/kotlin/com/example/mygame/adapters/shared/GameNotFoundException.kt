package com.example.mygame.adapters.shared

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class GameNotFoundException(id: String) : RuntimeException("com.example.mygame.domain.Game with id $id not found")
