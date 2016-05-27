package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Minimum Height Trees.
 * 
 * <p>
 * <b>Description: </b>For a undirected graph with tree characteristics, we can
 * choose any node as the root. The result graph is then a rooted tree. Among
 * all possible rooted trees, those with minimum height are called minimum
 * height trees (MHTs). Given such a graph, write a function to find all the
 * MHTs and return a list of their root labels.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Graph, Breadth-first Search.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution310 {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> ans = new ArrayList<Integer>();

		if (n == 1) {
			ans.add(0);
			return ans;
		}

		Map<Integer, List<Integer>> nodeList = new HashMap<Integer, List<Integer>>();
		Map<Integer, Integer> degree = new HashMap<Integer, Integer>();

		for (int i = 0; i < edges.length; i++) {
			int v1 = edges[i][0];
			int v2 = edges[i][1];

			List<Integer> list1 = nodeList.get(v1);
			if (list1 == null) {
				list1 = new ArrayList<Integer>();
				nodeList.put(v1, list1);
			}
			list1.add(v2);

			List<Integer> list2 = nodeList.get(v2);
			if (list2 == null) {
				list2 = new ArrayList<Integer>();
				nodeList.put(v2, list2);
			}
			list2.add(v1);

			int d1 = degree.getOrDefault(v1, 0);
			degree.put(v1, d1 + 1);

			int d2 = degree.getOrDefault(v2, 0);
			degree.put(v2, d2 + 1);
		}

		while (true) {
			for (int key : degree.keySet()) {
				if (degree.get(key) <= 1) {
					ans.add(key);
				}
			}

			for (int x : ans) {
				degree.remove(x);
				for (int y : nodeList.get(x)) {
					if (degree.containsKey(y)) {
						int d = degree.get(y);
						degree.put(y, d - 1);
					}
				}
			}

			if (degree.isEmpty())
				break;
			else
				ans.clear();
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution310 solution = new Solution310();

		int n = 4;
		int[][] edges = { { 1, 0 }, { 1, 2 }, { 1, 3 } };

		List<Integer> ans = solution.findMinHeightTrees(n, edges);
		System.out.print("[ ");
		ans.stream().forEach(x -> System.out.print(x + " "));
		System.out.println("]");

		int n1 = 6;
		int[][] edges1 = { { 0, 3 }, { 1, 3 }, { 2, 3 }, { 4, 3 }, { 5, 4 } };
		List<Integer> ans1 = solution.findMinHeightTrees(n1, edges1);
		System.out.print("[ ");
		ans1.stream().forEach(x -> System.out.print(x + " "));
		System.out.println("]");
	}

}
