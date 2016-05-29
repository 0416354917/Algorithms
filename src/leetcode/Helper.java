package leetcode;

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
 * <b>Reference: </b>
 * {@link https://leetcode.com/discuss/87685/template-subarray-substring-substring-repeating-characters}
 * </p>
 * 
 * <p>
 * <b>Note: </b>
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

	public static void main(String[] args) {
		Helper solution = new Helper();

		ListNode p1 = solution.new ListNode(1);
		ListNode p2 = solution.new ListNode(2);
		ListNode p3 = solution.new ListNode(3);
		ListNode p4 = solution.new ListNode(3);
		ListNode p5 = solution.new ListNode(2);
		ListNode p6 = solution.new ListNode(2);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;
	}

}
