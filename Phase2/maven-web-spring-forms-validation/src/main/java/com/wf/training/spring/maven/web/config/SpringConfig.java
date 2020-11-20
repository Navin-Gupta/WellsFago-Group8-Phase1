package com.wf.training.spring.maven.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc // initiate bean factory auto 
@ComponentScan("com.wf.training.spring.maven.web")
public class SpringConfig {

	// method to expose ViewResolver Bean
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver =
				new InternalResourceViewResolver();
		// inject dependency
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
}
