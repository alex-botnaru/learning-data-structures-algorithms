package com.abotnaru.problems.neetcode.trees;

public class BinaryTreeMaxPathSum {

	/**
	 * Returns the max sum of any non-empty path.
	 * 
	 * @param root
	 * @return
	 */
	public int maxPathSum(TreeNode root) {
		int[] result = new int[] { Integer.MIN_VALUE };
		maxPathSumDfs(root, result);
		return result[0];
	}

	/**
	 * DFS Helper method
	 * 
	 * @param root
	 * @param result
	 * @return
	 */
	public int maxPathSumDfs(TreeNode root, int[] result) {

		if (root == null) {
			return 0;
		}

		// Compute the max sum of left and right subtree, discard the negative sums
		int leftSum = Math.max(maxPathSumDfs(root.left, result), 0);
		int rightSum = Math.max(maxPathSumDfs(root.right, result), 0);

		// Compute the sum of the of the pat from left, current node, and right subtree,
		// update the max
		result[0] = Math.max(result[0], leftSum + root.val + rightSum);

		// Return the sum of the current node value, plus max between the left and right
		// subtrees
		return root.val + Math.max(leftSum, rightSum);
	}
}
