package com.m3.m3s30;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@SpringBootApplication
public class HelloWorldApp {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApp.class, args);
	}

	@RequestMapping("/")
	public String m1() {
		return "<h1>hello S30</h1> your lucky number is: " + new Random().nextLong();
	}

	@RequestMapping("/s30")
	public String m2() {
		return "<h1>bye S30</h1> <h2>farewell</h2><h3>adios</h3>";
	}

	@Bean
	public String getString() {
		return "1234";
	}
}
