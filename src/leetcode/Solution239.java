package leetcode;

import java.util.stream.IntStream;

/**
 * Sliding Window Maximum.
 * 
 * <p>
 * <b>Description: </b>Given an array nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right. You can
 * only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Two Pointers.
 * </p>
 * 
 * <p>
 * <b>Reference: </b>
 * {@link https://leetcode.com/discuss/87685/template-subarray-substring-substring-repeating-characters}
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted (OPTIMIZED).
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution239 {

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return new int[0];

		int size = nums.length - k + 1;
		int[] ans = new int[size];

		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i = 0; i < k; i++) {
			if (nums[i] > max) {
				max = nums[i];
				maxIndex = i;
			}
		}
		ans[0] = max;

		for (int i = 1; i < size; i++) {
			if (nums[i + k - 1] > max) {
				max = nums[i + k - 1];
				maxIndex = i + k - 1;
			}

			if (maxIndex < i) {
				max = Integer.MIN_VALUE;
				for (int j = i; j < i + k; j++) {
					if (nums[j] > max) {
						max = nums[j];
						maxIndex = j;
					}
				}
			}
			ans[i] = max;
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution239 solution = new Solution239();

		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;

		int[] ans = solution.maxSlidingWindow(nums, k);
		IntStream.of(ans).forEach(x -> System.out.print(x + "  "));
	}

}
