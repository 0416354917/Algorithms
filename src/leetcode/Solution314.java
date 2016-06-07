package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Binary Tree Vertical Order Traversal.
 * 
 * <p>
 * <b>Algorithm: </b>Breadth-first Search, Hash Table.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution314 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();

		LinkedList<TreeNode> frontier = new LinkedList<>();
		Map<TreeNode, Integer> node2col = new HashMap<>();
		Map<Integer, List<Integer>> col2node = new HashMap<>();

		if (root != null) {
			int mincol = 0, maxcol = 0;
			frontier.add(root);
			node2col.put(root, 0);
			List<Integer> node = new ArrayList<>();
			node.add(root.val);
			col2node.put(0, node);
			int col = 0;
			while (!frontier.isEmpty()) {
				TreeNode p = frontier.removeFirst();
				col = node2col.get(p);
				if (p.left != null) {
					frontier.add(p.left);
					node2col.put(p.left, col - 1);
					List<Integer> x = col2node.get(col - 1);
					if (x == null) {
						x = new ArrayList<>();
						col2node.put(col - 1, x);
					}
					x.add(p.left.val);
					if (col - 1 < mincol) {
						mincol = col - 1;
					}
				}
				if (p.right != null) {
					frontier.add(p.right);
					node2col.put(p.right, col + 1);
					List<Integer> x = col2node.get(col + 1);
					if (x == null) {
						x = new ArrayList<>();
						col2node.put(col + 1, x);
					}
					x.add(p.right.val);
					if (col + 1 > maxcol) {
						maxcol = col + 1;
					}
				}
			}
			for (col = mincol; col <= maxcol; col++) {
				ans.add(col2node.get(col));
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
