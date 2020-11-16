package com.wf.training.spring.factory.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wf.training.spring.factory.service.EmailService;
import com.wf.training.spring.factory.service.MessageService;
import com.wf.training.spring.factory.service.SmsService;

public class MyApp {

	public static void main(String[] args) {
		
		// Create a container (bean factory) based on XML file (config)
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// demand / retrieve the beans from factory
		// MessageService service = context.getBean(MessageService.class);
		// MessageService service = context.getBean(EmailService.class);
		MessageService service = context.getBean("email", MessageService.class);
		String ack = service.sendMessage("Hello All", "someone");
		System.out.println(ack);
	}

}
