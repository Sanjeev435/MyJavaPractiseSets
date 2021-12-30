package com.practise.hacker;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 
 * @author Sanjeev Kumar
 * 
 * </br></br><b>Problem Type : Dictionaries and Hashmaps</b>
 * </br><b>Problem Difficulty : Easy</b></br>
 * @see <a href="https://www.hackerrank.com/challenges/two-strings/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps">Two Strings Problem</a>
 *
 */
public class TwoStrings {
	private static final String YES = "Yes";
	private static final String NO = "No";

	public static void main(String[] args) {
		
		// Yes
		System.out.println(twoStrings("hello", "world"));
		
		//No
		System.out.println(twoStrings("hi", "world"));
	}
	
    /**
     * Complete the 'twoStrings' function below.
     *
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */
    private static String twoStrings(String s1, String s2) {
    	boolean isS1Greater = Integer.compare(s1.length(), s2.length()) > 0;
    	
    	Map<String, Long> data = Arrays.stream((isS1Greater ? s2 : s1).split(""))
    			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    	
		for(String s : (isS1Greater ? s1 : s2).split("")) {
			if(data.containsKey(s)) {
				return YES;
			}
		}
		
		return NO;

    }
}
