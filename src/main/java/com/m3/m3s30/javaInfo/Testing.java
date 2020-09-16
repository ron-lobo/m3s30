package com.m3.m3s30.javaInfo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Testing {


	public static void main(String[] args) {
		Testing testing = new Testing();
		testing.demo1();
		testing.testEquals("ab");
	}

	public void demo1() {
		final boolean USE_EQUALS_OP = false;

		List l = new ArrayList(10000);

		Student student1 = new Student(1, "Henry", LocalDate.of(2000, 1, 1));
		student1.setAddress("1 The Road, London, UK");
		Student student2 = new Student(2, "Sally", LocalDate.of(2001, 1, 1));
		Student student3 = retrieveFromDB(1);
		// lots of processing
		store(student1);
		store(student2);
		boolean same1 = test(USE_EQUALS_OP, student1, student2);
		System.out.println("same1=" + same1);
		System.out.println("same2=" + test(USE_EQUALS_OP, student1, student3));
	}

	private Student retrieveFromDB(int i) {
		Student student = new Student(i, "Henry", LocalDate.of(2000, 1, 1));
		student.setAddress("1 The Road, London, UK");
		return student;
	}

	private void store(Student student) {
		System.out.println("about to store: " + student);
		// code to store in DB
		// ...
	}

	private static boolean test(boolean useEqualsOperator, Student studentA, Student studentB) {
		if (useEqualsOperator) {
			return studentA == studentB;
		} else {
			return studentA.equals(studentB);
		}
	}

	private void testEquals(String s3) {
		Student student1 = new Student(1, "Henry", LocalDate.of(2000, 1, 1));
		Student student2 = new Student(1, "Henry", LocalDate.of(2000, 1, 1));
		Student student3 = student2;
		testEquality("student 3 vs 2", student3, student2);
		testEquality("student 1 vs 2", student1, student2);

		// Strings
		String s1 = "abc";
		String s2 = "abc";
		s3 += "c";
		testEquality("string s1 vs s2", s1, s2);
		testEquality("string s1 vs s3", s1, s3);
//		s3 = s3.intern();
//		testEquality("string s1 vs s3", s1, s3);
	}

	private static void testEquals(String mesg, Object obj1, Object obj2) {
		boolean eqOp = obj1 == obj2;
		boolean eqMethod = obj1.equals(obj2);
		System.out.println(mesg + ": eqOp=" + eqOp + ", eqMethod=" + eqMethod);
	}

	private static <T> void testEquality(String mesg, T obj1, T obj2) {
		boolean eqOp = obj1 == obj2;
		boolean eqMethod = obj1.equals(obj2);
		System.out.println(mesg + ": eqOp=" + eqOp + ", eqMethod=" + eqMethod +
				" : obj1=[" + obj1 + "]" + ", obj2=[" + obj2 + "]");
	}

	private void testHashCodes() {
		Student student1 = new Student(1, "Henry", LocalDate.of(2000, 1, 1));
		Student student1a = new Student(1, "Henry", LocalDate.of(2000, 1, 1));
		Student student2 = new Student(2, "Sally", LocalDate.of(2000, 1, 1));

		int i1 = student1.hashCode();
		int i1a = student1a.hashCode();
		int i2 = student2.hashCode();

		// ...


		int i1_later = student1.hashCode();

	}
}
