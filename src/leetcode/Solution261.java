package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution261 {

	public boolean validTree(int n, int[][] edges) {
		// corner cases:
		if (n <= 1) {
			return true;
		}
		if (edges == null || edges.length == 0) {
			return false;
		}

		// build graph:
		Map<Integer, List<Integer>> g = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			int v1 = edges[i][0];
			int v2 = edges[i][1];

			List<Integer> nodes1 = g.get(v1);
			if (nodes1 == null) {
				nodes1 = new ArrayList<>();
				g.put(v1, nodes1);
			}
			nodes1.add(v2);

			List<Integer> nodes2 = g.get(v2);
			if (nodes2 == null) {
				nodes2 = new ArrayList<>();
				g.put(v2, nodes2);
			}
			nodes2.add(v1);
		}

		// select a root and dfs:
		int p = 0;
		boolean[] visited = new boolean[n];
		LinkedList<Integer> stack = new LinkedList<Integer>();
		stack.addLast(p);
		visited[p] = true;
		while (!stack.isEmpty()) {
			p = stack.removeLast();
			List<Integer> neighbors = g.get(p);
			if (neighbors != null) {
				for (int x : neighbors) {
					if (visited[x]) {
						if (!stack.isEmpty() && x != stack.peekLast())
							return false;
					} else {
						stack.addLast(p);
						visited[x] = true;
						stack.addLast(x);
						break;
					}
				}
			}
		}

		// check whether all nodes have been visited:
		for (boolean x : visited) {
			if (x == false) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution261 solution = new Solution261();

		int n = 5;
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 } };
		System.out.println(solution.validTree(n, edges));
	}

}
