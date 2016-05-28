package leetcode;

/**
 * Patching Array.
 * 
 * <p>
 * <b>Description: </b>Given a sorted positive integer array nums and an integer
 * n, add/patch elements to the array such that any number in range [1, n]
 * inclusive can be formed by the sum of some elements in the array. Return the
 * minimum number of patches required.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Greedy.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */

public class Solution330 {

	public int minPatches(int[] nums, int n) {
		int count = 0;

		int max = 0;
		int index = 0;
		try {
			while (index < nums.length
					&& nums[index] <= Math.addExact(max, 1)) {
				max = Math.addExact(max, nums[index]);
				index++;
			}

			while (max < n) {
				count++;
				max = Math.addExact(max, max + 1);
				while (index < nums.length
						&& nums[index] <= Math.addExact(max, 1)) {
					max = Math.addExact(max, nums[index]);
					index++;
				}
			}
		} catch (ArithmeticException e) {
			return count;
		}

		return count;
	}

	public static void main(String[] args) {
		Solution330 solution = new Solution330();

		int[] nums = { 1, 3 };
		int n = 6;
		System.out.println(solution.minPatches(nums, n)); // 1

		int[] nums1 = { 1, 5, 10 };
		int n1 = 20;
		System.out.println(solution.minPatches(nums1, n1)); // 2

		int[] nums2 = { 1, 2, 2 };
		int n2 = 5;
		System.out.println(solution.minPatches(nums2, n2)); // 0

		int[] nums3 = { 1, 2, 31, 33 };
		int n3 = 2147483647;
		System.out.println(solution.minPatches(nums3, n3)); // 0
	}

}
