package com.practise.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class Test {

	public static void main(String args[]) throws UnsupportedOperationException {
		int A[] = {2, 3, 4, 1, 5 };

		List<Integer[]> dd = new ArrayList<>();
		
		System.out.println(minimumSwaps(A));


		System.out.println(dd.toString());

	}

	public static void numberJumbled() {
		int A = 0;
		int B = 3;

		if (A == 0 && B == 0) {
			return;
		}

		boolean isAGreThenB = A >= B ? true : false;
		StringBuilder sb = new StringBuilder();

		if (A == 0 || B == 0) {
			int count = A + B;
			while (count != 0) {
				if (sb.length() == 2) {
					break;
				}
				sb.append(isAGreThenB ? "a" : "b");
				count--;
			}
			System.out.println(sb.toString());

			return;
		}

		int upperIndex = A >= B ? A : B;
		int lowerIndex = B <= A ? B : A;

		AtomicInteger counter = new AtomicInteger(1);
		AtomicInteger counterOfLower = new AtomicInteger(0);
		AtomicInteger upper = new AtomicInteger(0);

		IntStream.rangeClosed(1, upperIndex + lowerIndex + 1).forEach(count -> {
			if (count % 3 == 0) {
				if (counterOfLower.get() < lowerIndex) {
					sb.append(isAGreThenB ? "b" : "a");
					counter.getAndIncrement();
					counterOfLower.getAndIncrement();
				} else if (counter.get() <= upperIndex + lowerIndex) {
					sb.append(isAGreThenB ? "a" : "b");
					counter.getAndIncrement();
					upper.getAndIncrement();
				}
			} else {
				if (upper.get() == upperIndex && upperIndex == lowerIndex && counterOfLower.get() < lowerIndex) {
					sb.append(isAGreThenB ? "b" : "a");
					counter.getAndIncrement();
					counterOfLower.getAndIncrement();
				} else if (counter.get() % 3 != 0 && counter.get() < upperIndex + lowerIndex) {
					sb.append(isAGreThenB ? "a" : "b");
					counter.getAndIncrement();
					upper.getAndIncrement();
				}
			}
		});

		System.out.println(sb.toString());
	}

	public static String reverseString(String input1) {
		String reverseInput = new String();
		try {
			String[] strArray = input1.split(" ");

			for (int i = strArray.length - 1; i >= 0; i--) {
				reverseInput += strArray[i];

				// to put spaces between letters
				if (i > 0) {
					reverseInput += " ";
				}
			}
		} catch (Exception ex) {
			throw new UnsupportedOperationException("reverseString(String input1)");
		}
		return reverseInput;
	}
	
    // Complete the minimumSwaps function below.
    public static int minimumSwaps(int[] arr) {
    	// int A[] = {7, 1, 3, 2, 4, 5, 6 };
    	int count = 0;
    	for(int i = 0; i < arr.length; i++) {
    		if(arr[i] != i+1) {
    			
    			int temp = arr[i];
    			
    			arr[i] = arr[arr[i]-1];
    			arr[temp-1] = temp;
    			
    			i--;
    			count++;
    		}
    		
    		System.out.println(Arrays.toString(arr));
    	}
    	return count;
    }

}
