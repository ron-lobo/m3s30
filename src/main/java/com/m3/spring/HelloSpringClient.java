package com.m3.spring;

import com.m3.spring.service.HelloService;

public class HelloSpringClient {

	private HelloService helloService;

	public HelloSpringClient(HelloService helloService) {
		this.helloService = helloService;
	}

	public void print(String message) {
		helloService.printout(message);
	}
}
