package com.example.mygame.adapters.outbound.messaging.socket

interface GameSocketClient {
    fun connect()
    fun disconnect()
    fun on(event: String, listener: (Any) -> Unit)
    fun emit(event: String, data: Any)
}
