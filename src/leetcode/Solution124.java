package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Binary Tree Maximum Path Sum.
 * 
 * <p>
 * <b>Description: </b>Given a binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections. The
 * path does not need to go through the root.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>...
 * </p>
 * 
 * <p>
 * <b>Status: </b>...
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution124 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int ans = 0;

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			List<Integer> arr = new ArrayList<Integer>();

			int leftSum = maxPathSum(root.left);
			int rightSum = maxPathSum(root.right);

			// if (root.left != null) {
			// arr.add(leftSum);
			// }
			//
			// if (root.right != null) {
			// arr.add(rightSum);
			// }

			arr.add(root.val);
			arr.add(leftSum + root.val);
			arr.add(root.val + rightSum);
			arr.add(leftSum + root.val + rightSum);

			Collections.sort(arr);
			ans = Math.max(ans, arr.get(arr.size() - 1));

			// return arr.get(arr.size() - 1);
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution124 solution = new Solution124();

		TreeNode p1 = solution.new TreeNode(-1);
		TreeNode p2 = solution.new TreeNode(2);
		TreeNode p3 = solution.new TreeNode(3);
		TreeNode p4 = solution.new TreeNode(7);
		TreeNode p5 = solution.new TreeNode(2);

		p1.left = p2;
		p1.right = p3;
		p2.right = p4;
		p3.left = p5;

		System.out.println(solution.maxPathSum(p1));
	}

}
