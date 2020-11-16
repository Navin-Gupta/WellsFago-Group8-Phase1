package com.wf.training.spring.factory.service;

public class EmailService implements MessageService{

	// dependency on FortuneService
	private FortuneService fortuneService;
	private String sender;
	
	
	// bean factory will call this constructor and pass(inject) the dependency
	/*public EmailService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/
	
	// getting dependency through setter method
	
	
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	

	public void setSender(String sender) {
		this.sender = sender;
	}


	@Override
	public String sendMessage(String message, String to) {
		return "Email sent : " + message + "[To:" + to + "]" +
				"\nSent By :" + this.sender +
				"\n" + this.fortuneService.dailyFortune();	
	}

}
