package leetcode;

/**
 * Burst Balloons.
 * 
 * <p>
 * <b>Status: .</b>
 * </p>
 * 
 * @author Jason
 *
 */

public class Solution312 {

	public int maxCoins(int[] nums) {
		int[] dp = new int[nums.length + 2];
		dp[0] = 1;
		dp[dp.length - 1] = 1;
		
		int ans = 0;
		return ans;
	}

	public static void main(String[] args) {
		Solution312 solution = new Solution312();

		int[] nums = { 3, 1, 5, 8 };
		System.out.println(solution.maxCoins(nums));
	}

}
