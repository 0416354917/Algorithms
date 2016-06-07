package leetcode;

/**
 * Count Univalue Subtrees.
 * 
 * <p>
 * <b>Description: </b>Given a binary tree, count the number of uni-value
 * subtrees.
 * 
 * A Uni-value subtree means all nodes of the subtree have the same value.
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
public class Solution250 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int countUnivalSubtrees(TreeNode root) {
		int[] ans = { 0 };
		isUnivalSubtree(root, ans);
		return ans[0];
	}

	public boolean isUnivalSubtree(TreeNode root, int[] ans) {
		if (root == null) {
			return false;
		} else if (root.left == null && root.right == null) {
			ans[0]++;
			return true;
		} else if (root.left != null && root.right == null) {
			boolean left = isUnivalSubtree(root.left, ans);
			if (left == true && root.val == root.left.val) {
				ans[0]++;
				return true;
			} else
				return false;
		} else if (root.left == null && root.right != null) {
			boolean right = isUnivalSubtree(root.right, ans);
			if (right == true && root.val == root.right.val) {
				ans[0]++;
				return true;
			} else
				return false;
		} else {
			boolean left = isUnivalSubtree(root.left, ans);
			boolean right = isUnivalSubtree(root.right, ans);

			if (left && right && root.val == root.left.val
					&& root.val == root.right.val) {
				ans[0]++;
				return true;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		Solution250 solution = new Solution250();

		TreeNode p1 = solution.new TreeNode(5);
		TreeNode p2 = solution.new TreeNode(1);
		TreeNode p3 = solution.new TreeNode(5);
		TreeNode p4 = solution.new TreeNode(5);
		TreeNode p5 = solution.new TreeNode(5);
		TreeNode p6 = solution.new TreeNode(5);

		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p2.right = p5;
		p3.right = p6;

		System.out.println(solution.countUnivalSubtrees(p1));
	}

}
