package leetcode;

/**
 * Longest Increasing Path in a Matrix.
 * 
 * Status:
 * 
 * @author Jason
 *
 */
public class Solution329 {

	public int longestIncreasingPath(int[][] matrix) {
		int rtn = 0;

		int n = matrix.length;
		int m = matrix[0].length;
		int[][] answer = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				answer[i][j] = 0;
			}
		}
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (answer[row][col] != 0)
					continue;
				else {
					// depth-first:
				}
			}
		}

		return rtn;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
