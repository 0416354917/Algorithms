package leetcode;

/**
 * Longest Increasing Subsequence.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution300 {

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return 1;
		}

		int ans = 1;
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			ans = dp[i] > ans ? dp[i] : ans;
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution300 solution = new Solution300();

		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(solution.lengthOfLIS(nums));

	}

}
