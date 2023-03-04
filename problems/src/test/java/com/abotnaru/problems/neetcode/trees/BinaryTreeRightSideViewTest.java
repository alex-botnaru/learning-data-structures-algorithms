package com.abotnaru.problems.neetcode.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

class BinaryTreeRightSideViewTest {

	@Test
	void testRightSideViewFiveNodes() {
		TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));

		List<Integer> actual = new BinaryTreeRightSideView().rightSideView(root);
		assertNotNull(actual);
		assertFalse(actual.isEmpty());
		assertEquals(3, actual.size());
		assertEquals(1, actual.get(0));
		assertEquals(3, actual.get(1));
		assertEquals(4, actual.get(2));
	}

	@Test
	void testRightSideViewSixNodes() {
		TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5, new TreeNode(7), null)),
				new TreeNode(3, null, new TreeNode(4)));

		List<Integer> actual = new BinaryTreeRightSideView().rightSideView(root);
		assertNotNull(actual);
		assertFalse(actual.isEmpty());
		assertEquals(4, actual.size());
		assertEquals(1, actual.get(0));
		assertEquals(3, actual.get(1));
		assertEquals(4, actual.get(2));
		assertEquals(7, actual.get(3));
	}

	@Test
	void testRightSideViewTwoNodes() {
		TreeNode root = new TreeNode(1, null, new TreeNode(3));

		List<Integer> actual = new BinaryTreeRightSideView().rightSideView(root);
		assertNotNull(actual);
		assertFalse(actual.isEmpty());
		assertEquals(2, actual.size());
		assertEquals(1, actual.get(0));
		assertEquals(3, actual.get(1));
	}

}
