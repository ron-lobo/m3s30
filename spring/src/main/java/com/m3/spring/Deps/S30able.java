package com.m3.spring.Deps;

public interface S30able {

	default String doSomeWork() {
		return "work done";
	}

	default void doTest() {
		System.out.println("doing test");
	}

	void standUpMeeting();
}
