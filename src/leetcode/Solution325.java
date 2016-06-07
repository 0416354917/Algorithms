package leetcode;

public class Solution325 {

	public int maxSubArrayLen(int[] nums, int k) {
		int maxLength = 0;
		int p1 = 0, p2 = 0;
		int sum = 0;
		while (p2 < nums.length) {
			sum += nums[p2];
			if (sum == k) {
				maxLength = Math.max(maxLength, p2 - p1 + 1);
				sum -= nums[p1];
				p1++;
			}
			p2++;
		}

		return maxLength;
	}

	public static void main(String[] args) {
		Solution325 solution = new Solution325();

		int[] nums = { 1, -1, 5, -2, 3 };
		int k = 3;
		System.out.println(solution.maxSubArrayLen(nums, k));

		int[] nums2 = { -2, -1, 2, 1 };
		int k2 = 1;
		System.out.println(solution.maxSubArrayLen(nums2, k2));
	}

}
