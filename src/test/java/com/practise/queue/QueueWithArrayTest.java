package com.practise.queue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class QueueWithArrayTest {

	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	
	@Test
	public void testForExceptionInRemove() {
		thrown.expect(IllegalAccessError.class);
        thrown.expectMessage("Queue is Empty !!");
		
        Queue<Integer> queue = new QueueWithArray<Integer>(10);
        queue.remove();
	}
	
	
/*	Queue theQueue = new Queue(5); // queue holds 5 items
	theQueue.insert(10); // insert 4 items
	theQueue.insert(20);
	theQueue.insert(30);
	theQueue.insert(40);
	theQueue.remove(); // remove 3 items
	theQueue.remove(); // (10, 20, 30)
	theQueue.remove();
	theQueue.insert(50); // insert 4 more items
	theQueue.insert(60); // (wraps around)
	theQueue.insert(70);
	theQueue.insert(80);
	while( !theQueue.isEmpty() ) // remove and display
	{ // all items
		long n = theQueue.remove(); // (40, 50, 60, 70, 80)
		System.out.print(n);
		System.out.print(“ “);
		}
		System.out.println(“”);
		} // end main()
		} // end class QueueApp
	}*/
}
