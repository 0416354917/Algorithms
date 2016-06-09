package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Russian Doll Envelopes.
 * 
 * <p>
 * <b>Description: </b>You have a number of envelopes with widths and heights
 * given as a pair of integers (w, h). One envelope can fit into another if and
 * only if both the width and height of one envelope is greater than the width
 * and height of the other envelope.
 * 
 * What is the maximum number of envelopes can you Russian doll? (put one inside
 * other)
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
public class Solution354 {

	/**
	 * Straight forward dynamic programming.
	 * 
	 * Runtime: 642ms.
	 * 
	 * Status: Accepted.
	 * 
	 * @param envelopes
	 * @return
	 */
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0)
			return 0;

		int ans = 0;

		Arrays.sort(envelopes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] < o2[0]) {
					return -1;
				} else if (o1[0] > o2[0]) {
					return 1;
				} else {
					if (o1[1] < o2[1]) {
						return -1;
					} else if (o1[1] > o2[1]) {
						return 1;
					} else {
						return 0;
					}
				}
			}

		});

		int n = envelopes.length;
		int[] dp = new int[n];
		dp[0] = 1;
		ans = 1;
		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			int j = i - 1;
			while (j >= 0) {
				if (envelopes[i][0] > envelopes[j][0]
						&& envelopes[i][1] > envelopes[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					ans = Math.max(ans, dp[i]);
				}
				j--;
			}
		}

		return ans;
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
		Solution354 solution = new Solution354();

		int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
		System.out.println(solution.maxEnvelopes(envelopes));
	}

}
