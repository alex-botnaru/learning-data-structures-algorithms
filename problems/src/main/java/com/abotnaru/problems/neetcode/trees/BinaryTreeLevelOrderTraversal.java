package com.abotnaru.problems.neetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	/**
	 * Returns the Level Order Traversal of its nodes' values from left to right.
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		// Create a queue and the root node if exists
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			queue.add(root);
		}

		while (!queue.isEmpty()) {
			// Get the number of nodes per level
			int levelSize = queue.size();
			List<Integer> list = new ArrayList<>();
			// Extract exact number of nodes for current level
			for (int i = 0; i < levelSize; i++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				// Add the children at the end of the queue
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			// Add the level into the result list
			result.add(list);
		}

		return result;
	}
}
