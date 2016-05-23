package leetcode;

/**
 * Interleaving String.
 * 
 * <p>
 * <b>Description: </b>Given s1, s2, s3, find whether s3 is formed by the
 * interleaving of s1 and s2.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Dynamic Programming.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution97 {

	public boolean isInterleave(String s1, String s2, String s3) {
		// corner cases:
		if (s1 == null || s1.length() == 0) {
			if (s2 == null) {
				return s3 == null;
			} else {
				return s2.equals(s3);
			}
		} else if (s2 == null || s2.length() == 0) {
			return s1.equals(s3);
		} else if (s3 == null || s3.length() == 0) {
			return false;
		} else if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		// main algorithm:
		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
		// the first cell:
		dp[0][0] = true;
		// the first column:
		for (int j = 1; j <= s1.length(); j++) {
			if (s1.charAt(j - 1) == s3.charAt(j - 1))
				dp[j][0] = true;
			else {
				while (j <= s1.length()) {
					dp[j][0] = false;
					j++;
				}
			}

		}
		// the first row:
		for (int k = 1; k <= s2.length(); k++) {
			if (s2.charAt(k - 1) == s3.charAt(k - 1))
				dp[0][k] = true;
			else {
				while (k <= s2.length()) {
					dp[0][k] = false;
					k++;
				}
			}
		}
		// fill in dp matrix:
		for (int row = 1; row <= s1.length(); row++) {
			for (int col = 1; col <= s2.length(); col++) {
				dp[row][col] = false;

				if (dp[row - 1][col]
						&& s1.charAt(row - 1) == s3.charAt(row + col - 1)) {
					dp[row][col] = true;

				}

				if (dp[row][col - 1]
						&& s2.charAt(col - 1) == s3.charAt(row + col - 1)) {
					dp[row][col] = true;
				}
			}
		}

		return dp[s1.length()][s2.length()];
	}

	public void printMatrix(boolean[][] matrix) {
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
		Solution97 solution = new Solution97();

		String s1 = "aabcc";
		String s2 = "dbbca";

		String s3 = "aadbbcbcac";
		System.out.println(solution.isInterleave(s1, s2, s3)); // true.
		String s4 = "aadbbbaccc";
		System.out.println(solution.isInterleave(s1, s2, s4)); // false.
		String s5 = "abc";
		String s6 = "ac";
		String s7 = "acbac";
		System.out.println(solution.isInterleave(s5, s6, s7)); // false.
	}

}
