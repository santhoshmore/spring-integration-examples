package com.si.demo;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;


public class MessageHandler {
	@ServiceActivator
	public String handleMessage(String message) {
		System.out.println("Recieved message: " + message);
		return "MESSAGE:" + message;
	}
}
