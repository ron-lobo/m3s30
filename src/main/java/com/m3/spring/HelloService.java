package com.m3.spring;

import com.m3.spring.Deps.DepA;
import com.m3.spring.Deps.DepB;

public class HelloService {

	private DepA depA;
	private DepB depB;

	public HelloService(DepA depA, DepB depB) {
		this.depA = depA;
		this.depB = depB;
	}

	public void printout(String mesg) {
		System.out.println(mesg);
	}
}
