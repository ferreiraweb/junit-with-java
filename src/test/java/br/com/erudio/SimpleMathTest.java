package br.com.erudio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SimpleMathTest {

	SimpleMath math;

	@BeforeAll
	static void setup() {
		System.out.println("(: Running @BeforeAll");
	}

	@AfterAll
	static void cleanup() {
		System.out.println(" Running @AfterAll method! :)");
	}

	@BeforeEach
	void beforeEachMethod() {
		math = new SimpleMath();
		System.out.println("Running @BeforeEach method!");
	}
	
	@AfterEach
	void afterEachMethos() {
		System.out.println("Running @AfterEach method!");
	}
	

	@RepeatedTest(3)
	void deve_somar_dois_numeros_corretamente(RepetitionInfo repetitionInfo) {

		System.out.println(" 1. deve_somar_dois_numeros_corretamente() " + repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());

		// Given
		final double firstNumber = 8.2D;
		final double secondNumber = 6D;

		final double expected = firstNumber + secondNumber;
		String msgWhenError = String.format("): A soma de %s + %s nao gerou o resultado esperado: %s", firstNumber,
				secondNumber, expected);

		// When
		final double actual = math.sum(firstNumber, secondNumber);

		// Then
		assertEquals(expected, actual, () -> msgWhenError);
	}

	@Test
	void deve_subtrair_dois_numeros_corretamente() {

		System.out.println(" 2. deve_subtrair_dois_numeros_corretamente()");

		final double firstNumber = 8.2D;
		final double secondNumber = 6D;

		final double actual = math.subtraction(firstNumber, secondNumber);
		final double expected = firstNumber - secondNumber;

		String msgWhenError = String.format("A subtracao de %a - %b nao gerou o resultado esperado: %s", firstNumber,
				secondNumber, expected);

		assertEquals(expected, actual, () -> msgWhenError);

	}

	@Test
	void deve_multiplicar_dois_numeros_corretamente() {

		System.out.println(" 3. deve_multiplicar_dois_numeros_corretamente()");
		final double firstNumber = 8.2D;
		final double secondNumber = 6D;

		final double actual = math.multiplication(firstNumber, secondNumber);
		final double expected = firstNumber * secondNumber;

		String msgWhenError = String.format("A multiplicacao de %s * %s nao gerou o resultado esperado: %s",
				firstNumber, secondNumber, expected);

		assertEquals(expected, actual, () -> msgWhenError);

	}

	//@Disabled("TODO: We need still work on it!")
	@Test
	void deve_lancar_exception_em_divisao_por_zero() {

		final double firstNumber = 8.2D;
		final double secondNumber = 0;

		
		/*
		assertThrows(ArithmeticException.class, () -> { 
			math.division(firstNumber, secondNumber);
		});
		*/
		
		String expectedMessage = "Divisao por zero!";
		
		ArithmeticException actual = assertThrows(ArithmeticException.class, () -> {
			math.division(firstNumber, secondNumber);
		}, () -> "Division by zero");
		
		
		assertEquals(expectedMessage, actual.getMessage(), () -> "Unexpected exception message!");
		
		
		
		
	}

}
