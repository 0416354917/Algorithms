package leetcode;

/**
 * Range Sum Query - Immutable.
 * 
 * <p>
 * <b>Status: MLE.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution303 {
	public class NumArray {
		int[] array;
		int[][] matrix;

		public void printMatrix(int[][] matrix) {
			int rows = matrix.length;
			int cols = matrix[0].length;
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					System.out.print(matrix[row][col]);
					if (col != cols - 1)
						System.out.print(" ");
				}
				System.out.println();
			}
		}

		public NumArray(int[] nums) {
			this.array = nums;
			if (this.array != null && this.array.length != 0)
				init();
		}

		public void init() {
			this.matrix = new int[array.length][array.length];
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					matrix[i][j] = 0;
				}
			}
			matrix[0][0] = array[0];
			for (int col = 1; col < array.length; col++)
				matrix[0][col] = matrix[0][col - 1] + array[col];
			for (int row = 1; row < array.length; row++) {
				for (int col = 0; col < array.length; col++) {
					if (row > col)
						continue;
					else if (row == col) {
						matrix[row][col] = array[row];
					} else {
						matrix[row][col] = matrix[row][col - 1] + array[col];
					}
				}
			}
		}

		public int sumRange(int i, int j) {
			if (this.array == null || this.array.length == 0
					|| i >= this.array.length)
				return 0;
			if (j >= this.array.length)
				j = this.array.length - 1;
			return this.matrix[i][j];
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
