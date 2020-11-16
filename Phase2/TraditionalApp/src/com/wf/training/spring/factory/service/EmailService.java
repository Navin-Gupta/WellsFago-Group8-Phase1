package com.wf.training.spring.factory.service;

public class EmailService implements MessageService{

	@Override
	public String sendMessage(String message, String to) {
		return "Email sent : " + message + "[To:" + to + "]";
	}

}
