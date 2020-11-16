package com.wf.training.spring.factory.client;

import com.wf.training.spring.factory.service.EmailService;
import com.wf.training.spring.factory.service.MessageService;
import com.wf.training.spring.factory.service.SmsService;

public class MyApp {

	public static void main(String[] args) {
		// Traditional way
		MessageService service = new SmsService(); // tightly coupled code
		String ack = service.sendMessage("Hello All", "someone");
		System.out.println(ack);

	}

}
