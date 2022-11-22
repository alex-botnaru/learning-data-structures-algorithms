package com.abotnaru.problems.neetcode.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MinStackTest {

	@Test
	void testPush() {
		MinStack minStack = new MinStack();
		assertEquals(0, minStack.size());

		minStack.push(1);
		assertEquals(1, minStack.size());

		minStack.push(2);
		assertEquals(2, minStack.size());

		minStack.push(3);
		assertEquals(3, minStack.size());
	}

	@Test
	void testPop() {
		MinStack minStack = new MinStack();
		minStack.push(1);
		minStack.push(2);
		minStack.push(3);
		assertEquals(3, minStack.size());

		minStack.pop();
		assertEquals(2, minStack.size());

		minStack.pop();
		assertEquals(1, minStack.size());

		minStack.pop();
		assertEquals(0, minStack.size());

		assertThrows(IllegalStateException.class, () -> minStack.pop());
	}

	@Test
	void testTop() {

		MinStack minStack = new MinStack();
		assertThrows(IllegalStateException.class, () -> minStack.top());

		minStack.push(1);
		assertEquals(1, minStack.top());

		minStack.push(2);
		assertEquals(2, minStack.top());

		minStack.push(3);
		assertEquals(3, minStack.top());

	}

	@Test
	public void testGetMin() {
		MinStack minStack = new MinStack();
		assertThrows(IllegalStateException.class, () -> minStack.getMin());

		minStack.push(1);
		assertEquals(1, minStack.top());
		assertEquals(1, minStack.getMin());

		minStack.push(2);
		assertEquals(2, minStack.top());
		assertEquals(1, minStack.getMin());

		minStack.push(3);
		assertEquals(3, minStack.top());
		assertEquals(1, minStack.getMin());

		minStack.push(0);
		assertEquals(0, minStack.top());
		assertEquals(0, minStack.getMin());

		minStack.push(-1);
		assertEquals(-1, minStack.top());
		assertEquals(-1, minStack.getMin());

		minStack.push(4);
		assertEquals(4, minStack.top());
		assertEquals(-1, minStack.getMin());

		minStack.pop();
		assertEquals(-1, minStack.top());
		assertEquals(-1, minStack.getMin());

		minStack.pop();
		assertEquals(0, minStack.top());
		assertEquals(0, minStack.getMin());

		minStack.pop();
		assertEquals(3, minStack.top());
		assertEquals(1, minStack.getMin());

		minStack.pop();
		assertEquals(2, minStack.top());
		assertEquals(1, minStack.getMin());

		minStack.pop();
		assertEquals(1, minStack.top());
		assertEquals(1, minStack.getMin());
	}

}
