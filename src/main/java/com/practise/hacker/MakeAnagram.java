package com.practise.hacker;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>Problem Type : String Manipulation</b> </br>
 *         <b>Problem Difficulty : Basic</b></br>
 * @see <a href=
 *      "https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings">
 *      Strings: Making Anagrams </a>
 *
 */
public class MakeAnagram {
	
	public static void main(String[] args) {
		// Solution : 2
		System.out.println(makeAnagram("cde", "dcf"));
		
		// Solution : 4
		System.out.println(makeAnagram("cde", "abc"));
		
		// Solution : 30
		System.out.println(makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
	}

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */
    public static int makeAnagram(String a, String b) {
    	String[] str1 = a.split("");
    	String[] str2 = b.split("");
    	
    	Map<String, Long> tempMap = Arrays.stream(str1).collect
    			(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    	
    	int count = 0;
    	for(String s : str2) {
    		if(tempMap.containsKey(s) && tempMap.get(s) != 0) {
    			count+=1;
    			tempMap.put(s, tempMap.get(s)-1);
    		}
    	}
    	
    	return (str1.length - count) + (str2.length - count);
    }
}
