package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution296 {

	public int minTotalDistance(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		List<Integer> row = new ArrayList<Integer>();
		List<Integer> col = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					row.add(i);
					col.add(j);
				}
			}
		}

		int x = row.get(row.size() / 2);
		Collections.sort(col);
		int y = col.get(col.size() / 2);

		int ans = 0;

		for (int v : row)
			ans += Math.abs(x - v);
		for (int v : col)
			ans += Math.abs(y - v);

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
