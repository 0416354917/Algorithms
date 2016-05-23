package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Unique Binary Search Trees II.
 * 
 * <p>
 * <b>Description: </b>Given n, generate all structurally unique BST's (binary
 * search trees) that store values 1...n.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Tree, Recursion.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution95 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> ans = new ArrayList<TreeNode>();

		if (n == 0)
			return ans;

		for (int v = 1; v <= n; v++) {
			TreeNode head = null;

			List<TreeNode> leftSubTree = new ArrayList<TreeNode>();
			if (v - 1 >= 1) {
				leftSubTree = generateSubTree(1, v - 1);
			}
			if (leftSubTree.size() == 0) {
				leftSubTree.add(null);
			}

			List<TreeNode> rightSubTree = new ArrayList<TreeNode>();
			if (v + 1 <= n) {
				rightSubTree = generateSubTree(v + 1, n);
			}
			if (rightSubTree.size() == 0) {
				rightSubTree.add(null);
			}

			for (TreeNode left : leftSubTree) {
				for (TreeNode right : rightSubTree) {
					head = new TreeNode(v);
					head.left = left;
					head.right = right;
					ans.add(head);
				}
			}
		}

		return ans;
	}

	public List<TreeNode> generateSubTree(int start, int end) {
		List<TreeNode> ans = new ArrayList<TreeNode>();

		for (int v = start; v <= end; v++) {
			TreeNode head = null;

			List<TreeNode> leftSubTree = new ArrayList<TreeNode>();
			if (v - 1 >= start) {
				leftSubTree = generateSubTree(start, v - 1);
			}
			if (leftSubTree.size() == 0) {
				leftSubTree.add(null);
			}

			List<TreeNode> rightSubTree = new ArrayList<TreeNode>();
			if (v + 1 <= end) {
				rightSubTree = generateSubTree(v + 1, end);
			}
			if (rightSubTree.size() == 0) {
				rightSubTree.add(null);
			}

			for (TreeNode left : leftSubTree) {
				for (TreeNode right : rightSubTree) {
					head = new TreeNode(v);
					head.left = left;
					head.right = right;
					ans.add(head);
				}
			}
		}

		return ans;
	}

	public void inorder(TreeNode root) {
		if (root == null)
			return;
		else {
			inorder(root.left);
			System.out.print(root.val + "  ");
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		Solution95 solution = new Solution95();

		int n = 3;
		List<TreeNode> ans = solution.generateTrees(n);
		int i = 1;
		for (TreeNode head : ans) {
			System.out.print("#" + i + ": ");
			solution.inorder(head);
			System.out.println();
			i++;
		}
	}

}
