package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Lowest Common Ancestor of a Binary Tree.
 * 
 * <p>
 * <b>Status:</b> Accepted.
 * </p>
 * <p>
 * <b>Algorithm:</b> Tree. Find all ancestors of two queried nodes p and q, then
 * compare the two ancestors lists to find the <b>lowest common ancestor</b>. (
 * {@link https://en.wikipedia.org/wiki/Lowest_common_ancestor})
 * <p>
 * 
 * @author Jason
 *
 */
public class Solution236 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
			TreeNode q) {
		// null p or null q?

		if (p == root || q == root) {
			return root;
		}

		Set<TreeNode> explored = new HashSet<TreeNode>();
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		List<TreeNode> ans = new ArrayList<TreeNode>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode tail = stack.peekLast();
			if (tail.left != null && !explored.contains(tail.left)) {
				stack.add(tail.left);
			} else if (tail.right != null && !explored.contains(tail.right)) {
				stack.add(tail.right);
			} else {
				TreeNode x = stack.peekLast();
				if (x == p || x == q) {
					if (ans.isEmpty()) {
						Iterator<TreeNode> it = stack.iterator();
						while (it.hasNext()) {
							ans.add(it.next());
						}
					} else {
						while (!stack.isEmpty()) {
							if (ans.contains(stack.peekLast())) {
								return stack.peekLast();
							} else {
								stack.pollLast();
							}
						}
					}
				}
				explored.add(stack.pollLast());
			}
		}

		return root;
	}

	public static void main(String[] args) {
		Solution236 solution = new Solution236();

		TreeNode root = solution.new TreeNode(3);
		TreeNode p1 = solution.new TreeNode(5);
		TreeNode p2 = solution.new TreeNode(1);
		TreeNode p3 = solution.new TreeNode(6);
		TreeNode p4 = solution.new TreeNode(2);
		TreeNode p5 = solution.new TreeNode(0);
		TreeNode p6 = solution.new TreeNode(8);
		TreeNode p7 = solution.new TreeNode(7);
		TreeNode p8 = solution.new TreeNode(4);

		root.left = p1;
		root.right = p2;
		p1.left = p3;
		p1.right = p4;
		p2.left = p5;
		p2.right = p6;
		p4.left = p7;
		p4.right = p8;

		System.out.println(solution.lowestCommonAncestor(root, p1, p2).val);
		System.out.println(solution.lowestCommonAncestor(root, p1, p8).val);
	}

}
