package com.wf.training.spring.factory.service;

public class EmailService implements MessageService{

	// dependency on FortuneService
	private FortuneService fortuneService;
	private String sender;
	
	
	// bean factory will call this constructor and pass(inject) the dependency
	/*public EmailService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/
	
	public EmailService() {
		System.out.println("Email Bean initiated...");
	}
	
	// getting dependency through setter method
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}

	
	// can have any access modifiers
	// can have any return type, but void is recommended
	// can have any name
	// must not have any param
	private void myInit() {
		System.out.println("Bean prepared to be used...");
	}

	@Override
	public String sendMessage(String message, String to) {
		return "Email sent : " + message + "[To:" + to + "]" +
				"\nSent By :" + this.sender +
				"\n" + this.fortuneService.dailyFortune();	
	}
	
	private void myCleanUp() {
		System.out.println("Bean ready to be destroyed...");
	}

}
