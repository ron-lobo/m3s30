package com.m3.spring.config;

import com.m3.spring.Deps.DepA;
import com.m3.spring.Deps.DepB;
import com.m3.spring.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig2 {

	@Bean
	public HelloService getHelloService(DepA depA, DepB depB) {
		return new HelloService(depA, depB);
	}
}
