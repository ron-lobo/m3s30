package com.m3.spring.Deps;

import java.util.Arrays;

public class DepS30 implements S30able {

	private String[] members;

	public DepS30(String... members) {
		this.members = members;
	}

	@Override
	public void standUpMeeting() {
		System.out.println("sit down meeting");
//		for (String member : members) {
//			System.out.println(member + "'s update");
//		}
		Arrays.stream(members).forEach(m -> System.out.println(m + "'s update"));
	}

	public static void main(String... args) {
		new DepS30("m1", "m2");
		new DepS30("m1", "m2", "m1", "m2", "m1", "m2");
		new DepS30();
	}
}
