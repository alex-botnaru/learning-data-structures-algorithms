package com.abotnaru.problems.neetcode.linked.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class AddTwoNumbersTest {

	@Test
	void testAddTwoThreeDigitsNumber() {
		ListNode number1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		ListNode number2 = new ListNode(5, new ListNode(6, new ListNode(4)));

		ListNode actual = new AddTwoNumbers().addTwoNumbers(number1, number2);

		assertNotNull(actual);
		assertEquals(7, actual.value);

		actual = actual.next;
		assertNotNull(actual);
		assertEquals(0, actual.value);

		actual = actual.next;
		assertNotNull(actual);
		assertEquals(8, actual.value);

		assertNull(actual.next);
	}

	@Test
	void testAddTwoOneDigitNumber() {
		ListNode number1 = new ListNode(0);
		ListNode number2 = new ListNode(0);

		ListNode actual = new AddTwoNumbers().addTwoNumbers(number1, number2);

		assertNotNull(actual);
		assertEquals(0, actual.value);
		assertNull(actual.next);
	}
	
	@Test
	void testAddTwoSevenDigitsNumber() {
		ListNode number1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
		ListNode number2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

		ListNode actual = new AddTwoNumbers().addTwoNumbers(number1, number2);

		assertNotNull(actual);
		assertEquals(8, actual.value);

		actual = actual.next;
		assertNotNull(actual);
		assertEquals(9, actual.value);

		actual = actual.next;
		assertNotNull(actual);
		assertEquals(9, actual.value);
		
		actual = actual.next;
		assertNotNull(actual);
		assertEquals(9, actual.value);
		
		actual = actual.next;
		assertNotNull(actual);
		assertEquals(0, actual.value);
		
		actual = actual.next;
		assertNotNull(actual);
		assertEquals(0, actual.value);
		
		actual = actual.next;
		assertNotNull(actual);
		assertEquals(0, actual.value);
		
		actual = actual.next;
		assertNotNull(actual);
		assertEquals(1, actual.value);

		assertNull(actual.next);
	}

}
