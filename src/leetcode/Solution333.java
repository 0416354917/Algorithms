package leetcode;

public class Solution333 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int largestBSTSubtree(TreeNode root) {
		int[] ans = { 0 };
		count(root, ans);
		return ans[0];
	}

	public int count(TreeNode root, int[] ans) {
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			ans[0] = Math.max(1, ans[0]);
			return 1;
		} else if (root.left != null && root.right == null) {
			int rtn = 0;
			int left = count(root.left, ans);
			if (left != 0 && root.val > root.left.val) {
				ans[0] = Math.max(left + 1, ans[0]);
				rtn = left + 1;
			}
			return rtn;
		} else if (root.left == null && root.right != null) {
			int rtn = 0;
			int right = count(root.right, ans);
			if (right != 0 && root.val < root.right.val) {
				ans[0] = Math.max(right + 1, ans[0]);
				rtn = right + 1;
			}
			return rtn;
		} else {
			int rtn = 0;
			int left = count(root.left, ans);
			int right = count(root.right, ans);
			if (left != 0 && root.val > root.left.val && right != 0
					&& root.val < root.right.val) {
				ans[0] = Math.max(left + right + 1, ans[0]);
				rtn = 1 + left + right;
			}
			return rtn;
		}
	}

	public static void main(String[] args) {
		Solution333 solution = new Solution333();

		TreeNode p1 = solution.new TreeNode(10);
		TreeNode p2 = solution.new TreeNode(5);
		TreeNode p3 = solution.new TreeNode(15);
		TreeNode p4 = solution.new TreeNode(1);
		TreeNode p5 = solution.new TreeNode(8);
		TreeNode p6 = solution.new TreeNode(7);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p2.right = p5;
		p3.right = p6;

		System.out.println(solution.largestBSTSubtree(p1));
	}

}
