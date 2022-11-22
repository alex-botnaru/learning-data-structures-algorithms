package com.abotnaru.problems.neetcode.two.pointers;

public class ValidPalindrome {

	/**
	 * Returns true if provided string is a palindrome, false otherwise.
	 * <p>
	 * A phrase is a palindrome if, after converting all upper case letters into
	 * lower case letters and removing all non-alphanumeric characters, it reads the
	 * same forward and backward. Alphanumeric characters include letters and
	 * numbers.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPalindrome(String string) {
		int left = 0;
		int right = string.length() - 1;

		while (left < right) {
			char leftChar = string.charAt(left);
			char rightChar = string.charAt(right);

			if (!Character.isLetterOrDigit(leftChar)) {
				// Skip the current left character if is not a letter or digit
				left++;
			} else if (!Character.isLetterOrDigit(rightChar)) {
				// Skip the current right character if is not a letter or digit
				right--;
			} else if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
				return false;
			} else {
				left++;
				right--;
			}
		}

		return true;
	}

}
