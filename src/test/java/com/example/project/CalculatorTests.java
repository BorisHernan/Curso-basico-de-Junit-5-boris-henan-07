/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {

	static Calculator calculator;


	@BeforeAll
	static void beforeAll1(){
		calculator= new Calculator();
	}

	@BeforeAll
	static void beforeAll(){
		System.out.println("Antes de la clase");
	}

	@BeforeEach
	void beforeEach(){
		System.out.println("Antes de cada Metódo");
	}

	@Disabled("Se desactivo para correguir un  error y cambiar el 3 de la suma a 1")
	@Test
	@DisplayName("1 + 1 = 2")
	void addsTwoNumbers() {
//		calculator= new Calculator(); se hace antes de todas las ecuaciones

		assertEquals(2, calculator.add(3, 1), "1 + 1 should equal 2");
	}

	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101"
	})
	void add(int first, int second, int expectedResult) {
		assertEquals(expectedResult, calculator.add(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}

	@Test
	void isTrue(){
		assertTrue(calculator.isTrue());
	}
	@AfterEach
	void afterEach(){
		System.out.println("Despues de cada Metódo");
	}


	@AfterAll
	static void afterAll(){
		System.out.println("Despues de todos los metódos de la clase");
	}
}
