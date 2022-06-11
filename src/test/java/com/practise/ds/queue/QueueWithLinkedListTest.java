package com.practise.ds.queue;

import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Assert;
import org.junit.Test;

import com.practise.ds.queue.QueueWithLinkedList;

public class QueueWithLinkedListTest {
	@Test
	public void testStackApis() {
		LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

		Assert.assertTrue(queue.isEmpty());

		queue.add(5);
		queue.add(2);
		queue.add(9);
		queue.add(7);
		queue.add(1);
		queue.add(8);
		queue.add(4);
		queue.add(6);
		queue.add(3);

		Assert.assertFalse(queue.isEmpty());
		Assert.assertEquals(queue.size(), 9);

		Assert.assertTrue(queue.remove(2));
		Assert.assertEquals(queue.size(), 8);
		Assert.assertEquals(queue.toString(), "[5, 9, 7, 1, 8, 4, 6, 3]");

		Assert.assertEquals(queue.poll(), new Integer(5));
		Assert.assertEquals(queue.size(), 7);
		Assert.assertEquals(queue.toString(), "[9, 7, 1, 8, 4, 6, 3]");

		Assert.assertEquals(queue.peek(), new Integer(9));
		Assert.assertEquals(queue.size(), 7);
		Assert.assertEquals(queue.toString(), "[9, 7, 1, 8, 4, 6, 3]");

		// Custom stack
		QueueWithLinkedList customQueue = new QueueWithLinkedList();

		Assert.assertTrue(customQueue.isEmpty());

		customQueue.add(5);
		customQueue.add(2);
		customQueue.add(9);
		customQueue.add(7);
		customQueue.add(1);
		customQueue.add(8);
		customQueue.add(4);
		customQueue.add(6);
		customQueue.add(3);

		Assert.assertFalse(customQueue.isEmpty());
		Assert.assertEquals(customQueue.size(), 9);

		Assert.assertTrue(customQueue.remove(2));
		Assert.assertEquals(customQueue.size(), 8);
		Assert.assertEquals(customQueue.toString(), "[5, 9, 7, 1, 8, 4, 6, 3]");

		Assert.assertEquals(customQueue.poll(), 5);
		Assert.assertEquals(customQueue.size(), 7);
		Assert.assertEquals(customQueue.toString(), "[9, 7, 1, 8, 4, 6, 3]");

		Assert.assertEquals(customQueue.peek(), 9);
		Assert.assertEquals(customQueue.size(), 7);
		Assert.assertEquals(customQueue.toString(), "[9, 7, 1, 8, 4, 6, 3]");

	}

	@Test
	public void testPoll() {
		QueueWithLinkedList customQueue = new QueueWithLinkedList();

		Assert.assertTrue(customQueue.isEmpty());
		customQueue.add(0);

		Assert.assertEquals(customQueue.poll(), 0);
		Assert.assertEquals(customQueue.size(), 0);
		Assert.assertEquals(customQueue.toString(), "");

		customQueue.add(5);
		customQueue.add(8);

		Assert.assertEquals(customQueue.poll(), 5);
		Assert.assertEquals(customQueue.peek(), 8);
		Assert.assertEquals(customQueue.size(), 1);
		Assert.assertEquals(customQueue.toString(), "[8]");

		customQueue.add(4);
		customQueue.add(6);
		customQueue.add(3);
		Assert.assertEquals(customQueue.poll(), 8);
		Assert.assertEquals(customQueue.peek(), 4);
		Assert.assertEquals(customQueue.size(), 3);
		Assert.assertEquals(customQueue.toString(), "[4, 6, 3]");
	}

	@Test
	public void testRemove() {
		QueueWithLinkedList customQueue = new QueueWithLinkedList();

		Assert.assertTrue(customQueue.isEmpty());
		customQueue.add(0);

		Assert.assertTrue(customQueue.remove(0));
		Assert.assertEquals(customQueue.size(), 0);
		Assert.assertEquals(customQueue.toString(), "");

		customQueue.add(0);
		customQueue.add(5);

		Assert.assertTrue(customQueue.remove(0));
		Assert.assertEquals(customQueue.size(), 1);
		Assert.assertEquals(customQueue.peek(), 5);
		Assert.assertEquals(customQueue.toString(), "[5]");

		customQueue.add(4);
		customQueue.add(6);
		customQueue.add(3);

		Assert.assertTrue(customQueue.remove(6));
		Assert.assertEquals(customQueue.size(), 3);
		Assert.assertEquals(customQueue.peek(), 5);
		Assert.assertEquals(customQueue.toString(), "[5, 4, 3]");

		customQueue.add(9);

		Assert.assertTrue(customQueue.remove(5));
		Assert.assertEquals(customQueue.size(), 3);
		Assert.assertEquals(customQueue.peek(), 4);
		Assert.assertEquals(customQueue.toString(), "[4, 3, 9]");

		Assert.assertTrue(customQueue.remove(9));
		Assert.assertEquals(customQueue.size(), 2);
		Assert.assertEquals(customQueue.peek(), 4);
		Assert.assertEquals(customQueue.toString(), "[4, 3]");
		
		Assert.assertFalse(customQueue.remove(1));
		Assert.assertEquals(customQueue.size(), 2);
		Assert.assertEquals(customQueue.peek(), 4);
		Assert.assertEquals(customQueue.toString(), "[4, 3]");
	}
}
