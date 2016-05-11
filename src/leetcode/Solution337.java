package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * House Robber III
 * 
 * Status: WA.
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
		int result1 = 0, result2 = 0;

		List<TreeNode> list;
		List<TreeNode> list1 = new LinkedList<TreeNode>();
		List<TreeNode> list2 = new LinkedList<TreeNode>();

		if (root == null)
			return 0;

		list1.add(root);
		result1 = root.val;
		list = list1;
		while (!list.isEmpty()) {
			TreeNode node = list.remove(0);

			if (list == list1) {
				if (node.left != null) {
					list2.add(node.left);
					result2 += node.left.val;
				}
				if (node.right != null) {
					list2.add(node.right);
					result2 += node.right.val;
				}
				if (list.isEmpty()) {
					list = list2;
					continue;
				}
			}

			if (list == list2) {
				if (node.left != null) {
					list1.add(node.left);
					result1 += node.left.val;
				}
				if (node.right != null) {
					list1.add(node.right);
					result1 += node.right.val;
				}
				if (list.isEmpty())
					list = list1;
			}

		}

		return result1 > result2 ? result1 : result2;
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
