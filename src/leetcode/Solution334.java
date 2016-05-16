package leetcode;

/**
 * Increasing Triplet Subsequence.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution334 {

	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 3)
			return false;

		int i = 0;
		while (i < nums.length - 1 && nums[i] >= nums[i + 1]) {
			i++;
		}
		if (i >= nums.length - 2)
			return false;

		int min = nums[i];
		int nextLarge = nums[i + 1];
		i += 2;
		while (i < nums.length) {
			if (nums[i] > nextLarge)
				return true;

			if (nums[i] > min) {
				nextLarge = nums[i];
			}

			if (nums[i] < min) {
				min = nums[i];
			}

			i++;
		}

		return false;

	}

	public static void main(String[] args) {
		Solution334 solution = new Solution334();

		int[] nums1 = { 5, 4, 3, 2, 1 };
		System.out.println(solution.increasingTriplet(nums1));
		int[] nums2 = { 1, 2, 3, 4, 5 };
		System.out.println(solution.increasingTriplet(nums2));
		int[] nums3 = { 0, 4, 2, 1, 0, -1, -3 };
		System.out.println(solution.increasingTriplet(nums3));
	}

}
