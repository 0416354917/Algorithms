package leetcode;

import java.util.Stack;

/**
 * Verify Preorder Serialization of a Binary Tree.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution331 {

	public boolean isValidSerialization(String preorder) {
		if (preorder == null || preorder.length() == 0)
			return false;

		if (preorder.equals("#"))
			return true;

		Stack<Integer> stack = new Stack<Integer>();
		String[] s = preorder.split(",");
		if (s[0].equals("#")) {
			return false;
		}
		stack.push(0);
		int index = 1;
		while (index < s.length) {
			if (!s[index].equals("#")) {
				stack.push(0);
			} else {
				stack.set(stack.size() - 1, stack.peek() + 1);
				if (stack.peek().intValue() != 2) {
					stack.push(1);
				} else {
					while (stack.peek().intValue() == 2) {
						stack.pop();
						if (stack.isEmpty()) {
							if (index != s.length - 1)
								return false;
							else
								return true;
						}
						stack.set(stack.size() - 1, stack.peek() + 1);
					}
				}
			}
			index++;
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		Solution331 solution = new Solution331();

		String test1 = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		String test2 = "1,#";
		String test3 = "9,#,#,1";
		String test4 = "1,#,#";

		System.out.println(solution.isValidSerialization(test1));
		System.out.println(solution.isValidSerialization(test2));
		System.out.println(solution.isValidSerialization(test3));
		System.out.println(solution.isValidSerialization(test4));
	}

}
