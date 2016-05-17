package leetcode;

/**
 * Best Time to Buy and Sell Stock with Cooldown.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution309 {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;

		int[] dp = new int[prices.length + 2];
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 0;
		dp[3] = prices[1] > prices[0] ? prices[1] - prices[0] : 0;
		for (int i = 4; i < dp.length; i++) {
			dp[i] = 0;
			int j = i - 1;
			while (j >= 2) {
				if (prices[i - 2] - prices[j - 2] > 0) {
					dp[i] = Math.max(dp[i],
							dp[j - 2] + prices[i - 2] - prices[j - 2]);
				} else {
					dp[i] = Math.max(dp[i], dp[j]);
				}
				j--;
			}
		}

		return dp[dp.length - 1];
	}

	public static void main(String[] args) {
		Solution309 solution = new Solution309();

		int[] prices = { 1, 2, 3, 0, 2 };
		System.out.println(solution.maxProfit(prices));
	}

}
