package com.abotnaru.problems.neetcode.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class BstCodecTest {

	@Test
	void testSerializeDeserializeExpectSameTree() {
		TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
		BstCodec bstCodec = new BstCodec();

		String encoded = bstCodec.serialize(root);
		assertEquals("1;2;N;N;3;4;N;N;5;N;N", encoded);

		TreeNode actual = bstCodec.deserialize(encoded);
		assertNotNull(actual);
		assertEquals(root.val, actual.val);
		assertEquals(root.left.val, actual.left.val);
		assertEquals(root.right.val, actual.right.val);
		assertEquals(root.right.left.val, actual.right.left.val);
		assertEquals(root.right.right.val, actual.right.right.val);
	}

}
