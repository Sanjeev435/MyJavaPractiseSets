package com.practise.test;

public class Test3 {
	
	public static void main(String[] args) {
		printWord();
		System.out.println("After printWord");
		
	}

	private static void printWord(){
		try {
			System.out.println("private");
		}finally {
			String ss = null;
			ss.trim();
			
			String kk = "";
			kk.trim();
		}
	}

}
