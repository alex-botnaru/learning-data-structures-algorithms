package com.abotnaru.problems.neetcode.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DetectSquaresTest {

	@Test
	void testDtectSquares() {
		DetectSquares ds = new DetectSquares();
		ds.add(new int[] { 3, 10 });
		ds.add(new int[] { 11, 2 });
		ds.add(new int[] { 3, 2 });
		assertEquals(1, ds.count(new int[] { 11, 10 }));

		assertEquals(0, ds.count(new int[] { 14, 8 }));
		ds.add(new int[] { 11, 2 });
		assertEquals(2, ds.count(new int[] { 11, 10 }));
		ds.add(new int[] { 3, 10 });
		assertEquals(4, ds.count(new int[] { 11, 10 }));
	}
}
