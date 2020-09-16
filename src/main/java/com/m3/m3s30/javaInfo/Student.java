package com.m3.m3s30.javaInfo;

import java.time.LocalDate;
import java.util.*;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return id == student.id &&
				Objects.equals(name, student.name) &&
				Objects.equals(dob, student.dob) &&
				Objects.equals(courses, student.courses) &&
				Objects.equals(address, student.address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, dob, courses, address);
	}
}
