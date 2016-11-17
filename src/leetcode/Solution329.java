package leetcode;

import java.util.LinkedList;

/**
 * Longest Increasing Path in a Matrix.
 * 
 * Status:
 * 
 * @author Jason
 *
 */
public class Solution329 {

	class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	/**
	 * Depth-first Search & Memoization.
	 * 
	 * 
	 * @param matrix
	 * @return
	 */
	public int longestIncreasingPath(int[][] matrix) {
		int ans = 0;

		int n = matrix.length;
		int m = matrix[0].length;

		// Initialization.
		int[][] mem = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mem[i][j] = 0; // mark.
			}
		}

		// Loop.
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (mem[row][col] != 0)
					continue;
				else {
					// Depth-first.
					LinkedList<Point> stack = new LinkedList<>();
					stack.add(new Point(row, col));
					int path = 1;
					while (!stack.isEmpty()) {
						Point p = stack.peekLast();
						int val = matrix[p.x][p.y];
						if (p.y - 1 >= 0) {
							if (matrix[p.x][p.y - 1] > val) {
								if (mem[p.x][p.y - 1] == 0) {
									stack.addLast(new Point(p.x, p.y - 1));
									path++;
								} else {
									// mem[p][]
								}
							}
						}

					}
				}
			}
		}

		// Return.
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
