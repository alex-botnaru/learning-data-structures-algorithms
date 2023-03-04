package com.abotnaru.problems.neetcode.trees;

public class CountGoodNodesInBinaryTree {

	/**
	 * Return the number of GOOD nodes in the tree. The good node is the node that
	 * has the value greater or equal than his parent node.
	 * 
	 * @param root
	 * @return
	 */
	public int goodNodes(TreeNode root) {
		return dfsHelper(root, root.val);
	}

	/**
	 * Helper method that does DFS and returns the number of good nodes for the
	 * subtree
	 * 
	 * @param node
	 * @param max
	 * @return
	 */
	private int dfsHelper(TreeNode node, int max) {
		if (node == null)
			return 0;

		// count the current node if it's value is greater or equal than max
		int res = 0;
		if (node.val >= max) {
			res = 1;
		}

		// Add the good counts from the left and right subtrees
		res += dfsHelper(node.left, Math.max(max, node.val));
		res += dfsHelper(node.right, Math.max(max, node.val));

		return res;
	}
}
