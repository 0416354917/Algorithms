package leetcode;

/**
 * First Missing Positive.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution41 {

	public int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0
				|| (nums.length == 1 && nums[0] != 1)) {
			return 1;
		}

		for (int index = 0; index < nums.length; index++) {
			while (nums[index] >= 1 && nums[index] <= nums.length
					&& nums[index] - 1 != index) {
				if (nums[nums[index] - 1] == nums[index])
					break;
				int t = nums[nums[index] - 1];
				nums[nums[index] - 1] = nums[index];
				nums[index] = t;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (i + 1 != nums[i])
				return i + 1;
		}

		return nums[nums.length - 1] + 1;
	}

	public static void main(String[] args) {
		Solution41 solution = new Solution41();

		int[] nums1 = { 1, 2, 0 };
		int[] nums2 = { 3, 4, -1, 1 };
		int[] nums3 = { 1, 1 };
		int[] nums4 = { 2, 1 };
		int[] nums5 = { 1, 0 };

		System.out.println(solution.firstMissingPositive(nums1));
		System.out.println(solution.firstMissingPositive(nums2));
		System.out.println(solution.firstMissingPositive(nums3));
		System.out.println(solution.firstMissingPositive(nums4));
		System.out.println(solution.firstMissingPositive(nums5));
	}

}
