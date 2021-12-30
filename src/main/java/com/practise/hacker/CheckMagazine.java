package com.practise.hacker;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 
 * @author Sanjeev Kumar
 * 
 * </br></br><b>Problem Type : Dictionaries and Hashmaps</b>
 * </br><b>Problem Difficulty : Easy</b></br>
 * @see <a href="https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=dictionaries-hashmaps">Ransom Note Problem</a>
 *
 */
public class CheckMagazine {
	private static final String YES = "Yes";
	private static final String NO = "No";

	public static void main(String[] args) {

		// Yes
		// List<String> magazine = Arrays.asList("give", "me", "one", "grand", "today",
		// "night");
		// List<String> note = Arrays.asList("give", "one","grand", "today");

		// No
		List<String> magazine = Arrays.asList("two", "times", "three", "is", "not", "four");
		List<String> note = Arrays.asList("two", "times", "two", "is", "four");

		System.out.println(checkMagazine(magazine, note));
	}

	/*
	 * The function accepts following parameters: 1. STRING_ARRAY magazine 2.
	 * STRING_ARRAY note
	 */
	private static String checkMagazine(List<String> magazine, List<String> note) {

		if (note.size() > magazine.size()) {
			return NO;
		} else {
			Map<String, Long> magazineDict = magazine.stream()
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

			for (String noteWord : note) {
				if (magazineDict.containsKey(noteWord) && magazineDict.get(noteWord) >= 1) {
					magazineDict.put(noteWord, magazineDict.get(noteWord) - 1L);
				} else {
					return NO;
				}
			}
			return YES;
		}
	}

}
