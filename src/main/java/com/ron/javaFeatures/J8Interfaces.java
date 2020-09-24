package com.ron.javaFeatures;

import java.time.LocalDateTime;

public class J8Interfaces {

	public static void main(String[] args) {
		System.out.println("Features Introduced in Java 8: Interfaces()");

		Java8Interface.hiWorld("new interface");
	}

	public interface Java8Interface {

		// static methods - these must be defined in the interface and cannot be overridden
		static String hiWorld(String s) {
			String result = String.format("hi %s world", s);
			System.out.println(result);
			return result;
		}

		void method(String str);

		void method(int i);

		void method(double d, boolean b);

		// A method with an implementation (which can be overridden).
		default void log(String str, int level) {
			LocalDateTime now = LocalDateTime.now();
			Utils.print(now, "Level", level, ":", str);
		}

//        default String toString() {
//            return "These are not the defaults you are looking for";
//        }
	}



	@FunctionalInterface
	public interface Greeting {
		void hi();
		default void hi2() {}
		default void hi3() {}
		default void hi4() {}
	}


	public interface USGreeting extends Greeting {
		@Override
		default void hi() {
			System.out.println("howdy");
		}

		void m1();

		void m2();
	}

	public interface OzGreeting extends Greeting {
		default void hi() {
			System.out.println("g'day");
		}
	}

	public interface MyGreeting extends USGreeting, OzGreeting {
		default void hi() {
			USGreeting.super.hi();
			OzGreeting.super.hi();
			System.out.println("sup");
		}
	}
}
