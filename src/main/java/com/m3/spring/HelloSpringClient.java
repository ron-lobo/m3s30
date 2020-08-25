package com.m3.spring;

public class HelloSpringClient {

	private HelloService helloService;

	public HelloSpringClient(HelloService helloService) {
		this.helloService = helloService;
	}

	public void print(String message) {
		helloService.printout(message);
	}
}
