package leetcode;

/**
 * Symmetric Tree.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution101 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// iteratively:
	public boolean isSymmetric(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;

		TreeNode[] nodes1 = { root };
		TreeNode[] nodes2;
		int size = 2;
		while (true) {
			nodes2 = new TreeNode[size];

			// fill:
			for (int i = 0; i < nodes1.length; i++) {
				TreeNode p = nodes1[i];
				if (p == null) {
					nodes2[2 * i] = null;
					nodes2[2 * i + 1] = null;
				} else {
					nodes2[2 * i] = p.left;
					nodes2[2 * i + 1] = p.right;
				}
			}

			// check:
			for (int i = 0; i < size / 2; i++) {
				if (nodes2[i] == null && nodes2[size - 1 - i] == null)
					continue;

				if ((nodes2[i] == null && nodes2[size - 1 - i] != null)
						|| (nodes2[i] != null && nodes2[size - 1 - i] == null)
						|| (nodes2[i].val != nodes2[size - i - 1].val)) {
					return false;
				}
			}
			boolean flag = true;
			for (TreeNode x : nodes2) {
				if (x != null) {
					flag = false;
					break;
				}
			}
			if (flag)
				return true;

			// update:
			nodes1 = nodes2;
			size <<= 1;
		}
	}

	public static void main(String[] args) {
		Solution101 solution = new Solution101();

		TreeNode root = solution.new TreeNode(1);
		TreeNode p1 = solution.new TreeNode(2);
		TreeNode p2 = solution.new TreeNode(2);
		TreeNode p3 = solution.new TreeNode(3);
		TreeNode p4 = solution.new TreeNode(3);

		root.left = p1;
		root.right = p2;
		p1.right = p3;
		p2.left = p4;

		System.out.println(solution.isSymmetric(root));
	}

}
