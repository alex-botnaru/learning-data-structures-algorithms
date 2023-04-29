package com.abotnaru.problems.neetcode.dynamic.programming.d1;

public class DecodeWays {

	/**
	 * Returns the number of ways to decode the provided string
	 * 
	 * @param s
	 * @return
	 */
	public int numDecodings(String s) {
		if (s == null || s.isEmpty() || s.startsWith("0")) {
			return 0;
		}

		int oneFwd = 1; // One character forward: index + 1
		int twoFwd = 0; // Two characters forward: index + 2

		for (int i = s.length() - 1; i > -1; i--) {

			int current = 0;

			if (s.charAt(i) != '0') {
				// If current character is 0, just copy what is the next value
				current = oneFwd;
			}

			// if current character is 1 or 2, and if it's 2 the next is between 0 and 6,
			// then add the value from two indexes ahead.
			if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && (s.charAt(i + 1) < '7')))) {
				current += twoFwd;
			}

			// Shift the values
			twoFwd = oneFwd;
			oneFwd = current;

		}

		return oneFwd;
	}

	public int numDecodingsWithArray(String s) {

		if (s == null || s.isEmpty()) {
			return 0;
		}

		int[] dp = new int[s.length() + 1];
		dp[0] = 1; // index -1, empty string
		dp[1] = s.charAt(0) == '0' ? 0 : 1; // first character

		for (int i = 2; i < dp.length; i++) {
			if (s.charAt(i - 1) != '0') {
				dp[i] += dp[i - 1];
			}

			if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && (s.charAt(i - 1) < '7'))) {
				dp[i] += dp[i - 2];
			}
		}

		return dp[s.length()];
	}

}
