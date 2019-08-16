package com.bolsadeideas.springboot.backend.chat.controllers;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.bolsadeideas.springboot.backend.chat.models.documents.Mensaje;

@Controller
public class ChatController {
	
	/* Recibe el mensaje y le asigna la Fecha y el Texto */
	@MessageMapping("/mensaje") // Para publicar
	@SendTo("/chat/mensaje") // Para recibir/escuchar/subscribirse
	public Mensaje recibeMensaje(Mensaje mensaje) {
		mensaje.setFecha(new Date().getTime());
		mensaje.setTexto("Recibido por el broker: " + mensaje.getTexto());
		return mensaje;
	}

}
