package com.practise.hacker;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.practise.patterns.creational.singleton.Singleton;

/**
 * 
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>Problem Solving</b> </br>
 *         <b>Problem Difficulty : Intermediate</b></br>
 * @see <a href=
 *      "https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=dictionaries-hashmaps">Ransom
 *      Note Problem</a>
 *
 */
public class QueensAttack {

	public static void main(String[] args) {
		
		  System.out.println(queensAttack(4, 0, 4, 4, null));
		  
		  
		  System.out.println( queensAttack(5, 3, 4, 3, Arrays.asList(Arrays.asList(5,
		  5), Arrays.asList(4, 2), Arrays.asList(2, 3))));
		 
		  
			
			  System.out.println( queensAttack(8, 1, 4, 4, Arrays.asList(Arrays.asList(3,
			  5))));
			 
		 

	}

	public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
		Map<List<Integer>, List<Integer>>  obstaclesMap = obstacles != null
				? obstacles.stream().collect(Collectors.toMap(value -> value, value -> value))
						: null;
		
		int attackPoints = 0;
		for (int i = 1; i < 4; i++) {
			attackPoints = getOrientation(n, k, r_q, c_q, i, attackPoints, obstaclesMap);
		}
		return attackPoints;
	}

	private static int getOrientation(int n, int k, int r_q, int c_q, int num, int attackPoints,
			Map<List<Integer>, List<Integer>> obstaclesMap) {
		switch (num) {
		case 1: {
			// Vertical
			int limit = 0;
			int startPoint = r_q - 1;

			boolean down = true;
			for (int i = startPoint; i >= limit; i--) {
				if (Math.abs(i) > n) {
					break;
				}
				if (!isObstacleFound(Math.abs(i), c_q, n, k, obstaclesMap)) {
					attackPoints += 1;
				} else {
					if (down) {
						limit = -(n + 1);
						i = -(r_q);
					} else {
						break;
					}
				}
			}
		}
			break;
		case 2: {
			// Horizontal
			int limit = 0;
			int startPoint = c_q - 1;

			boolean left = true;
			for (int i = startPoint; i >= limit; i--) {
				if (Math.abs(i) > n) {
					break;
				}
				if (!isObstacleFound(r_q, Math.abs(i), n, k, obstaclesMap)) {
					attackPoints += 1;
				} else {
					if (left) {
						limit = -(n + 1);
						i = -(c_q);
					} else {
						break;
					}
				}
			}

		}
			break;
		case 3: {
			// Diagonal
			int limit = ((n-r_q) + 1);
			boolean firstDone = false;
			int orientation = 1;
			
			boolean rightObstacleFound = false;
			boolean leftObstacleFound = false;
			for(int i = 1; i <= limit; i++) {
				boolean limitPassed = !firstDone ? i+r_q > n : (r_q-i) == 0;
				
				if(!limitPassed && (!rightObstacleFound || !leftObstacleFound)) {
					if (!leftObstacleFound) {
						if(!isObstacleFound((r_q + (i*orientation)), (c_q + (i*orientation)), n, k, obstaclesMap)) {
							attackPoints += 1;
						}else {
							leftObstacleFound = true;
						}
					}
					
					if (!rightObstacleFound) {
						if(!isObstacleFound((r_q + (i*orientation)), (c_q - (i*orientation)), n, k, obstaclesMap)) {
							attackPoints += 1;
						}else {
							rightObstacleFound = true;
						}
					}
					
				}else {
					if(!firstDone) {
						firstDone = true;
						limit = (r_q - 1);
						i = 0;
						rightObstacleFound = false;
						leftObstacleFound = false;
						orientation = -1;
					}else {
						break;
					}
				}
			}

		}
			break;
		default:
			System.out.println("Invalid option found.");

		}

		return attackPoints;
	}

	private static boolean isObstacleFound(int x, int y, int sizeOfChess,
			int numOfObs, Map<List<Integer>, List<Integer>> obstaclesMap) {
		if((x == 0 || x > sizeOfChess) || (y == 0 || y > sizeOfChess)) {
			return true;
		}
		return numOfObs != 0 ? obstaclesMap.containsKey(Arrays.asList(x, y)) : false;
	}
}
