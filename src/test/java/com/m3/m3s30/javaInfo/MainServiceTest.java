package com.m3.m3s30.javaInfo;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

class MainServiceTest {

	@Mock
	Storage storage;

	@BeforeAll
	public static void beforeAll() {
		System.out.println("beforeAll()");
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("afterAll()");
	}

	@BeforeEach
	void beforeEach() {
		System.out.println("beforeEach()");
		MockitoAnnotations.initMocks(this);
	}

	@AfterEach
	void tearDown() {
		System.out.println("tearDown()");
	}

	@Test
	void addStudent() {
		Student s = new Student(1, "pete", LocalDate.now());
		Mockito.when(storage.store(s)).thenReturn(true);

		MainService mainService = new MainService(storage);

		boolean result = mainService.addStudent(s);
		Assertions.assertTrue(result);

		Mockito.verify(storage, Mockito.times(2)).store(s);
	}

	@Test
	void removeStudent() {
		Mockito.when(storage.store(null)).thenReturn(false).thenReturn(true).thenThrow(new NullPointerException());
	}
}