package com.practise.hacker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Sanjeev
</br> </br>
Given a <b>6 X 6</b> 2D Array, <b>arr</b>: </br>

1 1 1 0 0 0</br>
0 1 0 0 0 0</br>
1 1 1 0 0 0</br>
0 0 0 0 0 0</br>
0 0 0 0 0 0</br>
0 0 0 0 0 0</br>
We define an hourglass in <b>A</b> to be a subset of values with indices falling in this pattern in <b>arr</b>'s </br>
graphical representation:</br>

a b c</br>
  d</br>
e f g</br>
There are <b>16</b> hourglasses in <b>arr</b>, and an hourglass sum is the sum of an hourglass' values. Calculate the </br>
hourglass sum for every hourglass in <b>arr</b>, then print the maximum hourglass sum.</br>
</br>
For example, given the 2D array:</br>

-9 -9 -9  1 1 1 </br>
 0 -9  0  4 3 2 </br>
-9 -9 -9  1 2 3 </br>
 0  0  8  6 6 0 </br>
 0  0  0 -2 0 0 </br>
 0  0  1  2 4 0 </br>
We calculate the following <b>16</b> hourglass values: </br>

-63, -34, -9, 12, </br>
-10, 0, 28, 23,   </br>
-27, -11, -2, 10, </br>
9, 17, 25, 18     </br></br>
Our highest hourglass value is <b>28</b> from the hourglass: </br>

0 4 3 </br>
  1   </br>
8 6 6 </br>
</br>
<b>Note: </b>If you have already solved the Java domain's Java 2D Array challenge, you may wish to skip this challenge.</br>
</br>
<b>Function Description : </b></br>
--------------------------------------------------</br></br>
Complete the function hourglassSum in the editor below. It should return an integer, the maximum hourglass sum in the array.</br>
hourglassSum has the following parameter(s):</br>
arr: an array of integers </br></br>

<b>Input Format  : </b></br>
---------------------------------------</br>
Each of the <b>6</b> lines of inputs <b>arr[i]</b> contains <b>6</b> space-separated integers <b>arr[i][j]</b>.</br></br>

<b>Constraints : </b></br>
---------------------------------------</br>
<b>-9<=arr[i][j]<=9</b></br>
<b>0<=i,j<=5</b></br>
</br>
</br>
<b>Output Format : </b></br>
----------------------------------------</br>
Print the largest (maximum) hourglass sum found in <b>arr</b>.</br></br>

<b>Sample Input : </b></br>
----------------------------------------</br>
1 1 1 0 0 0 </br>
0 1 0 0 0 0 </br>
1 1 1 0 0 0 </br>
0 0 2 4 4 0 </br>
0 0 0 2 0 0 </br>
0 0 1 2 4 0 </br>

 </br> </br>
<b>Sample Output :  </b></br>
----------------------------------------</br>
19 </br> </br>
<b>Explanation :  </b></br>
----------------------------------------</br>
<b>arr</b> contains the following hourglasses : </br>


</br></br>
The hourglass with the maximum sum (<b>19</b>) is:</br>
2 4 4 </br>
  2   </br>
1 2 4 </br>

 *
 */
public class HourGlassSum {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0 }, { 0, 0, 2, 4, 4, 0 },
				{ 0, 0, 0, 2, 0, 0 }, { 0, 0, 1, 2, 4, 0 } };

		/*
		 * { {1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0,
		 * 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}}
		 */
		System.out.println("Highest HourGlass Sum : " + hourglassSum(matrix));
	}

	private static int hourglassSum(int[][] arr) {

		List<Integer> sums = new ArrayList<>();
		System.out.println(arr.length);
		if (arr.length > 3) {
			for (int i = 0; i < arr.length - 2; i++) {
				for (int j = 0; j < arr[i].length - 2; j++) {
					sums.add(arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j]
							+ arr[i + 2][j + 1] + arr[i + 2][j + 2]);
				}
			}
		}
		Collections.sort(sums, Collections.reverseOrder());
		return sums.get(0);
	}

}
