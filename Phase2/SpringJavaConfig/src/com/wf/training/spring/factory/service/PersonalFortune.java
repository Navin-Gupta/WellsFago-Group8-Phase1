package com.wf.training.spring.factory.service;

import org.springframework.stereotype.Component;

// @Component
public class PersonalFortune implements FortuneService{

	@Override
	public String dailyFortune() {
		return "Today is your lucky day!";
	}

	
}
