package leetcode;

import java.util.Stack;

/**
 * Remove Duplicate Letters.
 * 
 * <p>
 * <b>Description: </b>
 * 
 * Given a string which contains only lowercase letters, remove duplicate
 * letters so that every letter appear once and only once. You must make sure
 * your result is the smallest in lexicographical order among all possible
 * results.
 * 
 * Example:
 * 
 * Given "bcabc" Return "abc"
 * 
 * Given "cbacdcbc" Return "acdb"
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Stack, Greedy.
 * </p>
 * 
 * <p>
 * <b>Reference: </b>
 * {@link https://leetcode.com/discuss/99084/java-o-n-solution-using-stack-with-detail-explanation}
 * </p>
 * 
 * <p>
 * <b>Note: </b>
 * 
 * First, given "bcabc", the solution should be "abc". If we think about this
 * problem intuitively, you would sort of go from the beginning of the string
 * and start removing one if there is still the same character left and a
 * smaller character is after it. Given "bcabc", when you see a 'b', keep it and
 * continue with the search, then keep the following 'c', then we see an 'a'.
 * Now we get a chance to get a smaller lexi order, you can check if after 'a',
 * there is still 'b' and 'c' or not. We indeed have them and "abc" will be our
 * result.
 * <p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution316 {
	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() < 2)
			return s;

		Stack<Character> sta = new Stack<Character>();
		boolean[] visited = new boolean[26];
		char[] arr = s.toCharArray();
		int[] count = new int[26];
		for (char ch : arr)
			count[ch - 'a']++;
		for (char ch : arr) {
			count[ch - 'a']--;
			if (visited[ch - 'a'])
				continue;
			while (!sta.isEmpty() && sta.peek() > ch
					&& count[sta.peek() - 'a'] > 0) {
				visited[sta.pop() - 'a'] = false;
			}
			sta.push(ch);
			visited[ch - 'a'] = true;
		}

		StringBuffer sb = new StringBuffer();
		for (char ch : sta)
			sb.append(ch);

		return sb.toString();
	}

	public static void main(String[] args) {
		Solution316 solution = new Solution316();

		String s1 = "bcabc";
		System.out.println(solution.removeDuplicateLetters(s1));

		String s2 = "cbacdcbc";
		System.out.println(solution.removeDuplicateLetters(s2));
	}

}
