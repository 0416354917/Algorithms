package leetcode;

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
 * <b>Algorithm: </b>Tree, Recursion.
 * </p>
 * 
 * <p>
 * <b>Reference: </b>
 * {@link http://www.programcreek.com/2013/02/leetcode-binary-tree-maximum-path-sum-java/}
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
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

	public int maxPathSum(TreeNode root) {
		int[] max = { Integer.MIN_VALUE };
		calculateSum(root, max);
		return max[0];
	}

	public int calculateSum(TreeNode root, int[] max) {
		if (root == null)
			return 0;

		int leftSum = calculateSum(root.left, max);
		int rightSum = calculateSum(root.right, max);

		int current = Math.max(root.val,
				Math.max(root.val + leftSum, root.val + rightSum));

		max[0] = Math.max(max[0],
				Math.max(current, leftSum + root.val + rightSum));

		return current;
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
