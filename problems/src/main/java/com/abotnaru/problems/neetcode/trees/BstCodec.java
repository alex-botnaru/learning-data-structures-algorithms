package com.abotnaru.problems.neetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BstCodec {

	/**
	 * Encodes a binary tree to a single string.
	 * <p>
	 * Encoded string is a list of numbers that represents nodes value delimited by
	 * ";" character, null pointers are marked as NULL.<br>
	 * Example: 1;2;N;N;3;N;N
	 * 
	 * @param root
	 * @return
	 */
	public String serialize(TreeNode root) {
		List<String> list = new ArrayList<>();
		preorderHelper(root, list);
		return list.stream().collect(Collectors.joining(";"));
	}

	/**
	 * Helper function that does DFS preorder traversal, null nodes marks as N.
	 * 
	 * @param root
	 * @param list
	 */
	private void preorderHelper(TreeNode root, List<String> list) {
		if (root == null) {
			list.add("N");
			return;
		}

		list.add("" + root.val);
		preorderHelper(root.left, list);
		preorderHelper(root.right, list);
	}

	private int index;

	/**
	 * Decodes a string into a binary tree
	 * 
	 * @param data
	 * @return
	 */
	public TreeNode deserialize(String data) {
		String[] tokens = data.split(";");
		index = 0;
		return helperBuilder(tokens);
	}

	/**
	 * Helper method to build the tree back.
	 * 
	 * @param tokens
	 * @return
	 */
	private TreeNode helperBuilder(String[] tokens) {

		// if token is N, then we have a null node, but before returning null, increment
		// the index to the next token.
		if (tokens[index].equals("N")) {
			index++;
			return null;
		}

		// Create a TreeNode for non N token. Increment the index and build right and
		// left subtree
		TreeNode node = new TreeNode(Integer.parseInt(tokens[index]));
		index++;
		node.left = helperBuilder(tokens);
		node.right = helperBuilder(tokens);
		return node;
	}
}
