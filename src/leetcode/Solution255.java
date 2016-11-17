package leetcode;

public class Solution255 {

	public boolean verifyPreorder(int[] preorder) {
		if (preorder == null || preorder.length < 3) {
			return true;
		}

		return true;
	}

	public static void main(String[] args) {
		Solution255 solution = new Solution255();

		int[] preorder = { 1, 3, 4, 2 };
		System.out.println(solution.verifyPreorder(preorder)); // false.
	}

}
