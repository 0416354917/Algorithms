package leetcode;

/**
 * Search a 2D Matrix II.
 * 
 * <p>
 * We can treat the left bottom as a root of a BST so we only need o(m+N) to
 * find the target.
 * {@link https://leetcode.com/discuss/103099/my-c-soluation-using-binary-search-tree-model-beats-100%25}
 * </p>
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution240 {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix[0].length == 0 || matrix[0][0] > target)
			return false;

		int rows = matrix.length;
		int cols = matrix[0].length;
		int row = rows - 1, col = 0;
		while (row >= 0 && col < cols) {
			if (target > matrix[row][col]) {
				col++;
			} else if (target < matrix[row][col]) {
				row--;
			} else {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int m = 5, n = 5;
		int x = 1;
		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = x++;
			}
		}

		int target1 = 5;
		int target2 = 27;
		System.out.println(new Solution240().searchMatrix(matrix, target1));
		System.out.println(new Solution240().searchMatrix(matrix, target2));
	}

}
