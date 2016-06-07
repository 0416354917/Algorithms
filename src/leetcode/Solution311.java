package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution311 {

	public int[][] multiply(int[][] A, int[][] B) {
		int n1 = A.length;
		int m1 = A[0].length;
		int n2 = B.length;
		int m2 = B[0].length;

		int[][] ans = new int[n1][m2];

		List<Map<Integer, Integer>> a = new ArrayList<>();
		List<Map<Integer, Integer>> b = new ArrayList<>();
		for (int i = 0; i < n1; i++) {
			Map<Integer, Integer> row = new HashMap<>();
			for (int j = 0; j < m1; j++) {
				if (A[i][j] != 0) {
					row.put(j, A[i][j]);
				}
			}
			a.add(row);
		}
		for (int j = 0; j < m2; j++) {
			Map<Integer, Integer> col = new HashMap<>();
			for (int i = 0; i < n2; i++) {
				if (B[i][j] != 0) {
					col.put(i, B[i][j]);
				}
			}
			b.add(col);
		}

		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < m2; j++) {
				int y = 0;
				Map<Integer, Integer> p = a.get(i), q = b.get(j);
				if (p.size() > q.size()) {
					p = b.get(j);
					q = a.get(i);
				}
				for (int key : p.keySet()) {
					if (q.containsKey(key)) {
						y += p.get(key) * q.get(key);
					}
				}
				ans[i][j] = y;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
