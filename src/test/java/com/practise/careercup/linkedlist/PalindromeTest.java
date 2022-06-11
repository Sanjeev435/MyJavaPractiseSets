package com.practise.careercup.linkedlist;

import org.junit.Assert;
import org.junit.Test;


public class PalindromeTest {
	
	@Test
	public void checkIfListPalindrome() {
		Palindrome palindrome = new Palindrome();
		palindrome.add(0);
		palindrome.add(1);
		palindrome.add(2);
		palindrome.add(1);
		palindrome.add(0);
		
		Assert.assertTrue(palindrome.isPalindromeUsingReverseApproch(palindrome.head));
		Assert.assertTrue(palindrome.isPalindromeUsingIterativeApproch(palindrome.head));
		
		palindrome = new Palindrome();
		palindrome.add(0);
		palindrome.add(1);
		palindrome.add(2);
		palindrome.add(1);
		palindrome.add(1);
		Assert.assertFalse(palindrome.isPalindromeUsingReverseApproch(palindrome.head));
		Assert.assertFalse(palindrome.isPalindromeUsingIterativeApproch(palindrome.head));
		
		palindrome = new Palindrome();
		palindrome.add(0);
		palindrome.add(1);
		palindrome.add(0);
		Assert.assertTrue(palindrome.isPalindromeUsingReverseApproch(palindrome.head));
		Assert.assertTrue(palindrome.isPalindromeUsingIterativeApproch(palindrome.head));
		
		
	}

}
