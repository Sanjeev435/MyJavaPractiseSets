package com.practise.test;

public class Test2 extends com.practise.algo.search.binary.Test3{
	
	public static void main(String[] args) {
		com.practise.algo.search.binary.Test3 assshh  = new com.practise.algo.search.binary.Test3();
		
		String s = "Welcome";
		String s1 = new String("Sanjeev");
		String s3 = s+s1;
		System.out.println(s1);
		System.out.println(s3);
		
		s="Welcome 1";
		s1 = "Mak";
		
		s3 = s+s1;
		System.out.println(s3);
		
	//	printWord1();
		printWord2();
		printWord3();
		System.out.println("---------------------------------");
	//	assshh.printWord1();
		assshh.printWord2();
		assshh.printWord3();
	}
}
