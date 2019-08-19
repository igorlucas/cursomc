package com.cursomc.main.services;

import org.springframework.mail.SimpleMailMessage;

import com.cursomc.main.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido pedido);
	
	void sendEmail(SimpleMailMessage email);
}
