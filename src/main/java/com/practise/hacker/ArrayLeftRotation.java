package com.practise.hacker;

import java.util.Arrays;

public class ArrayLeftRotation {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int rotations = 4;
		System.out.println("Array " + Arrays.toString(arr) + " after " + rotations + " left rotation is : "
				+ Arrays.toString(arrayLeftRotation(arr, rotations)));
	}

	private static int[] arrayLeftRotation(int[] arr, int rotations) {

		for (int i = 0; i < rotations; i++) {
			int firstIndex = arr[0];
			for (int j = 0; j < arr.length - 1; j++) {
				arr[j] = arr[j + 1];
			}
			arr[arr.length - 1] = firstIndex;
		}
		return arr;
	}
}
