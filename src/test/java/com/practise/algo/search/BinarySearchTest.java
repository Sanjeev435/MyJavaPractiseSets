package com.practise.algo.search;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.practise.algo.search.binary.BinarySearchIterative;
import com.practise.algo.sort.BubbleSort;
import com.practise.algo.sort.HeapSort;
import com.practise.algo.sort.QuickSort;
import com.practise.dto.SampleDTO;

public class BinarySearchTest {
	
	@Test
	public void testIterativeBinarySearch() {
		// Integer Search
		Integer [] testArray = { 45, 85, 36, 32, 6, 35, 68, 767, 46, 70, 26, 99, 257, 59 };
		BubbleSort<Integer> bubbleSort = new BubbleSort<>(testArray);
		bubbleSort.sort();
		
		Integer [] successArray = { 6, 26, 32, 35, 36, 45, 46, 59, 68, 70, 85, 99, 257, 767};
		
		Assert.assertEquals(true, Arrays.equals(testArray, successArray));
		
		BinarySearchIterative<Integer> binarySearch = new BinarySearchIterative<>(testArray);
		Assert.assertTrue(binarySearch.search(26));
		Assert.assertFalse(binarySearch.search(288));
		
		
		// String Search
		String[] stringArray = { "Ram", "Shayam", "Mohan", "Zakir", "Ramu",
				"Rohit", "Hari", "Pankaj", "Kabir", "Anand" };
		QuickSort<String> quickSort = new QuickSort<>(stringArray);
		quickSort.sort();

		String[] successStrArray = {"Anand", "Hari", "Kabir", "Mohan", "Pankaj",
				"Ram", "Ramu", "Rohit", "Shayam", "Zakir"};
		Assert.assertEquals(true, Arrays.equals(stringArray, successStrArray));
		
		BinarySearchIterative<String> binarySearch1 = new BinarySearchIterative<>(stringArray);
		Assert.assertTrue(binarySearch1.search("Kabir"));
		Assert.assertFalse(binarySearch1.search("Sohan"));
		
		
		// Class Object Search
		SampleDTO[] sampleArray = getClassObjArray();
		HeapSort<SampleDTO> heapSort = new HeapSort<>(sampleArray);
		heapSort.sort();
		Assert.assertTrue(sampleArray[0].getEmpFirstName().equals("Amit"));
		Assert.assertTrue(sampleArray[2].getEmpFirstName().equals("Raj"));
		Assert.assertTrue(sampleArray[4].getEmpFirstName().equals("Rohit"));
		Assert.assertTrue(sampleArray[6].getEmpFirstName().equals("Sumit"));
		
		BinarySearchIterative<SampleDTO> binarySearch2 = new BinarySearchIterative<>(sampleArray);
		Assert.assertTrue(binarySearch2.search(new SampleDTO("Rohit","Sinha",577)));
		Assert.assertFalse(binarySearch2.search(new SampleDTO("Sohan","Sinha",577)));
	}
	
	public static SampleDTO[] getClassObjArray() {
		SampleDTO[] sampleDTO = {new SampleDTO("Ram","Naik",685),
				new SampleDTO("Rohit","Sinha",577),
				new SampleDTO("Sanjeev","Kumar",374),
				new SampleDTO("Amit","Verma",948),
				new SampleDTO("Raj","Kundur",496),
				new SampleDTO("Sumit","Mahato",854),
				new SampleDTO("Jakey","Sharma",764)};
		Arrays.sort(sampleDTO);
		return sampleDTO;
	}
}
