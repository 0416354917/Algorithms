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

		Stack<String> stack = new Stack<String>();
		Stack<Integer> stack2 = new Stack<Integer>();
		String[] s = preorder.split(",");
		if (s[0].equals("#")) {
			return false;
		}
		stack.push(s[0]);
		stack2.push(0);
		int index = 1;
		while (index < s.length) {
			if (!s[index].equals("#")) {
				stack.push(s[index]);
				stack2.push(0);
			} else {
				stack2.set(stack2.size() - 1, stack2.peek() + 1);
				if (stack2.peek().intValue() != 2) {
					stack.push("#");
					stack2.push(1);
				} else {
					while (stack2.peek().intValue() == 2) {
						stack2.pop();
						stack.pop();
						if (stack.isEmpty()) {
							if (index != s.length - 1)
								return false;
							else
								return true;
						}
						stack2.set(stack2.size() - 1, stack2.peek() + 1);
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
