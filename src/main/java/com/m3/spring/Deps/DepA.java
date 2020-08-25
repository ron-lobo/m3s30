package com.m3.spring.Deps;

import javax.annotation.PostConstruct;

public class DepA {

	public void doNothing() {
		//
	}

	@PostConstruct
	public void created() {
		System.out.println("DepA object created");
	}
}
