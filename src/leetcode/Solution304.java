package leetcode;

/**
 * Range Sum Query 2D - Immutable.
 * 
 * <p>
 * <b>Description: </b>Given a 2D matrix matrix, find the sum of the elements
 * inside the rectangle defined by its upper left corner (row1, col1) and lower
 * right corner (row2, col2).
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Dynamic Programming.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution304 {

	public class NumMatrix {

		int[][] dp;

		public NumMatrix(int[][] matrix) {
			if (matrix != null && matrix.length != 0) {
				int rows = matrix.length;
				int cols = matrix[0].length;

				dp = new int[rows][cols];

				dp[0][0] = matrix[0][0];

				int row = 1, col = 1;
				while (col < cols) {
					dp[0][col] = dp[0][col - 1] + matrix[0][col];
					col++;
				}

				while (row < rows) {
					dp[row][0] = dp[row - 1][0] + matrix[row][0];
					row++;
				}

				for (row = 1; row < rows; row++) {
					for (col = 1; col < cols; col++) {
						dp[row][col] = matrix[row][col] + dp[row - 1][col]
								+ dp[row][col - 1] - dp[row - 1][col - 1];
					}
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			int left = col1 - 1 < 0 ? 0 : dp[row2][col1 - 1];
			int up = row1 - 1 < 0 ? 0 : dp[row1 - 1][col2];
			int corner = (row1 - 1 < 0 || col1 - 1 < 0) ? 0
					: dp[row1 - 1][col1 - 1];
			return dp[row2][col2] - left - up + corner;
		}
	}

	public static void printMatrix(int[][] matrix) {
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

	public static void main(String[] args) {
		Solution304 solution = new Solution304();

		int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 },
				{ 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } };

		NumMatrix numMatrix = solution.new NumMatrix(matrix);

		System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
		System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
		System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
	}

}
