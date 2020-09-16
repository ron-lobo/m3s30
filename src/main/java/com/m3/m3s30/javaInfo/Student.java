package com.m3.m3s30.javaInfo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {

	private final int id;
	private final String name;
	private final LocalDate dob;
	private Set<String> courses = new HashSet<>();
	private String address;

	public Student(int id, String name, LocalDate dob) {
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public Set<String> getCourses() {
		return courses;
	}

	public void addCourse(String course) {
		courses.add(course);
	}

	public boolean removeCourse(String course) {
		return courses.remove(course);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name=" + name +
				", dob=" + dob +
				", courses=" + courses +
				", address='" + address + '\'' +
				'}';
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Student)) {
			return false;
		} else {
			Student other = (Student) obj;
			return (id == other.id &&
					name != null && name.equals(other.name) &&
					dob != null && dob.equals(other.dob) &&
					courses != null && courses.equals(other.courses) &&
					address != null && address.equals(other.address));
		}
	}

	public static void main(String[] args) {

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

	private static Student retrieveFromDB(int i) {
		Student student = new Student(1, "Henry", LocalDate.of(2000, 1, 1));
		student.setAddress("1 The Road, London, UK");
		return student;
	}

	private static void store(Student student) {
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
}
