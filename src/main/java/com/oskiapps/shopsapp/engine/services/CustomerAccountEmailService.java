package com.oskiapps.shopsapp.engine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerAccountEmailService {

	@Autowired
	public EmailService emailService;

	public void sendRegistrationMessage(String to) {
		String subject = "Welcome to ShopsApp";
		String text = "Welcome to ShopsApp " + to
				+ ". You have created your account, you can login using your email address.";
		emailService.sendSimpleMessage(to, subject, text);
	}
}
