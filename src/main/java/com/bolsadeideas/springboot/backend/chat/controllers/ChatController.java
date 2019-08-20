package com.bolsadeideas.springboot.backend.chat.controllers;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.bolsadeideas.springboot.backend.chat.models.documents.Mensaje;
import com.bolsadeideas.springboot.backend.chat.models.services.ChatService;

@Controller
public class ChatController {
	
	private String[] colores = {"black", "gray", "blue", "red", "purple", "magenta", "orange"};
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private SimpMessagingTemplate webSocket;
	
	/* Recibe el mensaje y le asigna la Fecha y el Texto */
	@MessageMapping("/mensaje") // Para publicar
	@SendTo("/chat/mensaje") // Para recibir/escuchar/subscribirse
	public Mensaje recibeMensaje(Mensaje mensaje) {
		mensaje.setFecha(new Date().getTime());
		
		if(mensaje.getTipo().equals("NUEVO_USUARIO")) {
			mensaje.setColor(colores[new Random().nextInt(colores.length)]);
			mensaje.setTexto("Nuevo usuario");
		} else {
			chatService.guardar(mensaje);
		}
								
		return mensaje;
	}
	
	@MessageMapping("/escribiendo")
	@SendTo("/chat/escribiendo")
	public String estaEscribiendo(String username) {
		return username.concat(" está escribiendo...");
	}
	
	@MessageMapping("/historial")
	public void historial(String clienteId){
		webSocket.convertAndSend("/chat/historial/"+clienteId, chatService.obtenerUltimos10Mensajes());
	}

}
