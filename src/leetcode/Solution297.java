package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Serialize and Deserialize Binary Tree.
 * 
 * <p>
 * <b>Description: </b>Serialization is the process of converting a data
 * structure or object into a sequence of bits so that it can be stored in a
 * file or memory buffer, or transmitted across a network connection link to be
 * reconstructed later in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Tree, Design.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution297 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null)
				return null;

			StringBuffer sb = new StringBuffer();

			List<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while (!queue.isEmpty()) {
				TreeNode p = queue.remove(0);
				if (p == null) {
					sb.append("#,");
				} else {
					sb.append(Integer.toString(p.val) + ",");
					queue.add(p.left);
					queue.add(p.right);
				}
			}

			sb.deleteCharAt(sb.length() - 1);

			return sb.toString();
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data == null) {
				return null;
			}

			String[] code = data.split(",");

			int index = 0;
			List<TreeNode> queue = new LinkedList<TreeNode>();
			while (index < code.length) {
				String s = code[index];
				if (s.equals("#"))
					queue.add(null);
				else
					queue.add(new TreeNode(Integer.parseInt(s)));
				index++;
			}

			TreeNode root = queue.get(0);

			int i = 0, j = 1;
			while (j < code.length) {
				TreeNode p = queue.get(i);
				if (p == null) {
					i++;
					continue;
				} else {
					p.left = queue.get(j);
					j++;
					p.right = queue.get(j);
					j++;
					i++;
				}
			}

			return root;
		}
	}

	/**
	 * In-order traversal of a binary tree.
	 * 
	 * @param root
	 */
	public void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.val + "  ");
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		Solution297 solution = new Solution297();

		TreeNode p1 = solution.new TreeNode(1);
		TreeNode p2 = solution.new TreeNode(2);
		TreeNode p3 = solution.new TreeNode(3);
		TreeNode p4 = solution.new TreeNode(4);
		TreeNode p5 = solution.new TreeNode(5);

		p1.left = p2;
		p1.right = p3;
		p3.left = p4;
		p3.right = p5;

		TreeNode root = p1;

		solution.inorder(root);

		Codec codec = solution.new Codec();

		String code = codec.serialize(root);
		System.out.println("\n\ncode: " + code);

		TreeNode ans = codec.deserialize(code);

		System.out.println("\n\nreconstruct:");
		solution.inorder(ans);
	}

}
