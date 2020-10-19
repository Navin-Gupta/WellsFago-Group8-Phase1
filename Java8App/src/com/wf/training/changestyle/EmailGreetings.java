package com.wf.training.changestyle;

public class EmailGreetings implements Greetings{

	@Override
	public void sendMesssage(String message) {
		System.out.println("Message Send over Email : " + message);
	}

}
