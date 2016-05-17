package leetcode;

/**
 * Range Sum Query - Mutable.
 * 
 * <p>
 * <b>Algorithm: Binary Indexed Tree.</b>
 * </p>
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * References:
 * (1)YouTube: https://www.youtube.com/watch?v=CWDQJGaN1gY.
 * (2)StackExchange: http://cs.stackexchange.com/questions/10538/bit-what-is-the-intuition-behind-a-binary-indexed-tree-and-how-was-it-thought-a.
 * 
 * 
 * @author Jason
 *
 */

public class Solution307 {

	public class NumArray {
		public int[] nums;
		public int[] bit;
		public boolean constructed = false;

		public NumArray(int[] nums) {
			this.nums = nums;
			this.bit = new int[nums.length + 1];
			for (int i = 0; i < bit.length; i++) {
				bit[i] = 0;
			}
			for (int i = 0; i < bit.length - 1; i++) {
				// updateBIT(i, nums[i] + bit[i + 1]);
				update(i, nums[i]);
			}
			this.constructed = true;
		}

		// void updateBIT(int i, int val) {
		// int dif = val - bit[i + 1];
		//
		// while (i < bit.length - 1) {
		// bit[i + 1] += dif;
		// i = getNext(i + 1) - 1;
		// }
		// }

		void update(int i, int val) {
			int dif = 0;

			if (this.constructed == false) {
				dif = val;
			} else {
				dif = val - nums[i];
			}

			nums[i] = val;

			while (i < bit.length - 1) {
				bit[i + 1] += dif;
				i = getNext(i + 1) - 1;
			}

			// System.out.println("update binary indexed tree:");
			// for (int k : bit) {
			// System.out.print(k + ", ");
			// }
			// System.out.println();
		}

		public int sumRange(int i, int j) {
			int index1 = i;
			int sum1 = 0;
			while (index1 > 0) {
				sum1 += bit[index1];
				index1 = getParent(index1);
			}

			// System.out.println("sum1 = " + sum1);

			int index2 = j + 1;
			int sum2 = 0;
			while (index2 > 0) {
				sum2 += bit[index2];
				index2 = getParent(index2);
			}

			// System.out.println("sum2 = " + sum2);

			return sum2 - sum1;
		}

		public int getNext(int index) {
			return index + (index & -index);
		}

		public int getParent(int index) {
			return index - (index & -index);
		}
	}

	public static void main(String[] args) {
		Solution307 solution = new Solution307();

		// int[] nums = { 1, 3, 5 };
		int[] nums = { 7, 2, 7, 2, 0 };

		NumArray numArray = solution.new NumArray(nums);

		numArray.update(4, 6);
		numArray.nums[4] = 6;
		numArray.update(0, 2);
		numArray.nums[0] = 2;
		numArray.update(0, 9);
		numArray.nums[0] = 9;
		System.out.println(numArray.sumRange(4, 4));
		numArray.update(3, 8);
		numArray.nums[3] = 8;
		System.out.println(numArray.sumRange(0, 4));

		// System.out.println(numArray.sumRange(0, 0));

		// System.out.println(numArray.sumRange(0, 1));
		// numArray.update(1, 10);
		// System.out.println(numArray.sumRange(1, 2));
	}

}
