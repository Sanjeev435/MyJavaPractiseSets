package com.practise.hacker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>Problem Type : Algorithm</b> </br>
 *         <b>Difficulty : Medium</b></br>
 *         <b>Problem Solving : Basic</b></br>
 * 
 * @see <a href= "https://www.hackerrank.com/challenges/bomber-man/problem"> The
 *      Bomberman Game </a>
 *
 */
public class BomberMan {

	public static void main(String[] args) {
		
		Arrays.asList(".......","...O...", "....O..", ".......", "OO.....", "OO.....");
		System.out.println(bomberMan(4, 
				new ArrayList<>(Arrays.asList(".......","...O...", "....O..", ".......", "OO.....", "OO....."))));

	}

	/**
	 * Complete the 'bomberMan' function below.
	 *
	 * The function is expected to return a STRING_ARRAY. 
	 * The function accepts following parameters: 1. INTEGER n 2. STRING_ARRAY grid
	 */
	public static List<String> bomberMan(int n, List<String> grid) {
		
		if(n == 2 || n%4 == 0) {
			for(int i = 0; i < grid.size(); i++) {
				grid.set(i, grid.get(i).replaceAll(".", "O"));
			}
		}else {
			
		}

		return grid;
	}

}
