package com.example.mygame.adapters.outbound.messaging.socket

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.socket.*
import org.springframework.web.socket.client.standard.StandardWebSocketClient
import org.springframework.web.socket.handler.AbstractWebSocketHandler

@Component
class GameSocketClientImpl : GameSocketClient {

    private val logger = LoggerFactory.getLogger(GameSocketClientImpl::class.java)

    private var session: WebSocketSession? = null
    private val client = StandardWebSocketClient()

    override fun connect() {
        session = client.doHandshake(GameSocketHandler(), "ws://localhost:8080/ws").get()
    }

    override fun emit(event: String, data: Any) {
        session?.sendMessage(TextMessage("$event:$data"))
    }

    override fun on(event: String, listener: (Any) -> Unit) {
        handlers[event] = listener
    }

    override fun disconnect() {
        session?.close()
    }

    private val handlers = mutableMapOf<String, (Any) -> Unit>()

    inner class GameSocketHandler : AbstractWebSocketHandler() {
        override fun afterConnectionEstablished(session: WebSocketSession) {
            logger.info("WebSocket connection established")
            this@GameSocketClientImpl.session = session
        }

        override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
            val parts = message.payload.split(":")
            if (parts.size != 2) {
                logger.warn("Invalid message received: {}", message.payload)
                return
            }
            val event = parts[0]
            val data = parts[1]
            handlers[event]?.invoke(data)
        }

        override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
            logger.error("WebSocket transport error", exception)
        }

        override fun afterConnectionClosed(session: WebSocketSession, closeStatus: CloseStatus) {
            logger.info("WebSocket connection closed: {}", closeStatus)
        }
    }
}
