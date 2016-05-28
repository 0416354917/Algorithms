package leetcode;

/**
 * Count Complete Tree Nodes.
 * 
 * <p>
 * <b>Description: </b>Given a complete binary tree, count the number of nodes.
 * 
 * Definition of a complete binary tree from Wikipedia: In a complete binary
 * tree every level, except possibly the last, is completely filled, and all
 * nodes in the last level are as far left as possible. It can have between 1
 * and 2h nodes inclusive at the last level h.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Tree.
 * </p>
 * 
 * <p>
 * <b>Reference: </b>
 * {@link https://leetcode.com/discuss/101234/java-concise-solution}
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution222 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;

		int l = completeTreeHeight(root.left);
		int r = completeTreeHeight(root.right);
		if (l == r) {
			return countNodes(root.right) + (1 << l);
		} else {
			return countNodes(root.left) + (1 << r);
		}
	}

	public int completeTreeHeight(TreeNode root) {
		int height = 0;
		while (root != null) {
			height++;
			root = root.left;
		}
		return height;
	}

	public static void main(String[] args) {
		Solution222 solution = new Solution222();

		TreeNode p1 = solution.new TreeNode(1);
		TreeNode p2 = solution.new TreeNode(1);
		TreeNode p3 = solution.new TreeNode(1);
		TreeNode p4 = solution.new TreeNode(1);
		TreeNode p5 = solution.new TreeNode(1);

		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p2.right = p5;

		System.out.println(solution.countNodes(p1));
	}

}
