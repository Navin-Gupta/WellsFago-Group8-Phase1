package com.wf.training.spring.factory.config;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.wf.training.spring.factory.service.FortuneService;
import com.wf.training.spring.factory.service.PersonalFortune;
import com.wf.training.spring.factory.service.ProfessionalFortune;

// treat/read this class as config class
@Configuration
// component scanning path
@ComponentScan("com.wf.training.spring.factory")
// load the properties file
@PropertySource("classpath:repository.properties")
public class MyConfig {
	
	// logic to expose bean of a particular fortune service
	// create a method to contain that logic
	// purpose : expose the bean
	@Bean
	public FortuneService fortuneService() {
		if(LocalTime.now().getHour() < 10 || LocalTime.now().getHour() > 17)
			return new PersonalFortune();
		return new ProfessionalFortune();
	}
}



















