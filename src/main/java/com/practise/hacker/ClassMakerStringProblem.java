package com.practise.hacker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClassMakerStringProblem {

	public static void main(String[] args) {
		System.out.println("String was 'aabcccdee' and answer comes as "
				+ removeDuplicates("aabcccdee"));
		System.out.println("String was 'abcdeedcbfgf' and answer comes as "
				+ removeDuplicates("abcdeedcbfgf"));
		System.out.println("String was 'abbabba' and answer comes as "
				+ removeDuplicates("abbabba"));

	}

	private static String removeDuplicates(String aInputStr) {

		List<String> stringList = Arrays.asList(aInputStr.split(""));
		Set<Integer> aIndexList = new HashSet<Integer>();
		boolean matchedFound = true;

		while (matchedFound) {
			boolean isFirstRun = true;
			int count = 0;
			String strTemp = "";
			
			for (String aString : stringList) {

				if (isFirstRun) {
					strTemp = aString;
					isFirstRun = false;
				} else if (strTemp.equals(aString)) {
					aIndexList.add(count - 1);
					aIndexList.add(count);
				} else if (!strTemp.equals(aString)) {
					if (aIndexList.size() > 0) {
						break;
					} else if (count == (stringList.size() - 1)) {
						matchedFound = false;
						break;
					} else
						strTemp = aString;
				}
				count++;
			}

			if (!matchedFound) {
				break;
			} else {
				int index = 0;
				List<String> stringTempList = new ArrayList<String>();
				for (String a : stringList) {
					if (!aIndexList.contains(index))
						stringTempList.add(a);
					index++;
				}
				stringList = null;
				aIndexList = new HashSet<Integer>();
				stringList = stringTempList;
				if (stringList.size() <= 1) {
					break;
				}
			}
		}
		String answer = stringList.toString().replace(",", "").toString()
				.replace("[", "").replace("]", "");

		System.out.println("Final String : " + answer);
		return answer;

	}
}
