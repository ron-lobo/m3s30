package com.m3.spring;

import com.m3.spring.Deps.DepA;
import com.m3.spring.Deps.DepB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	@Bean
	public DepA createDepA() {
		return new DepA();
	}

	@Bean
	public DepB createDepB() {
		return new DepB();
	}
}
