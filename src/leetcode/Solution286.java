package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Walls and Gates.
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution286 {

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void wallsAndGates(int[][] rooms) {
		if (rooms == null || rooms.length == 0 || rooms[0].length == 0)
			return;

		int n = rooms.length;
		int m = rooms[0].length;
		List<Point> point = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (rooms[i][j] == 0) {
					point.add(new Point(i, j));
				}
			}
		}
		while (!point.isEmpty()) {
			List<Point> next = new ArrayList<>();
			for (Point p : point) {
				if (p.y - 1 >= 0 && rooms[p.x][p.y - 1] > rooms[p.x][p.y] + 1) {
					rooms[p.x][p.y - 1] = rooms[p.x][p.y] + 1;
					next.add(new Point(p.x, p.y - 1));
				}
				if (p.x - 1 >= 0 && rooms[p.x - 1][p.y] > rooms[p.x][p.y] + 1) {
					rooms[p.x - 1][p.y] = rooms[p.x][p.y] + 1;
					next.add(new Point(p.x - 1, p.y));
				}
				if (p.y + 1 < m && rooms[p.x][p.y + 1] > rooms[p.x][p.y] + 1) {
					rooms[p.x][p.y + 1] = rooms[p.x][p.y] + 1;
					next.add(new Point(p.x, p.y + 1));
				}
				if (p.x + 1 < n && rooms[p.x + 1][p.y] > rooms[p.x][p.y] + 1) {
					rooms[p.x + 1][p.y] = rooms[p.x][p.y] + 1;
					next.add(new Point(p.x + 1, p.y));
				}
			}
			point.clear();
			point = next;
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
		int[][] rooms = { { 2147483647, -1, 0, 2147483647 },
				{ 2147483647, 2147483647, 2147483647, -1 },
				{ 2147483647, -1, 2147483647, -1 },
				{ 0, -1, 2147483647, 2147483647 } };
		printMatrix(rooms);
		System.out.println();
		Solution286 solution = new Solution286();
		solution.wallsAndGates(rooms);
		printMatrix(rooms);
	}

}