package com.abotnaru.problems.neetcode.trees;

public class InvertBinaryTree {

	/**
	 * For the provided root of a binary tree, invert the tree and return it's root.
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode invertTree(TreeNode root) {
		switchLeftAndRight(root);
		return root;
	}

	private void switchLeftAndRight(TreeNode node) {
		if (node != null) {
			TreeNode left = node.left;
			TreeNode right = node.right;

			node.left = right;
			node.right = left;
			switchLeftAndRight(left);
			switchLeftAndRight(right);
		}
	}

}
