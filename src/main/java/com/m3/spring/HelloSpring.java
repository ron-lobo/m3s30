package com.m3.spring;

import com.m3.spring.Deps.DepA;
import com.m3.spring.Deps.DepB;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloSpring {

	@Bean
	public static HelloSpringClient getHelloSpringClient(HelloService helloService) {
		return new HelloSpringClient(helloService);
	}

	@Bean
	public static HelloService getHelloService(DepA depA, DepB depB) {
		return new HelloService(depA, depB);
	}

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(HelloSpring.class, MyConfig.class);

		HelloSpringClient helloSpringClient = appContext.getBean(HelloSpringClient.class);
		helloSpringClient.print("hello");

		// System.out.println("Hello");
	}
}
