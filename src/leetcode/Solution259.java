package leetcode;

import java.util.Arrays;

/**
 * 3Sum Smaller.
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
public class Solution259 {

	public int threeSumSmaller(int[] nums, int target) {
		if (nums == null || nums.length < 3)
			return 0;

		int ans = 0;

		Arrays.sort(nums);
		int i = 0;
		while (i < nums.length - 2) {
			int lo = i + 1;
			int hi = nums.length - 1;
			while (lo < hi) {
				if (nums[i] + nums[lo] + nums[hi] < target) {
					ans += (hi - lo);
					lo++;
				} else {
					hi--;
				}
			}
			i++;
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution259 solution = new Solution259();

		int[] nums = { -2, 0, 1, 3 };
		int target = 2;
		System.out.println(solution.threeSumSmaller(nums, target));
	}

}
