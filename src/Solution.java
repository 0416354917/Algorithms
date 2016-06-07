import java.util.ArrayList;
import java.util.List;

public class Solution {

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

	public static List<String> generateAbbreviations(String word) {
		List<String> ans = new ArrayList<>();
		if (word == null)
			return ans;
		ans.add(word);
		for (int i = 1; i <= word.length(); i++) {
			for (int j = 0; j <= word.length() - i; j++) {
//				StringBuffer sb = new StringBuffer();
				String abbr = word.substring(0, j) + i + word.substring(j + i);
				ans.add(abbr);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		List<String> ans = generateAbbreviations("word");
		ans.stream().forEach(x -> System.out.println(x + "  "));
	}

}