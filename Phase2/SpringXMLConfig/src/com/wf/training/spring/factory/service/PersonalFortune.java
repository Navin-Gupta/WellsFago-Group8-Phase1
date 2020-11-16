package com.wf.training.spring.factory.service;

public class PersonalFortune implements FortuneService{

	@Override
	public String dailyFortune() {
		return "Today is your lucky day!";
	}

	
}
