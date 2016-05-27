package leetcode;

/**
 * Search in Rotated Sorted Array II.
 * 
 * <p>
 * <b>Description: </b>Suppose a sorted array is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * 
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Binary Search.
 * </p>
 * 
 * <p>
 * <b>Status: </b>...
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution81 {

	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return false;

		if (nums.length == 1)
			return nums[0] == target;

		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			if (target == nums[mid])
				return true;
			else if (target < nums[mid]) {
				if (nums[mid] < nums[left]) {
					right = mid - 1;
				} else if (nums[mid] == nums[left]) {
					left = mid + 1;
				} else {
					if (target >= nums[left]) {
						right = mid - 1;
					} else {
						left = mid + 1;
					}
				}
			} else {
				if (nums[mid] < nums[left]) {
					if (target <= nums[right]) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				} else if (nums[mid] == nums[left]) {
					if (target <= nums[right]) {
						left = mid + 1;
					} else {
						if (nums[left] > nums[right]) {
							left = mid + 1;
						} else if (nums[left] == nums[right]) {
							// Undecidable?
							// Here may cause the sub-problem to run in linear
							// complexity.
							while (nums[left] < target && left != mid) {
								left++;
								if (nums[left] == target)
									return true;

							}
							right--;
						} else {
							left++;
						}
					}
				} else {
					left = mid + 1;
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

		int[] nums3 = { 1, 3, 1, 1, 1 };
		int target3 = 3;
		System.out.println(solution.search(nums3, target3));

		int[] nums4 = { 1, 3 };
		int target4 = 4;
		System.out.println(solution.search(nums4, target4));
	}

}
