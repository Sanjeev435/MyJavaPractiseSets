package com.practise.algo.problems;

import org.junit.Assert;
import org.junit.Test;

public class AlgoProblemsTest {
	
	AlgoProblems algoProblems = new AlgoProblems();
	
	@Test
	public void testCheckIfSumExist() {
		Assert.assertTrue(algoProblems.checkIfSumExist(new int[] { 1, 6, 3, 7, 9, 4 }, 15));
		Assert.assertFalse(algoProblems.checkIfSumExist(new int[] { 1, 6, 3, 5, 4, 8 }, 15));
	}

}
