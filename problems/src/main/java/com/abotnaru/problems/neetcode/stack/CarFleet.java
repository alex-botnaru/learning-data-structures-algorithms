package com.abotnaru.problems.neetcode.stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class CarFleet {

	/**
	 * Returns the number of car fleets that will arrive at destination.<br>
	 * NeedCode proposed solution. Time complexity O(NlogN), space complexity O(N)
	 * <p>
	 * NOTE: A car can be behind and faster, but depending on start position of the
	 * slower in front car, it can be two different fleets.
	 * 
	 * @param target   - the distance to the destination from the 0 position
	 * @param position - initial car positions
	 * @param speed    - car speed
	 * @return
	 */
	public int carFleet(int target, int[] position, int[] speed) {
		if (position.length == 1)
			return 1;

		Stack<Double> stack = new Stack<>();
		int[][] positionSpeed = new int[position.length][2];

		// Combine position and speed arrays into one multidimensional array
		for (int i = 0; i < position.length; i++) {
			positionSpeed[i][0] = position[i];
			positionSpeed[i][1] = speed[i];
		}

		// Sort the array
		Arrays.sort(positionSpeed, Comparator.comparingInt(o -> o[0]));

		// Loop by position in decreasing order
		for (int i = positionSpeed.length - 1; i >= 0; i--) {
			// Calculate the remaining time
			double remainingTime = (double) (target - positionSpeed[i][0]) / positionSpeed[i][1];
			// If stack empty or remaining time is greater than the last arrived car, add it
			// to the stack.
			if (stack.isEmpty() || remainingTime > stack.peek()) {
				stack.push(remainingTime);
				// The current car start position is behind the car that is in the stack, if the
				// remaining time is less or equal than the value in the stack, it means that
				// the current car is faster, and at some point it collided with one in the
				// stack.
			}
		}

		return stack.size();
	}

	/**
	 * Returns the number of car fleets that will arrive at destination.<br>
	 * Initial implementation. My assumption is O(N) time and space complexity.
	 * <p>
	 * NOTE: A car can be behind and faster, but depending on start position of the
	 * slower in front car, it can be two different fleets.
	 * 
	 * @param target   - the distance to the destination from the 0 position
	 * @param position - initial car positions
	 * @param speed    - car speed
	 * @return
	 */
	public int carFleetInit(int target, int[] position, int[] speed) {
		int[] remaining = new int[position.length];
		int carFleet = 0;
		// Calculate, remaining time till target
		for (int i = 0; i < remaining.length; i++) {
			remaining[i] = (target - position[i]) / speed[i];
		}

		for (int i = 0; i < remaining.length; i++) {
			if (remaining[i] == -1) {
				// Skip if the value was processed
				continue;
			}
			carFleet++; // the car is not part of any other fleet, increment the fleet number
			for (int j = i + 1; j < remaining.length && remaining[j] > -1; j++) {
				// For remaining cars in the array, check if behind and faster, meaning it will
				// catch up with the current (i)
				boolean isNextBehindAndFaster = position[i] > position[j] && remaining[i] >= remaining[j];
				// or there is a slower car in front, which current (i) car eventually will
				// collide
				boolean isNextInFrontAndSlower = position[i] <= position[j] && remaining[i] < remaining[j];
				if (isNextBehindAndFaster || isNextInFrontAndSlower) {
					remaining[j] = -1;
				}
			}
		}

		return carFleet;
	}

}
