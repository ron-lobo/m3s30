package com.m3.spring;

import com.m3.spring.Deps.DepA;
import com.m3.spring.Deps.DepB;
import com.m3.spring.service.GoodByeService;
import com.m3.spring.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class HelloSpring {

	@Bean
	public HelloSpringClient getHelloSpringClient(HelloService helloService) {
		return new HelloSpringClient(helloService);
	}

	@Bean
	public HelloService getHelloService(DepA depA, DepB depB) {
		return new HelloService(depA, depB);
	}

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(HelloSpring.class, MyConfig.class);
		System.out.println("App Context initialised");

		HelloSpringClient helloSpringClient = appContext.getBean(HelloSpringClient.class);
		helloSpringClient.print("hello");

		GoodByeService goodByeService = appContext.getBean(GoodByeService.class);
		goodByeService.printout("bye");
	}
}
