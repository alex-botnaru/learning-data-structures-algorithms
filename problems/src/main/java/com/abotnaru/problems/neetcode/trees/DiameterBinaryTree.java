package com.abotnaru.problems.neetcode.trees;

public class DiameterBinaryTree {

	// private variable to keep track of maximum path
	private int maxDiameter;

	/**
	 * Returns the length of the diameter of the tree.<br>
	 * Time and space complexity O(N)
	 * 
	 * @param root
	 * @return
	 */
	public int diameterOfBinaryTree(TreeNode root) {
		maxDiameter = -1;
		depthFirstSearch(root);
		return maxDiameter;
	}

	private int depthFirstSearch(TreeNode node) {
		if (node == null) {
			// if node is null, return -1, so the parent node height will count for 0
			return -1;
		}

		// Get the height of the right and left branches, update the max and return the
		// max height of the current node
		int leftBranchHeight = depthFirstSearch(node.left) + 1;
		int rightBranchHeight = depthFirstSearch(node.right) + 1;
		maxDiameter = Math.max(maxDiameter, leftBranchHeight + rightBranchHeight);

		return Math.max(leftBranchHeight, rightBranchHeight);
	}

}
