package com.practise.careercup.arraysandstrings;

import java.util.Arrays;

/**
 * 
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>Zero Matrix:</b> Write an algorithm such that if an element in an
 *         MxN matrix is 0, its entire row and column are set to 0.
 */
public class ZeroMatrix {
	
	public static void main(String[] args) {
		int[][] matrix = {{5, 9, 2}, {2, 8, 3}, {6, 7, 1}};
		System.out.println(Arrays.deepToString(getUpdatedMatrix(matrix)));
		
		int[][] matrix1 = {{5, 0, 2}, {2, 8, 3}, {8, 0, 0}};
		System.out.println(Arrays.deepToString(getUpdatedMatrix(matrix1)));
		
		int[][] matrix2 = {{5, 0, 2}, {2, 0, 3}, {6, 4, 1}};
		System.out.println(Arrays.deepToString(getUpdatedMatrix(matrix2)));
		
		int[][] matrix3 = {{0, 9, 2}, {2, 0, 3}, {6, 1, 0}};
		System.out.println(Arrays.deepToString(getUpdatedMatrix(matrix3)));
		
		int[][] matrix4 = {{4, 9, 2}, {2, 5, 0}};
		System.out.println(Arrays.deepToString(getUpdatedMatrix(matrix4)));
	}

	private static int[][] getUpdatedMatrix(int[][] matrix) {
		boolean[] row = new boolean[3];
		boolean[] column = new boolean[3];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		for(int i = 0; i < matrix.length; i++) {
			if(row[i]) {
				nullifyRow(matrix, i);
			}
		}
		
		for(int j = 0; j < matrix[0].length; j++) {
			if(column[j]) {
				nullifyColumn(matrix, j);
			}
		}
		
		return matrix;
	}

	private static void nullifyRow(int[][] matrix, int i) {
		for(int j = 0; j < matrix[0].length; j++) {
			matrix[i][j] = 0;
		}
		
	}
	
	private static void nullifyColumn(int[][] matrix, int j) {
		for(int i = 0; i < matrix.length; i++) {
			matrix[i][j] = 0;
		}
		
	}

}
