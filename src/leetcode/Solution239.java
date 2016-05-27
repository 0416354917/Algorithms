package leetcode;

public class Solution239 {

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return null;

		int size = nums.length - k + 1;
		int[] ans = new int[size];

		int index = 0;
		int firstMax = nums[0];
		int secondMax = firstMax;
		while (index < k) {
			if (nums[index] > firstMax) {
				if (secondMax != firstMax) {
					secondMax = firstMax;
				}
				firstMax = nums[index];
			}
			index++;
		}

		int pos = 0;
		ans[pos] = firstMax;

		while (index < nums.length) {
			int last = nums[index - k];

			pos++;

			// int t = nums[index];
			if (last == firstMax) {

			}

			index++;
		}

		return ans;

	}

	public static void main(String[] args) {
		Solution239 solution = new Solution239();

		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;

		int[] ans = solution.maxSlidingWindow(nums, k);
		for (int x : ans)
			System.out.println(x);
	}

}
