package leetcode;

/**
 * Edit Distance.
 * 
 * <p>
 * <b>Description: </b>Given two words word1 and word2, find the minimum number
 * of steps required to convert word1 to word2. (each operation is counted as 1
 * step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character
 * 
 * b) Delete a character
 * 
 * c) Replace a character
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Dynamic Programming.
 * </p>
 * {@link https://en.wikipedia.org/wiki/Edit_distance}
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution72 {

	public int minDistance(String word1, String word2) {
		if (word1 == null || word1.length() == 0) {
			if (word2 == null) {
				return 0;
			} else {
				return word2.length();
			}
		} else if (word2 == null || word2.length() == 0) {
			return word1.length();
		}

		int[][] dp = new int[word2.length() + 1][word1.length() + 1];
		for (int j = 0; j < word1.length(); j++)
			dp[0][j] = j;
		for (int i = 0; i <= word2.length(); i++)
			dp[i][0] = i;

		for (int row = 1; row <= word2.length(); row++) {
			for (int col = 1; col <= word1.length(); col++) {
				if (word1.charAt(col - 1) == word2.charAt(row - 1))
					dp[row][col] = dp[row - 1][col - 1];
				else {
					int d1 = dp[row - 1][col] + 1;
					int d2 = dp[row][col - 1] + 1;
					int d3 = dp[row - 1][col - 1] + 1;
					dp[row][col] = Math.min(d1, Math.min(d2, d3));
				}
			}
		}

		return dp[word2.length()][word1.length()];
	}

	public static void main(String[] args) {
		Solution72 solution = new Solution72();

		// String word1 = "fan";
		// String word2 = "fun";

		String word1 = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef";
		String word2 = "bcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg";

		System.out.println(solution.minDistance(word1, word2));
	}

}
