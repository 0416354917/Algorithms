package leetcode;

/**
 * Longest Palindromic Substring.
 * 
 * <p>
 * <b>Description: </b>Given a string S, find the longest palindromic substring
 * in S. You may assume that the maximum length of S is 1000, and there exists
 * one unique longest palindromic substring.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Dynamic Programming.
 * </p>
 * 
 * <p>
 * <b>Reference: </b>
 * {@link https://leetcode.com/articles/longest-palindromic-substring/#approach-3-dynamic-programming-accepted}
 * </p>
 * 
 * <p>
 * <b>Note: </b> A substring of a string S is another string S' that occurs "in"
 * S. For example, "the best of" is a substring of "It was the best of times".
 * This is not to be confused with subsequence, which is a generalization of
 * substring. For example, "Itwastimes" is a subsequence of
 * "It was the best of times", but not a substring.</br>
 * 
 * Prefix and suffix are refinements of substring. A prefix of a string S is a
 * substring of S that occurs at the beginning of S. A suffix of a string S is a
 * substring that occurs at the end of S.</br>
 * 
 * <b>Reference: </b> {@link https://en.wikipedia.org/wiki/Substring}
 * <p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution5 {

	public String longestPalindrome(String s) {
		if (s == null || s.length() < 2)
			return s;

		String ans = s.substring(0, 0);
		int maxLength = 1;

		int n = s.length();
		boolean[][] dp = new boolean[n][n];

		// length = 1:
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
		}

		// length = 2:
		int length = 2;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = true;
					if (length > maxLength) {
						maxLength = length;
						ans = s.substring(i, j + 1);
					}
				} else
					dp[i][j] = false;
			}
		}

		if (maxLength != length)
			return ans;

		// length > 2:
		for (length = 3; length <= n; length++) {
			for (int i = 0; i < n - length + 1; i++) {
				int j = i + length - 1;
				if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
					dp[i][j] = true;
					if (length > maxLength) {
						maxLength = length;
						ans = s.substring(i, j + 1);
					}
				} else
					dp[i][j] = false;
			}
			if (maxLength <= length - 2)
				break;
		}

		return ans;
	}

	public static void printMatrix(boolean[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				System.out.print(matrix[row][col]);
				if (col != cols - 1)
					System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution5 solution = new Solution5();

		String s = "abcba";
		System.out.println(solution.longestPalindrome(s));
	}

}
