package com.abotnaru.problems.neetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementBST {

	/**
	 * Returns the kth smallest value (1-indexed) of all the values of the nodes in
	 * the tree.
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public int kthSmallest(TreeNode root, int k) {
		List<Integer> list = new ArrayList<>();
		// Traverse the tree in in-order
		inorder(root, list);
		// return the kth - 1 element from the list, as the list is sorted in ascending
		// order
		return list.get(k - 1);
	}

	/**
	 * Helper functions to traverse all the nodes in in-order and save the value
	 * into a list
	 * 
	 * @param node
	 * @param list
	 */
	private void inorder(TreeNode node, List<Integer> list) {
		if (node == null)
			return;

		inorder(node.left, list);
		list.add(node.val);
		inorder(node.right, list);
	}

}
