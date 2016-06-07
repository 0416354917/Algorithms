package leetcode;

public class Solution298 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int longestConsecutive(TreeNode root) {
		int[] ans = { 0 };

		helper(root, ans);

		return ans[0];
	}

	public int helper(TreeNode root, int[] ans) {
		if (root == null) {
			return 0;
		} else {
			int rtn = 1;
			int left = helper(root.left, ans);
			int right = helper(root.right, ans);
			if (root.left != null && root.val + 1 == root.left.val) {
				rtn = Math.max(rtn, 1 + left);
			}
			if (root.right != null && root.val + 1 == root.right.val) {
				rtn = Math.max(rtn, 1 + right);
			}

			ans[0] = Math.max(ans[0], rtn);
			return rtn;
		}
	}

	public static void main(String[] args) {
		Solution298 solution = new Solution298();

		TreeNode p1 = solution.new TreeNode(1);
		TreeNode p2 = solution.new TreeNode(2);
		TreeNode p3 = solution.new TreeNode(4);
		TreeNode p4 = solution.new TreeNode(5);
		TreeNode p5 = solution.new TreeNode(6);

		p1.left = p2;
		p2.left = p3;
		p3.left = p4;
		p4.left = p5;

		System.out.println(solution.longestConsecutive(p1));
	}

}
