package com.wf.training.changestyle;

class MessageApi{
	
	/*public void conveyMessage(String message, String dest) {
		// if | switch
		System.out.println(message);
		// if(email) {}
		// if(sms) {}
	}*/
	
	public void conveyMessage(String message, Greetings greet) {
		greet.sendMesssage(message);
	}
}


class Sample{
	public static void staticRes(String str) {
		System.out.println("Static Resource consumes string : " + str);
	}
	
	/*public void instanceRes(Integer param) {
		System.out.println("Instance resource consumes string : " + param);
	}*/
	public void instanceRes(String str) {
		System.out.println("Instance resource consumes string : " + str);
	}
}

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageApi msg = new MessageApi();
		// msg.conveyMessage("Hello All");
		
		Greetings email = new EmailGreetings();
		msg.conveyMessage("Hello All", email);
		
		Greetings sms = new SmsGreetings();
		msg.conveyMessage("Hello All", sms);
		
		// anonymous inner class
		/*msg.conveyMessage("Hello All", new Greetings() {
			@Override
			public void sendMesssage(String message) {
				System.out.println("Message send over Twitter : " + message);
			}
		});*/
		
		/*msg.conveyMessage("Hello All", public void sendMesssage(String message) {
											System.out.println("Message send over Twitter : " + message);
										});*/
		
		/*Function twitter = public void sendMesssage(String message) {
					System.out.println("Message send over Twitter : " + message);
				}*/
		/*Greetings twitter = public void sendMesssage(String message) {
								System.out.println("Message send over Twitter : " + message);
							}*/
		// Pure Function : syntax Lambda expression
		int a = 10;
		Greetings twitter = message -> {
								System.out.println("Message send over Twitter : " + message);
								System.out.println(a);
								int x = 10;
								// int a = 10;
								// a = 20;
							};
		
		// 100% backward compatible
		msg.conveyMessage("Hello All", twitter);
		msg.conveyMessage("Hello All", message -> System.out.println("Message send over Network : " + message));
					
		// can refer to any method as long as signature matches
		// :: method reference operator
		Greetings randomRef = Sample :: staticRes;
		msg.conveyMessage("Hello All", randomRef);
		
		Sample S1 = new Sample();
		msg.conveyMessage("Hello All", S1 :: instanceRes);
		ICheck.sfun();
	}

}
