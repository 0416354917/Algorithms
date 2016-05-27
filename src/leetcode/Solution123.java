package leetcode;

/**
 * Best Time to Buy and Sell Stock III.
 * 
 * <p>
 * <b>Description: </b>Say you have an array for which the ith element is the
 * price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
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
public class Solution123 {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;

		int[] dp1 = new int[prices.length];
		int min1 = prices[0];
		dp1[0] = 0;
		for (int i = 1; i < dp1.length; i++) {
			if (prices[i] < min1) {
				min1 = prices[i];
				dp1[i] = dp1[i - 1];
			} else {
				dp1[i] = Math.max(dp1[i - 1], prices[i] - min1);
			}
		}

		int n = prices.length;
		int[] dp2 = new int[n];
		int max2 = prices[n - 1];
		dp2[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			if (prices[i] > max2) {
				max2 = prices[i];
				dp2[i] = dp2[i + 1];
			} else {
				dp2[i] = Math.max(dp2[i + 1], max2 - prices[i]);
			}
		}

		int ans = Math.max(dp1[n - 1], dp2[0]);
		for (int i = 0; i < n - 1; i++) {
			ans = Math.max(ans, dp1[i] + dp2[i + 1]);
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution123 solution = new Solution123();

		int[] prices = { 2, 1 };
		System.out.println(solution.maxProfit(prices));
	}

}
