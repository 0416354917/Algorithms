package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Graph Valid Tree.
 * 
 * <p>
 * <b>Algorithm: </b>Depth-first Search, Union Find.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution261 {

	class UnionFind {
		int size = 0;
		int[] node;
		int[] parent;
		int[] rank;

		public UnionFind(int n) {
			this.size = n;
			this.node = new int[n];
			this.parent = new int[n];
			this.rank = new int[n];
			for (int i = 0; i < n; i++) {
				node[i] = i;
				parent[i] = i;
				rank[i] = 0;
			}
		}

		public void union(int x, int y) {
			int xroot = find(x);
			int yroot = find(y);
			if (rank[xroot] > rank[yroot]) {
				parent[yroot] = xroot;
			} else {
				parent[xroot] = yroot;
			}

			if (rank[xroot] == rank[yroot]) {
				rank[yroot]++;
			}
		}

		public int find(int x) {
			if (x != parent[x]) {
				parent[x] = find(parent[x]);
			}
			return x;
		}
	}

	/**
	 * Method 1: Union Find.
	 * 
	 * @param n
	 * @param edges
	 * @return
	 */
	public boolean validTree2(int n, int[][] edges) {
		// corner cases:
		if (n <= 1) {
			return true;
		}

		if (edges == null || edges.length == 0) {
			return false;
		}

		// Union-Find:
		UnionFind uf = new UnionFind(n);
		int count = n;
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int uroot = uf.find(u);
			int vroot = uf.find(v);
			if (uroot == vroot) {
				return false;
			} else {
				uf.union(u, v);
				count--;
			}
		}
		return count == 1;
	}

	/**
	 * Method 2: Depth-first Search.
	 * 
	 * @param n
	 * @param edges
	 * @return
	 */
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
		System.out.println(solution.validTree2(n, edges));
	}

}
