package leetcode;

import java.util.stream.IntStream;

public class Solution {

	public int minSubArrayLen(int s, int[] nums) {
		int n = nums.length;
		int totalSum = IntStream.of(nums).sum();
		if (totalSum == s) {
			return n;
		} else if (totalSum < s) {
			return 0;
		} else {
			// two-pointers:
			int res = n;
			int left = 0;
			int right = n - 1;
			while (true) {
				System.out.println("totalSum = " + totalSum);
				int num1 = nums[left];
				int num2 = nums[right];
				int remainSum = 0;
				if (num1 <= num2) {
					remainSum = totalSum - num1;
					left += 1;
				} else {
					remainSum = totalSum - num2;
					right -= 1;
				}

				if (remainSum < s) {
					break;
				} else {
					totalSum = remainSum;
					res -= 1;
				}
			}

			System.out.println(left + " " + right);
			return res;
		}
	}

	public void testMinSubArrayLen() {
		int s = 7;
		int[] nums = { 2, 3, 1, 2, 4, 3, 7, 8, 5, 1, 1 };
		System.out.println(minSubArrayLen(s, nums));
	}

	/**
	 * Longest Palindromic Substring.
	 */
	public String longestPalindrome(String s) {

		return null;
	}
}
