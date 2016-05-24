package leetcode;

/**
 * Distinct Subsequences.
 * 
 * <p>
 * <b>Description: </b>Given a string S and a string T, count the number of
 * distinct subsequences of T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
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
public class Solution115 {

	public int numDistinct(String s, String t) {
		if (s == null || s.length() == 0) {
			if (t == null || t.length() == 0)
				return 1;
			else
				return 0;
		} else if (t == null || t.length() == 0) {
			return 1;
		} else if (t.length() > s.length()) {
			return 0;
		}

		int[][] dp = new int[t.length()][s.length()];

		int row = 0;
		int col = 0;
		for (row = 0; row < t.length(); row++) {
			dp[row][row] = (t.charAt(row) == s.charAt(row) ? 1 : 0);
			if (dp[row][row] == 0) {
				row++;
				while (row < t.length()) {
					dp[row++][row++] = 0;
				}
			}
		}
		for (col = 1; col < s.length(); col++) {
			dp[0][col] = dp[0][col - 1];
			if (s.charAt(col) == t.charAt(0))
				dp[0][col]++;
		}
		for (row = 1; row < t.length(); row++) {
			for (col = row + 1; col < s.length(); col++) {
				dp[row][col] = dp[row][col - 1];
				if (s.charAt(col) == t.charAt(row))
					dp[row][col] += dp[row - 1][col - 1];
			}
		}

		return dp[t.length() - 1][s.length() - 1];
	}

	public static void main(String[] args) {
		Solution115 solution = new Solution115();

		String s = "rabbbit";
		String t = "rabbit";
		System.out.println(solution.numDistinct(s, t));
	}

}
