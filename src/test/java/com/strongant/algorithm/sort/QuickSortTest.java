package com.strongant.algorithm.sort;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.*;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class QuickSortTest {

	private int[] numbers;
	private final static int SIZE = 7;
	private final static int MAX = 20;

	@BeforeMethod
	public void setUp() throws Exception {
		numbers = new int[SIZE];
		Random generator = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = generator.nextInt(MAX);
		}
	}

	@Test
	public void testNull() {
		QuickSort sorter = new QuickSort();
		sorter.sort(null);
	}

	@Test
	public void testEmpty() {
		QuickSort sorter = new QuickSort();
		sorter.sort(new int[0]);
	}

	@Test
	public void testSimpleElement() {
		QuickSort sorter = new QuickSort();
		int[] test = new int[1];
		test[0] = 5;
		sorter.sort(test);
	}

	@Test
	public void testSpecial() throws Exception {
		QuickSort sorter = new QuickSort();
		int[] test = {5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5};
		sorter.sort(test);
		if (!validate(test)) {
			fail("Should not happen");
		}
		printResult(test);
	}

	@Test
	public void testQuickSort() {
		for (Integer i : numbers) {
			System.out.println(i + "  ");
		}

		long startTime = System.currentTimeMillis();

		QuickSort sorter = new QuickSort();
		sorter.sort(numbers);

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("QuickSort : " + elapsedTime);

		if (!validate(numbers)) {
			fail("Should not happen");
		}

		assertTrue(true);
		printResult(numbers);
	}

	@Test
	public void testStandardSort() {
		long startTime = System.currentTimeMillis();
		Arrays.sort(numbers);
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Standard Java sort: " + elapsedTime);
		if (!validate(numbers)) {
			fail("Should not happen");
		}

		assertTrue(true);
		printResult(numbers);
	}

	private boolean validate(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] > numbers[i + 1]) {
				return false;
			}
		}
		return true;
	}

	private void printResult(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + "  ");
		}
		System.out.println();
	}

}