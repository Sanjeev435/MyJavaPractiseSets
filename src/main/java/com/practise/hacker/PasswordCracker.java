package com.practise.hacker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>Problem Type : Algorithm -> Recursion</b> </br>
 *         <b>Problem Difficulty : Medium</b></br>
 * @see <a href=
 *      "https://www.hackerrank.com/challenges/password-cracker/problem">
 *      Password Cracker </a>
 *
 */
public class PasswordCracker {

	public static void main(String[] args) {
		// abra ka dabra
		System.out.println(passwordCracker(Arrays.asList("abra", "ka", "dabra"), "abrakadabra"));

		// WRONG PASSWORD
		System.out.println(passwordCracker(Arrays.asList("ab", "ba"), "aba"));

		// ab cd
		System.out.println(passwordCracker(Arrays.asList("ab", "abcd", "cd"), "abcd"));

		// WRONG PASSWORD
		System.out.println(passwordCracker(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa",
				"aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"), "aaaaaaaaaab"));

		// we do what we must because we can
		System.out.println(passwordCracker(Arrays.asList("because", "can", "do", "must", "we", "what"),
				"wedowhatwemustbecausewecan"));
	}

	public static String passwordCracker(List<String> passwords, String loginAttempt) {
		Set<String> passWordDict = passwords.stream().collect(Collectors.toCollection(HashSet::new));

		Map<String, Boolean> occurenceChecker = new HashMap<>();

		StringBuffer data = new StringBuffer();
		if (!crackPassword(passWordDict, occurenceChecker, loginAttempt, data)) {
			return "WRONG PASSWORD";
		} else {
			return data.toString().trim();
		}
	}

	private static boolean crackPassword(Set<String> passWordDict, Map<String, Boolean> occurenceChecker,
			String loginAttempt, StringBuffer data) {
		if (loginAttempt.equals("") || loginAttempt == null) {
			return true;
		}
		
		if(occurenceChecker.containsKey(loginAttempt)) {
			return occurenceChecker.get(loginAttempt);
		}

		for (String pass : passWordDict) {
			if (loginAttempt.startsWith(pass) && crackPassword(passWordDict, occurenceChecker, loginAttempt.substring(pass.length()),
					data.append(" ").append(pass))) {
				occurenceChecker.put(loginAttempt, true);
				return true;
			}
		}

		occurenceChecker.put(loginAttempt, false);
		return false;
	}

	public static void passwordCracker1(List<String> passwords, String loginAttempt) {
		Set<String> dict = new HashSet<String>();
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		for (String p : passwords) {
			dict.add(p);
		}
		boolean res = dfs(loginAttempt, dict, "", map);
		if (!res) {
			System.out.println("WRONG PASSWORD");
		}
	}

	private static boolean dfs(String loginAttempt, Set<String> dict, String path, Map<String, Boolean> map) {

		if (loginAttempt == null || loginAttempt.length() == 0) {
			System.out.println(path.trim());
			return true;
		}
		if (map.containsKey(loginAttempt)) {
			return map.get(loginAttempt);
		}
		for (String word : dict) {
			if (!loginAttempt.startsWith(word))
				continue;
			if (dfs(loginAttempt.substring(word.length()), dict, path + word + " ", map)) {
				map.put(loginAttempt, true);
				return true;
			}
		}
		map.put(loginAttempt, false);
		return false;
	}
}