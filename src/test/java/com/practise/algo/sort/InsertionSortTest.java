package com.practise.algo.sort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for InsertionSort
 * 
 * @author Sanjeev
 *
 */
public class InsertionSortTest {

	@Test
	public void insertionSortTestForInteger() {
		Integer[] testArray = { 45, 85, 36, 32, 6, 35, 68, 767, 46, 70, 26, 99, 257, 59 };
		InsertionSort<Integer> insertionSort = new InsertionSort<>(testArray);
		insertionSort.sort();

		Integer[] successArray = { 6, 26, 32, 35, 36, 45, 46, 59, 68, 70, 85, 99, 257, 767 };

		Assert.assertEquals(true, Arrays.equals(testArray, successArray));
	}

	@Test
	public void insertionSortTestForString() {
		String[] testArray = { "Mohan", "Kartik", "Zeus", "Luffy", "Zorro", "Franky", "Sanji", "Nami", "Usopp" };
		InsertionSort<String> insertionSort = new InsertionSort<>(testArray);
		insertionSort.sort();

		String[] successArray = { "Franky", "Kartik", "Luffy", "Mohan", "Nami", "Sanji", "Usopp", "Zeus", "Zorro" };

		Assert.assertEquals(true, Arrays.equals(testArray, successArray));
	}
}
