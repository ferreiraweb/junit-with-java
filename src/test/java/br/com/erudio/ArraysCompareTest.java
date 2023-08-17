package br.com.erudio;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.*;

class ArraysCompareTest {

	
	@Test
	@Timeout(1)
	void test() throws InterruptedException {
		int[] numbers = {25, 8, 21, 32 , 3};
		int[] expectedArray = {3, 8, 21, 25, 32};
		
		Thread.sleep(2000);
		
		Arrays.sort(numbers);
		
		//assertArrayEquals(numbers, expectedArray);
		
		
		
		
	}

}
