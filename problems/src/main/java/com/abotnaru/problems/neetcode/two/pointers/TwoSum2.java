package com.abotnaru.problems.neetcode.two.pointers;

public class TwoSum2 {

	/**
	 * Finds two numbers in the input array such that they add up to the target
	 * number.
	 * <p>
	 * <li>Array is sorted and ascending order
	 * <li>There is exactly one solution
	 * <li>Output array is exactly length of 2
	 * <li>Same array element cannot be used twice
	 * 
	 * @param numbers
	 * @param target
	 * @return the indices of the two numbers, index1 and index2, <b>added by
	 *         one</b> as an integer array [index1, index2 of length 2.
	 */
	public int[] twoSum(int[] numbers, int target) {

		int index1 = 0;
		int index2 = numbers.length - 1;
		while (index1 < index2) {
			int currentSum = numbers[index1] + numbers[index2];
			if (currentSum > target) {
				// Added too much, decrement the right index
				index2--;
			} else if (currentSum < target) {
				// Added too little, increment the left index
				index1++;
			} else {
				// Found the solution, exit the loop
				break;
			}
		}

		return new int[] { index1 + 1, index2 + 1 };
	}

}
