package com.practise.stack;

class Test {
	
	public static void main(String args[]) throws UnsupportedOperationException {
		/*for(int i=0; i<=10; i++) {
			System.out.println(i);
			
			System.out.println("OK");
		}*/
		
		String str = "My name is Sanjeev";
		System.out.println(reverseString(str));
		
		
		
	}
	
	public static String reverseString(String input1) {
		String reverseInput = new String();
		try {
			String[] strArray = input1.split(" ");
			
			for(int i = strArray.length-1; i >= 0; i--) {
				reverseInput+=strArray[i];
				
				//to put spaces between letters
				if(i > 0) {
					reverseInput+=" ";
				}
			}
		}catch(Exception ex) {
			throw new UnsupportedOperationException("reverseString(String input1)");
		}
		return reverseInput;
	}
	
	
}


