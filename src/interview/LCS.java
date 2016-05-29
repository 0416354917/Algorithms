package interview;

public class LCS {

	/**
	 * Longest Common Substring of two strings.
	 * 
	 * @param s1
	 * @param s2
	 * @return Longest Common Substring of two strings.
	 */
	public String getLCS(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();

		int[][] dp = new int[n + 1][m + 1];

		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= m; col++) {
				if (s1.charAt(row - 1) == s2.charAt(col - 1))
					dp[row][col] = dp[row - 1][col - 1] + 1;
				else
					dp[row][col] = Math.max(
							Math.max(dp[row - 1][col], dp[row][col - 1]),
							dp[row - 1][col - 1]);
			}
		}

		// Construct solution path.
		StringBuffer ans = new StringBuffer();
		int row = n;
		int col = m;
		while (true) {
			if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
				ans.append(s1.charAt(row - 1));
				row--;
				col--;
			} else if (dp[row][col] == dp[row - 1][col - 1]) {
				row--;
				col--;
			} else if (dp[row][col] == dp[row - 1][col]) {
				row--;
			} else {
				col--;
			}

			if (row == 0 || col == 0)
				break;
		}

		return ans.reverse().toString();
	}

}
