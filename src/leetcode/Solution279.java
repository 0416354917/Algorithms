package leetcode;

/**
 * Perfect Squares.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution279 {

	public int numSquares(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		int[] dp = new int[n + 1];

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			if ((int) Math.sqrt(i) * (int) Math.sqrt(i) == i)
				dp[i] = 1;
			else {
				dp[i] = Integer.MAX_VALUE;
				for (int j = 1; j <= i / 2; j++) {
					dp[i] = dp[i] > dp[j] + dp[i - j] ? dp[j] + dp[i - j]
							: dp[i];
				}
			}
		}

		return dp[n];
	}

	public static void main(String[] args) {
		Solution279 solution = new Solution279();

		for (int n = 1; n < 17; n++)
			System.out.println(
					"n = " + n + ", solution = " + solution.numSquares(n));
	}

}
