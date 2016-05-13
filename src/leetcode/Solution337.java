package leetcode;

/**
 * House Robber III
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution337 {

	class TreeNode {
		int val;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int x) {
			val = x;
		}
	}

	public int rob(TreeNode root) {
		int money1 = 0, money2 = 0;

		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return root.val;
		} else if (root.left != null && root.right == null) {
			money1 = root.val + rob(root.left.left) + rob(root.left.right);
			money2 = rob(root.left);
		} else if (root.left == null && root.right != null) {
			money1 = root.val + rob(root.right.left) + rob(root.right.right);
			money2 = rob(root.right);
		} else {
			money1 = root.val + rob(root.left.left) + rob(root.left.right)
					+ rob(root.right.left) + rob(root.right.right);
			money2 = rob(root.left) + rob(root.right);
		}

		return money1 > money2 ? money1 : money2;
	}

	public static void main(String[] args) {
		Solution337 solution = new Solution337();

		TreeNode root = solution.new TreeNode(3);
		TreeNode node1 = solution.new TreeNode(2);
		TreeNode node2 = solution.new TreeNode(3);
		root.left = node1;
		root.right = node2;
		TreeNode node3 = solution.new TreeNode(3);
		TreeNode node4 = solution.new TreeNode(1);
		node1.right = node3;
		node2.right = node4;

		System.out.println(solution.rob(root));
	}

}
