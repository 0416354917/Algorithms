package leetcode;

public class Solution255 {

	public boolean verifyPreorder(int[] preorder) {
		if (preorder == null || preorder.length < 3) {
			return true;
		}

		// verify left subtree;
		int i = 1;
		for (i = 1; i < preorder.length; i++) {
			if (preorder[i] > preorder[0]) {
				break;
			}
		}
		if (i > 2) {
			int max = preorder[0];
			
		}

		int p1 = preorder[0];
		int p2 = preorder[i];
		while (i + 1 < preorder.length) {
			i++;
			if (preorder[i] < preorder[0]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution255 solution = new Solution255();

		int[] preorder = { 1, 3, 4, 2 };
		System.out.println(solution.verifyPreorder(preorder));
	}

}
