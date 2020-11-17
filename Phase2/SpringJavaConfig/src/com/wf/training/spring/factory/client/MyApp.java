package com.wf.training.spring.factory.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wf.training.spring.factory.config.MyConfig;
import com.wf.training.spring.factory.service.EmailService;
import com.wf.training.spring.factory.service.MessageService;
import com.wf.training.spring.factory.service.SmsService;

public class MyApp {

	public static void main(String[] args) {
		
		// Create a container (bean factory) based on Java class
		// all singleton beans are created here..
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(MyConfig.class);
		
		// Demand the bean
		MessageService service = context.getBean("email", MessageService.class);
		String ack = service.sendMessage("Hello all!", "someone");
		System.out.println(ack);
		
		// close the container
		context.close();
	}

}
