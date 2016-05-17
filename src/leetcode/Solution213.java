package leetcode;

/**
 * House Robber II.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution213 {

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		if (nums.length == 1)
			return nums[0];

		int[] dp1 = new int[nums.length + 2];
		dp1[0] = 0;
		dp1[1] = 0;
		dp1[2] = nums[0];
		int ans1 = dp1[2];
		for (int i = 3; i < dp1.length - 1; i++) {
			dp1[i] = Math.max(dp1[i - 2] + nums[i - 2],
					dp1[i - 3] + nums[i - 2]);
			ans1 = Math.max(ans1, dp1[i]);
		}

		int[] dp2 = new int[nums.length + 2];
		dp2[0] = 0;
		dp2[1] = 0;
		dp2[2] = 0;
		int ans2 = dp2[2];
		for (int i = 3; i < dp2.length; i++) {
			dp2[i] = Math.max(dp2[i - 2] + nums[i - 2],
					dp2[i - 3] + nums[i - 2]);
			ans2 = Math.max(ans2, dp2[i]);
		}

		return ans1 > ans2 ? ans1 : ans2;
	}

	public static void main(String[] args) {
		Solution213 solution = new Solution213();

		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println(solution.rob(nums));
	}

}
