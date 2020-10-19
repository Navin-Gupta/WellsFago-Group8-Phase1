package com.wf.training.changestyle;

public class SmsGreetings implements Greetings{

	@Override
	public void sendMesssage(String message) {
		System.out.println("Message Send over SMS : " + message);
	}

}
