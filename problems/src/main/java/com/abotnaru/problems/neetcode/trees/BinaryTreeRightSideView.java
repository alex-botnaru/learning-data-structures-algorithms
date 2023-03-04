package com.abotnaru.problems.neetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

	/**
	 * Returns the values of right side of a tree ordered from top to bottom.
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();

		// Initialize a queue to do BFS
		Queue<TreeNode> queue = new LinkedList<>();
		// Add the root node if exists
		if (root != null) {
			queue.add(root);
		}

		while (!queue.isEmpty()) {
			// Get the number of nodes per current level
			int levelSize = queue.size();
			// Remove the level nodes from the queue
			for (int i = 0; i < levelSize; i++) {
				TreeNode node = queue.poll();
				// Add the left and right nodes to the queue if not null
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				// If it is the last node, add it to the result list
				if (i == levelSize - 1) {
					result.add(node.val);
				}
			}
		}
		return result;
	}
}
