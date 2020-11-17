package com.wf.training.spring.factory.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("email")
@Scope("singleton")
public class EmailService implements MessageService{
	
	// dependency
	// Field based DI
	// @Autowired
	// @Qualifier("personalFortune")
	private FortuneService fortuneService;
	
	@Value("${msg.email.sender}")
	private String sender;
	
	@Autowired
	// Constructors are by default autowired...
	public EmailService(@Qualifier("personalFortune") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	// setter/method based DI
	/*@Autowired
	 * @Qualifier("personalFortune")
	// public void setFortuneService(FortuneService fortuneService) {
	public void xyz(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/
	
	// init hook method
	@PostConstruct
	private void myInit() {
		System.out.println("Bean Logical Initiation");
	}
	
	
	@Override
	public String sendMessage(String message, String to) {
		return "Email sent : " + message + "[To:" + to + "]" +
				"\nSend By : " + this.sender + 
			   "\n" + this.fortuneService.dailyFortune();	
	}

	// destroy hook method
	@PreDestroy
	private void myCleanUp() {
		System.out.println("Bean Resources released...");
	}
	
}
