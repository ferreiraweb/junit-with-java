package br.com.erudio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SimpleMathTest2 {

	SimpleMath math;

	@BeforeEach
	void beforeEachMethod() {
		math = new SimpleMath();
	}

	@AfterEach
	void afterEachMethos() {
	}

	@ParameterizedTest
	@CsvSource({ "6.2, 2, 3.1", "71, 14, 5.07", "18.3, 3.1, 5.90" })
	void deve_dividir_dois_numeros_corretamente(double firstNumber, double secondNumber) {

		// final double firstNumber = 8.2D;
		// final double secondNumber = 2D;

		final double actual = math.division(firstNumber, secondNumber);
		final double expected = firstNumber / secondNumber;

		assertEquals(expected, actual, 2D);

	}

	// @Disabled("TODO: We need still work on it!")
	@Test
	void deve_lancar_exception_em_divisao_por_zero() {

		final double firstNumber = 8.2D;
		final double secondNumber = 0;

		/*
		 * assertThrows(ArithmeticException.class, () -> { math.division(firstNumber,
		 * secondNumber); });
		 */

		String expectedMessage = "Divisao por zero!";

		ArithmeticException actual = assertThrows(ArithmeticException.class, () -> {
			math.division(firstNumber, secondNumber);
		}, () -> "Division by zero");

		assertEquals(expectedMessage, actual.getMessage(), () -> "Unexpected exception message!");

	}

}
