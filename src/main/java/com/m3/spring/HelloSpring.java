package com.m3.spring;

import com.m3.spring.Deps.DepA;
import com.m3.spring.Deps.DepB;
import com.m3.spring.config.MyConfig;
import com.m3.spring.service.GoodByeService;
import com.m3.spring.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan // (basePackages={"com.m3.spring.service"})
public class HelloSpring {

	@Bean
	public HelloSpringClient getHelloSpringClient(HelloService helloService) {
		return new HelloSpringClient(helloService);
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
