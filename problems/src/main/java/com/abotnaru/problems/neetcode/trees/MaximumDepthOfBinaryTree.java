package com.abotnaru.problems.neetcode.trees;

public class MaximumDepthOfBinaryTree {

	/**
	 * Returns the max depth of the tree
	 * 
	 * @param node
	 * @return
	 */
	public int maxDepth(TreeNode node) {
		if (node == null) {
			// If node is null, the depth is 0
			return 0;
		}

		// Get the depth of the left and the right node
		int leftDepth = maxDepth(node.left);
		int rightDepth = maxDepth(node.right);

		// The depth starting from the current node will be the max between left and
		// right nodes + 1
		return Math.max(leftDepth, rightDepth) + 1;
	}

}
