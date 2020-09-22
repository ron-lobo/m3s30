package com.m3.m3s30.javaInfo;

public class MainService {

	private Storage storage;

	public MainService(Storage storage) {
		this.storage = storage;
	}

	public boolean addStudent(Student s) {
		boolean checkOk = checkOk(s, 0, -1, true);

		boolean result = false;
		if (checkOk) {
			result = storage.store(s);
		}
		return result;
	}

	public int removeStudent(Student s) {
		return -1;
	}

	private boolean checkOk(Student s, int i, int j, boolean b) {
		return true;
	}
}
