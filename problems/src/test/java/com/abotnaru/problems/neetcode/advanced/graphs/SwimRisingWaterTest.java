package com.abotnaru.problems.neetcode.advanced.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SwimRisingWaterTest {

	@Test
	void testSwimInWaterExpectThree() {
		assertEquals(3, new SwimRisingWater().swimInWater(new int[][] { { 0, 2 }, { 1, 3 } }));
	}

	@Test
	void testSwimInWaterExpectSixteen() {
		assertEquals(16, new SwimRisingWater().swimInWater(new int[][] { { 0, 1, 2, 3, 4 }, { 24, 23, 22, 21, 5 },
				{ 12, 13, 14, 15, 16 }, { 11, 17, 18, 19, 20 }, { 10, 9, 8, 7, 6 } }));
	}

}
