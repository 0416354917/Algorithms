package leetcode;

public class Solution81 {

	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return false;

		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		while (left <= right) {
			mid = (left + right) >> 1;
			if (target == nums[mid])
				return true;
			else if (target < nums[mid]) {
				if (nums[mid] > nums[right] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				if (nums[right] > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Solution81 solution = new Solution81();

		// int[] nums = { 4, 5, 5, 5, 6, 7, 0, 1, 2, 2 };
		// for (int n = 0; n < 10; n++) {
		// System.out.println(
		// "n = " + n + ", solution = " + solution.search(nums, n));
		// }

		int[] nums2 = { 1, 1, 3, 1 };
		int target2 = 3;
		System.out.println(solution.search(nums2, target2));

		// assert (true == solution.search(nums2, target2));
	}

}
