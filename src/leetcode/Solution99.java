package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Recover Binary Search Tree.
 * 
 * <p>
 * <b>Description: </b>Two elements of a binary search tree (BST) are swapped by
 * mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note: A solution using O(n) space is pretty straight forward. Could you
 * devise a constant space solution?
 * 
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>...
 * </p>
 * 
 * <p>
 * <b>Reference: </b>...
 * </p>
 * 
 * <p>
 * <b>Note: </b>...
 * <p>
 * 
 * <p>
 * <b>Status: </b>...
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution99 {

	/**
	 * Definition for a binary tree node.
	 * 
	 * @author Jason
	 *
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * In-order traversal of a binary tree.
	 * 
	 * @param root
	 */
	public void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.val + "  ");
			inorder(root.right);
		}
	}

	public void recoverTree(TreeNode root) {
		if (root == null)
			return;

		TreeNode x = null, xp = null, xl = null, xr = null;
		TreeNode y = null, yp = null, yl = null, yr = null;

		Set<TreeNode> explored = new HashSet<TreeNode>();
		List<TreeNode> frontier = new LinkedList<TreeNode>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			TreeNode p = frontier.remove(0);
			TreeNode l = p.left;
			if (l != null) {
				if (!explored.contains(l)) {

				}
			}
		}
	}

	public static void main(String[] args) {
		Solution99 solution = new Solution99();

		TreeNode p1 = solution.new TreeNode(3);
		TreeNode p2 = solution.new TreeNode(1);
		TreeNode p3 = solution.new TreeNode(2);
		TreeNode p4 = solution.new TreeNode(4);
		TreeNode p5 = solution.new TreeNode(5);

		TreeNode root = p1;
		p1.left = p2;
		p1.right = p3;
		p2.right = p4;
		p3.right = p5;

		System.out.println("Before recovery:");
		solution.inorder(root);

		solution.recoverTree(root);

		System.out.println("\nAfter recovery:");
		solution.inorder(root);
	}

}
