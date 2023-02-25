package com.abotnaru.problems.neetcode.trees;

public class BalancedBinaryTree {

	/**
	 * Internal class to hold two variables result, the height and balance of a
	 * node.
	 *
	 */
	private static class NodeBalance {
		final int height;
		final boolean isBalanced;

		NodeBalance(int height, boolean isBalanced) {
			this.height = height;
			this.isBalanced = isBalanced;
		}
	}

	/**
	 * Returns true if the provided tree is height-balanced, false otherwise
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {

		return depthFirstSearch(root).isBalanced;
	}

	private NodeBalance depthFirstSearch(TreeNode node) {
		if (node == null) {
			// If a node is null, it is balanced and has height 0
			return new NodeBalance(0, true);
		}

		// Get the height and balance of the children nodes
		NodeBalance left = depthFirstSearch(node.left);
		NodeBalance right = depthFirstSearch(node.right);

		// If both children nodes are balanced, and height difference is not greater
		// than 1, then this node is also balanced.
		boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1;
		// The height of the current node is max between left and right height + 1
		return new NodeBalance(Math.max(left.height, right.height) + 1, isBalanced);
	}

}
