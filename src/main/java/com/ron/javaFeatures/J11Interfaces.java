package com.ron.javaFeatures;

import java.util.List;

public class J11Interfaces {

	public static void main(String[] args) {
		Utils.print("Features Introduced in Java 11: Interfaces()");
		J11Interfaces j11 = new J11Interfaces();
		j11.useJ11Interface();
	}


	public interface Java11Interface {

		default void defaultHello() {
			hello("an instance method");    // instance methods can call static methods
		}

		static void staticHello() {
			// defaultHello();              // static methods cannot call instance methods
			hello("a static method");
		}

		// a private static method
		private static void hello(String s) {
			Utils.print("Hi from", s);
		}

		default List<String> doPreferredSort() {
			return sortByName();
		}

		default List<String> sortByName() {
			return sort(1, true);
		}

		default List<String> sortByAddress() {
			return sort(2, true);
		}

		default List<String> sortByAge(boolean direction) {
			return sort(3, direction);
		}

		// a private instance method
		private List<String> sort(int index, boolean direction) {
			Utils.print("sort: index =", index, ", direction =", direction);
			List<String> results = null;
			// do some sorting and processing ...
			return results;
		}
	}

	@FunctionalInterface
	private interface Hello {
		String hi();
	}

	public class MyHello implements Hello {
		@Override
		public String hi() {
			return "hi";
		}
	}


	public void useJ11Interface() {
		System.out.println("useJ11Interface");

		Hello myHello = new MyHello();

		Hello myHello1 = new Hello() {
			@Override
			public String hi() {
				return null;
			}
		};

		Hello myHello2 = () -> null;


		Java11Interface j11A = new Java11Interface() {
		};

		// create an instance of Java11Interface and override one method
		Java11Interface j11B = new Java11Interface() {
			@Override
			public List<String> doPreferredSort() {
				// return sort(3, false);           // inaccessible private member
				return sortByAge(false);
			}
		};


		Java11Interface.staticHello();  // call static methods directly, not with an instance

		j11A.defaultHello();
		j11A.doPreferredSort();

		j11B.defaultHello();
		j11B.doPreferredSort();
		j11B.sortByName();
		j11B.sortByAddress();
		j11B.sortByAge(false);
	}



	private interface Test extends Hello, Java11Interface {

		public static final int i = 0;      // public, static and final modifiers are redundant
		int NUM_CITIES = 0;                 // constants only - value must be specified

		// Test();                          // constructor not allowed

		String method0();

		public String method1();            // public modifier is redundant

		// protected String method2();      // protected methods are not allowed

		private String method4() {
			return null;
		}

		static void method3() {
			// do something here
		}

		private static String method5() {
			return null;
		}
	}
}
