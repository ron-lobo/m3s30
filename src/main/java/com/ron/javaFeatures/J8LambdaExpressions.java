package com.ron.javaFeatures;

public class J8LambdaExpressions {

	public static final String INTRO_NAME = "Hi, I am";
	public static final String AND = "and";
	public static final String INTRO_JOB = "I am a";

	public static void main(String[] args) {
		Utils.print("Features Introduced in Java 8: LambdaExpressions");
		J8LambdaExpressions j8 = new J8LambdaExpressions();
		j8.lambdaExpressions();
	}

	// @FunctionalInterface
	private interface Intro0 {
		void introduce();
	}

	@FunctionalInterface
	private interface Intro1 {
		String introduce(String name);
	}

	@FunctionalInterface
	private interface Intro2 {
		String introduce(String name, String job);
	}


	private class MyIntro2 implements Intro2 {
		@Override
		public String introduce(String name, String job) {
			return Utils.print(INTRO_NAME, name, AND, INTRO_JOB, job);
		}
	}

	private void lambdaExpressions() {
		Utils.newMethod("lambdaExpressions");

		Intro2 objA = new MyIntro2();

		Intro2 objB = new Intro2() {
			@Override
			public String introduce(String name, String job) {
				return Utils.print(INTRO_NAME, name, AND, INTRO_JOB, job);
			}
		};


		Intro2 lambdaA1 = (String name, String job) -> {
			return Utils.print(INTRO_NAME, name, AND, INTRO_JOB, job);
		};


		Intro2 lambdaA2 = (name, job) -> {
			return Utils.print(INTRO_NAME, name, AND, INTRO_JOB, job);
		};


		Intro2 lambdaA3 = (name, job) -> Utils.print(INTRO_NAME, name, AND, INTRO_JOB, job);


		Intro1 lambdaB = name -> Utils.print(INTRO_NAME, name);


		Intro0 lambdaC = () -> Utils.print(INTRO_NAME, "Mr Anon E Mouse");


		// let's try using them:
		objA.introduce("Liz", "queen");
		objB.introduce("Florence", "machine");

		lambdaA1.introduce("Francis", "pope");
		lambdaA2.introduce("Donald", "dope");
		lambdaA3.introduce("Justin", "chanteuse");

		lambdaB.introduce("Kim");
		lambdaC.introduce();
	}
}
