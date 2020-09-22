package com.m3.m3s30.javaInfo;

import java.util.List;

public interface Storage {

	boolean store(Student s);

	boolean remove(Student s);

	List<Student> getAll();
}
