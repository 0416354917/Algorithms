package leetcode;

/**
 * Spiral Matrix II.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution59 {

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

	public int[][] generateMatrix(int n) {
		// int max = n * n;
		n = n > 0 ? n : -n;
		int[][] matrix = new int[n][n];

		if (n == 0) {
			return matrix;
		}

		if (n == 1) {
			matrix[0][0] = 1;
			return matrix;
		}

		int row = 0, col = 0;
		int x = 1;
		int offset = 0;
		while (offset < n / 2) {
			// right:
			for (col = offset; col < n - offset - 1; col++)
				matrix[row][col] = x++;
			// down:
			for (row = offset; row < n - offset - 1; row++)
				matrix[row][col] = x++;
			// left:
			for (col = n - 1 - offset; col > offset; col--)
				matrix[row][col] = x++;
			// up:
			for (row = n - 1 - offset; row > offset; row--)
				matrix[row][col] = x++;

			row++;
			offset++;
		}

		if (n % 2 != 0) {
			matrix[row][col + 1] = x;
		}

		return matrix;
	}

	public static void main(String[] args) {
		Solution59 solution = new Solution59();

		int n = 1;
		int[][] matrix = solution.generateMatrix(n);
		solution.printMatrix(matrix);
	}

}
