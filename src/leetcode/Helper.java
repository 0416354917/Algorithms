package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper.
 * 
 * <p>
 * <b>Description: </b>...
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>...
 * </p>
 * 
 * <p>
 * <b>Reference: </b>...
 * </p>
 * 
 * <p>
 * <b>Note: </b>...
 * <p>
 * 
 * <p>
 * <b>Status: </b>...
 * </p>
 * 
 * @author Jason
 *
 */
public class Helper {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * Definition for a binary tree node.
	 * 
	 * @author Jason
	 *
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
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

	public static void printMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				System.out.print(matrix[row][col]);
				if (col != cols - 1)
					System.out.print(" ");
			}
			System.out.println();
		}
	}

	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		StringBuffer sb = new StringBuffer();
		strs.stream().forEach(x -> sb.append(x.length() + "," + x + ","));
		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		List<String> ans = new ArrayList<>();
		int i = 0;
		while (i < s.length()) {
			StringBuffer sb = new StringBuffer();
			while (i < s.length() && Character.isDigit(s.charAt(i))) {
				sb.append(s.charAt(i));
				i++;
			}
			int length = Integer.parseInt(sb.toString());

			if (length != 0) {
				int j = 0;
				sb = new StringBuffer();
				while (j < length) {
					j++;
					i++;
					sb.append(s.charAt(i));
				}
				ans.add(sb.toString());
				i++;
			} else {
				ans.add("");
				i++;
			}
			i++;
		}
		return ans;
	}

	public static void main(String[] args) {
		Helper sol = new Helper();

		// for (int i = 0; i < 5; i++) {
		// System.out.println(i + "a");
		// if (i == 2) {
		// i++;
		// }
		// }

		List<String> strs = new ArrayList<>();
		strs.add("0");
		String code = sol.encode(strs);
		System.out.println(code);

		List<String> ans = sol.decode(code);
		ans.stream().forEach(x -> System.out.println(x));

		// LinkedList<TreeNode> sta = new LinkedList<>();
		// sta.add

	}

}
