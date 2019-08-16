package com.bolsadeideas.springboot.backend.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration 
@EnableWebSocketMessageBroker // Habilita el servidor de WebSocket en Spring
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/chat-websocket")
		.setAllowedOrigins("http://localhost:4200")
		.withSockJS();
	}

	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/chat/"); // prefijo en el chat, para nombre de los eventos => {<@SentTo["/chat/mensaje"]>}
		registry.setApplicationDestinationPrefixes("/app"); // prefijo para el destino en donde vamos a publicar
	}

}
