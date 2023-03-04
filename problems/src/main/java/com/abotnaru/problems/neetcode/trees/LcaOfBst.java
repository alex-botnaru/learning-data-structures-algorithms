package com.abotnaru.problems.neetcode.trees;

public class LcaOfBst {

	/**
	 * Returns the Lowest Common Ancestor(LCA) node of two given nodes in a BST.
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		// If both nodes value is greater than root, LCA is in the RIGHT side
		if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		}

		// If both nodes value is less than root, LCA is in the LEFT side
		if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		}
		// otherwise, root is their LCA
		return root;
	}
}
