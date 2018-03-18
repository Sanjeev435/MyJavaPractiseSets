package com.practise.test;
import java.util.HashMap;
import java.util.Map;

public class Test4 {
	
	public static void main(String[] args) throws Exception {
		String a = "it (has) n numb(er) of (act)io(n)s.";
		
		System.out.println(getPosition(a,3));
		
	}
	
	
	private static Integer getPosition(String aSampleString, int toBeSearchedIndex) {
		int count=0;
		int count1= 0;
		
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(Character c : aSampleString.toCharArray()) {
			
			if(c.toString().equals("(")) {
				map.put(count, c.toString());
				count1++;
			}
			else if(c.toString().equals(")")) {
				if(map.size() ==1) {
					if(count1 == toBeSearchedIndex) {
						count1 =  count;
						map.clear();
					}else map.clear();
				}else return -1;
			}
			 
			count++;
		}
		
		if(map.size() ==1) {
			return -1;
		}
		else return count1;
	}

}
