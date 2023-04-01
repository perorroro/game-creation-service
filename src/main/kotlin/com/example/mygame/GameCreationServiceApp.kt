package com.example.mygame

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class GameCreationServiceApp

fun main(args: Array<String>) {
    runApplication<GameCreationServiceApp>(*args)
}


