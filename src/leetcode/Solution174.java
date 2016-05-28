package leetcode;

/**
 * Dungeon Game.
 * 
 * <p>
 * <b>Description: </b>The demons had captured the princess (P) and imprisoned
 * her in the bottom-right corner of a dungeon. The dungeon consists of M x N
 * rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned
 * in the top-left room and must fight his way through the dungeon to rescue the
 * princess.
 * 
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health (negative
 * integers) upon entering these rooms; other rooms are either empty (0's) or
 * contain magic orbs that increase the knight's health (positive integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to
 * move only rightward or downward in each step.
 * 
 * 
 * Write a function to determine the knight's minimum initial health so that he
 * is able to rescue the princess.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Dynamic Programming.
 * </p>
 * 
 * <p>
 * <b>Status: </b>...
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution174 {

	public int calculateMinimumHP(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
			return 0;

		int n = dungeon.length;
		int m = dungeon[0].length;

		int[][] dp = new int[n][m];
		dp[0][0] = dungeon[0][0] >= 0 ? 1 : -dungeon[0][0] + 1;

		int row = 0, col = 0;
		for (row = n - 1; row >= 0; row--) {
			for (col = m - 1; col >= 0; col--) {

			}
		}

		return 0;
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
		Solution174 solution = new Solution174();

		// int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		// // 7
		// System.out.println(solution.calculateMinimumHP(dungeon));

		int[][] dungeon2 = { { 1, -3, 3 }, { 0, -2, 0 }, { -3, -3, -3 } }; // 3
		System.out.println(solution.calculateMinimumHP(dungeon2));

		int[] a = new int[5];
		System.out.println(a[0]);

	}

}
