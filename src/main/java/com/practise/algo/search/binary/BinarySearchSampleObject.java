package com.practise.algo.search.binary;

import java.util.Arrays;

public class BinarySearchSampleObject {
	
	BinarySearchSampleObject a = new BinarySearchSampleObject();

	public static int[] getIntArray() {
		int[] aIntArray = { 45, 85, 36, 32, 6, 35, 68, 767, 46, 70, 26, 99,
				257, 59 };
		Arrays.sort(aIntArray);
		return aIntArray;
	}

	public static String[] getStringArray() {
		String[] aStringArray = { "Ram", "Shayam", "Mohan", "Zakir", "Ramu",
				"Rohit", "Hari", "Pankaj", "Kabir", "Anand" };
		Arrays.sort(aStringArray);
		return aStringArray;
	}

	public static BinarySearchSampleDTO[] getClassObjArray() {
		BinarySearchSampleDTO[] binarySearchSampleDTO = {new BinarySearchSampleDTO("Ram","Naik",685),
				new BinarySearchSampleDTO("Rohit","Sinha",577),
				new BinarySearchSampleDTO("Sanjeev","Kumar",374),
				new BinarySearchSampleDTO("Amit","Verma",948),
				new BinarySearchSampleDTO("Raj","Kundur",496),
				new BinarySearchSampleDTO("Sumit","Mahato",854),
				new BinarySearchSampleDTO("Jakey","Sharma",764)};
		Arrays.sort(binarySearchSampleDTO);
		return binarySearchSampleDTO;
	}

	static class BinarySearchSampleDTO implements Comparable<BinarySearchSampleDTO> {
		String empFirstName;
		String emplastName;
		int id;

		public int compareTo(BinarySearchSampleDTO a) {
			return this.empFirstName.compareTo(a.empFirstName);
		}

		public BinarySearchSampleDTO(String empFirstName, String emplastName, int id) {
			this.empFirstName = empFirstName;
			this.emplastName = emplastName;
			this.id = id;
		}

		/**
		 * @return the empFirstName
		 */
		public String getEmpFirstName() {
			return empFirstName;
		}

		/**
		 * @param empFirstName the empFirstName to set
		 */
		public void setEmpFirstName(String empFirstName) {
			this.empFirstName = empFirstName;
		}

		/**
		 * @return the emplastName
		 */
		public String getEmplastName() {
			return emplastName;
		}

		/**
		 * @param emplastName the emplastName to set
		 */
		public void setEmplastName(String emplastName) {
			this.emplastName = emplastName;
		}

		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}

	}
}
