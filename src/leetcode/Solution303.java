package leetcode;

/**
 * Range Sum Query - Immutable.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution303 {
	public class NumArray {
		int[] array;
		int[] dp;

		public NumArray(int[] nums) {
			this.array = nums;
			if (this.array != null && this.array.length != 0)
				init();
		}

		public void init() {
			this.dp = new int[this.array.length];
			this.dp[0] = this.array[0];
			for (int i = 1; i < dp.length; i++)
				dp[i] = dp[i - 1] + array[i];
		}

		public int sumRange(int i, int j) {
			if (this.array == null || this.array.length == 0
					|| i >= this.array.length)
				return 0;
			if (j >= this.array.length)
				j = this.array.length - 1;

			int min = (i == 0) ? 0 : dp[i - 1];
			return this.dp[j] - min;
		}
	}

	public static void main(String[] args) {
		int[] nums = { -2, 0, 3, -5, 2, -1 };
		// int[] nums = null;
		Solution303 solution = new Solution303();
		NumArray numArray = solution.new NumArray(nums);
		System.out.println(numArray.sumRange(0, 2));
		System.out.println(numArray.sumRange(2, 5));
		System.out.println(numArray.sumRange(0, 5));
		System.out.println(numArray.sumRange(6, 5));
		System.out.println(numArray.sumRange(5, 7));
	}

}
