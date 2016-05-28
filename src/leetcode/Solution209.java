package leetcode;

/**
 * Minimum Size Subarray Sum.
 * 
 * <p>
 * <b>Description: </b>Given an array of n positive integers and a positive
 * integer s, find the minimal length of a subarray of which the sum ≥ s. If
 * there isn't one, return 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length under the problem constraint.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Two Pointers.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution209 {

	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int ans = nums.length + 1;
		int p1 = 0, p2 = 0;
		int sum = 0;
		while (p2 < nums.length) {
			if (sum < s) {
				sum += nums[p2];
				p2++;
			}

			while (sum >= s) {
				ans = Math.min(p2 - p1, ans);
				sum -= nums[p1];
				p1++;
			}
		}

		return ans == nums.length + 1 ? 0 : ans;
	}

	public static void main(String[] args) {
		Solution209 solution = new Solution209();

		int s = 7;
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		System.out.println(solution.minSubArrayLen(s, nums));
	}

}
