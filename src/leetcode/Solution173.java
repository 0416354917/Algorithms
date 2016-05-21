package leetcode;

import java.util.Stack;

/**
 * Binary Search Tree Iterator.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution173 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class BSTIterator {

		private Stack<TreeNode> stack = new Stack<TreeNode>();

		public BSTIterator(TreeNode root) {
			pushLeft(root);
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		/** @return the next smallest number */
		public int next() {
			TreeNode p = stack.pop();
			pushLeft(p.right);
			return p.val;
		}

		public void pushLeft(TreeNode p) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
