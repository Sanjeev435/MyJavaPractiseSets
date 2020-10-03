package com.practise.hacker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Sanjeev
 * </br></br>
 Emma is playing a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads 
 and others are cumulus. She can jump on any cumulus cloud having a number that is equal to the number of the current 
 cloud plus <b>1</b> or <b>2</b>. She must avoid the thunderheads. Determine the minimum number of jumps it will take 
 Emma to jump from her starting postion to the last cloud. It is always possible to win the game.
</br>
For each game, Emma will get an array of clouds numbered <b>0</b> if they are safe or <b>1</b> if they must be avoided. 
For example, <b>c=[0,1,0,0,0,1,0]</b> indexed from <b>0...6</b>. The number on each cloud is its index in the list so 
she must avoid the clouds at indexes <b>1</b> and <b>5</b>. She could follow the following two paths: <b>0->2->4->6</b> 
or <b>0->2->3->4->6</b>. The first path takes <b>3</b> jumps while the second takes <b>4</b>.
</br></br>
<b>Function Description:</b></br>
---------------------------------------------</br>
Complete the jumpingOnClouds function in the editor below. It should return the minimum number of jumps required, 
as an integer.
</br></br>
<b>jumpingOnClouds has the following parameter(s):</b></br>
----------------------------------------------------------------</br>
c: an array of binary integers
</br></br>
<b>Input Format</b></br>
----------------------------------------</br>
The first line contains an integer <b>n</b>, the total number of clouds. The second line contains <b>n</b> space-separated 
binary integers describing clouds <b>c[i]</b> where <b>0<=i<n</b>.
</br></br>
<b>Constraints : </b></br>
-------------------------------------</br>
<b>2<=n<=100</b></br>
<b>c[i] E {0,1}</b></br>
<b>c[0] = c[n-1]=0</b></br>
</br>
<b>Output Format : </b>
</br>
-----------------------------------
</br>
Print the minimum number of jumps needed to win the game.
</br>
<b>Sample Input : </b>
7
0 0 1 0 0 1 0
</br>
<b>Sample Output :</b>
4
</br>
<b>Explanation : </b>
Emma must avoid <b>c[2]</b> and <b>c[5]</b>. She can win the game with a minimum of <b>4</b> jumps:
</br>
----------------------------------------------------
</br>
<b>Sample Input </b>
6
0 0 0 0 1 0
</br>
<b>Sample Output </b>
3
</br>
<b>Explanation : </b>
The only thundercloud to avoid is <b>c[4]</b>. Emma can win the game in  <b>3</b> jumps:

 *
 */
public class JumpingOnClouds {

	public static void main(String[] args) {
		int[] jumps = { 0, 0, 1, 0, 0, 1, 0 };
		int[] jumps1 = { 0, 0, 0, 0, 1, 0 };
		List<int[]> clouds = Arrays.asList(jumps, jumps1);
		clouds.stream().forEach(c -> System.out.println("Number of Jumps required : " + jumpingOnClouds(c)));
	}

	private static int jumpingOnClouds(int[] c) {

		List<Integer> jumps = new ArrayList<>();

		for (int i = 0; i < c.length; i++) {

			if (c[i] == 0) {
				if (i == 0) {
					jumps.add(i);
				} else {
					if (c[i - 1] == 1) {
						jumps.add(i);
					} else if (i >= 2 && c[i - 1] == 0 && c[i - 2] == 0) {
						if (i <= jumps.get(jumps.size() - 2) + 2) {
							jumps.remove(jumps.size() - 1);
						}
						jumps.add(i);
					} else {
						jumps.add(i);
					}
				}
			}
		}
		return jumps.size() - 1;
	}

}
