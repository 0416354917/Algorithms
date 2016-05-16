package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Kth Smallest Element in a BST.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution230 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void inorder(TreeNode root, List<Integer> ans, int k) {
		if (ans.size() == k || root == null) {
			return;
		} else {
			inorder(root.left, ans, k);
			if (ans.size() == k)
				return;
			ans.add(root.val);
			if (ans.size() == k)
				return;
			inorder(root.right, ans, k);
			if (ans.size() == k)
				return;
		}
	}

	public int kthSmallest(TreeNode root, int k) {
		List<Integer> ans = new ArrayList<Integer>();
		inorder(root, ans, k);
		return ans.get(ans.size() - 1);
	}

	public static void main(String[] args) {
		Solution230 solution = new Solution230();

		TreeNode root = solution.new TreeNode(2);
		TreeNode p1 = solution.new TreeNode(1);
		root.left = p1;

		int k = 1;

		System.out.println(solution.kthSmallest(root, k));
	}

}
