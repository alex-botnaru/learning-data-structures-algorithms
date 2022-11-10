package com.abotnaru.problems.neetcode.sliding.window;

public class LongestRepeatingCharacterReplacement {

	/**
	 * Returns the length of the longest substring containing same characters after
	 * replacing k characters in the string s.
	 * <p>
	 * s contains only uppercase English letters
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public int characterReplacement(String s, int k) {
		int maxLength = 0;
		int[] occurences = new int[26]; // Store the frequency of characters in a window at specific time
		int left = 0; // Left window index
		int right = 0; // Right window index, initially the window contains one element
		int maxFrequency = 0; // Keep track of a max found occurrence

		// Sliding the window right index to the right
		for (; right < s.length(); right++) {

			// Increment the occurrence for the current character
			int charIndex = s.charAt(right) - 'A';
			occurences[charIndex]++;
			maxFrequency = Math.max(maxFrequency, occurences[charIndex]);

			// Shift the left pointer to the right if the window is invalid
			// A valid window is when the window length minus occurrences of most frequent
			// character is <= k
			while (((right - left + 1) - maxFrequency) > k) {
				occurences[s.charAt(left) - 'A']--;
				left++;
				// NOTE: We don't decrement the maxFrequency because it wont affect our results,
				// we are looking for the max.
			}

			// Update the max window length
			maxLength = Math.max(maxLength, right - left + 1);
		}
		return maxLength;
	}

}
