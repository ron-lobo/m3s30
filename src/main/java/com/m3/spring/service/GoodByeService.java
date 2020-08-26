package com.m3.spring.service;

import com.m3.spring.Deps.DepA;
import com.m3.spring.Deps.DepB;
import com.m3.spring.Deps.S30able;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodByeService {

	@Autowired	// do not do this
	private DepA depA;

	private DepB depB;
	private S30able s30;

//	@Autowired	// do not do this
//	@Qualifier("group1")
//	 @Resource(name="group1")
//	private S30able s30a;

	public GoodByeService() {
	}

	@Autowired
	public GoodByeService(@Qualifier("group2") S30able s30) {
		this.s30 = s30;
	}

	@Autowired
	public void setDepB(DepB depB) {
		this.depB = depB;
	}

	public void printout(String mesg) {
		depA.doNothing();
		System.out.println(mesg);

		s30.standUpMeeting();
		s30.doSomeWork();
		s30.doTest();
	}
}
