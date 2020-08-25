package com.m3.spring.service;

import com.m3.spring.Deps.DepA;
import com.m3.spring.Deps.DepB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoodByeService {

	@Autowired	// do not do this
	private DepA depA;

	private DepB depB;

	@Autowired
	public void setDepB(DepB depB) {
		this.depB = depB;
	}

	public void printout(String mesg) {
		depA.doNothing();
		System.out.println(mesg);
	}
}
