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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || !(obj instanceof Student)) {
			return false;
		} else {
			Student other = (Student) obj;
			return (id == other.id &&
					Objects.equals(name, other.name) &&
					Objects.equals(dob, other.dob) &&
					Objects.equals(courses, other.courses) &&
					Objects.equals(address, other.address));
		}
	}


	public int hashCode() {
		return 0;
	}
}
