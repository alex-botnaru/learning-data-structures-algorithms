package com.abotnaru.problems.neetcode.stack;

public class MinStack {

	/**
	 * All methods execute in constant time.
	 *
	 */
	private static class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private int size;
	private Node top;
	private Node minTop;

	public int size() {
		return size;
	}

	public void push(int val) {
		Node node = new Node(val, top);
		Node minNode = new Node(minTop == null ? val : Math.min(val, minTop.data), minTop);
		top = node;
		minTop = minNode;
		size++;
	}

	public void pop() {
		if (top == null) {
			throw new IllegalStateException("Stack is empty");
		}
		Node node = top;
		Node minNode = minTop;
		top = top.next;
		minTop = minTop.next;
		node.next = null;
		minNode.next = null;
		size--;
	}

	public int top() {
		if (top == null) {
			throw new IllegalStateException("Stack is empty");
		}
		return top.data;
	}

	public int getMin() {
		if (top == null) {
			throw new IllegalStateException("Stack is empty");
		}
		return minTop.data;
	}
}
