package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Remove Invalid Parentheses.
 * 
 * <p>
 * <b>Status: .</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution301 {

	public List<String> removeInvalidParentheses(String s) {
		List<String> ans = new ArrayList<String>();
		
		// corner cases:
		if (s == null || s.length() < 2 || !s.contains("(") || !s.contains(")"))
			return ans;

		StringBuffer sb = new StringBuffer(s);
		// step 1: remove all leading ")" and trailing "(".
		int index = 0;
		while (index < sb.length()) {
			if (sb.charAt(index) == ')')
				sb.deleteCharAt(index);
			else if (sb.charAt(index) == '(')
				break;
			else
				index++;
		}
		if (!s.contains("(") || !s.contains(")"))
			return ans;
		if(s.length() < 2){
			ans.add(sb.toString());
			return ans;
		}
			
		
		// step2:
		
		

		return ans;
	}

	public static void main(String[] args) {
		Solution301 solution = new Solution301();

		String s1 = "()())()";// -> ["()()()", "(())()"]
		String s2 = "(a)())()";// -> ["(a)()()", "(a())()"]
		String s3 = ")(";// -> [""]

		List<String> list1 = solution.removeInvalidParentheses(s1);
		System.out.println("list #1:");
		for (String s : list1) {
			System.out.println(s);
		}

		List<String> list2 = solution.removeInvalidParentheses(s2);
		System.out.println("list #2:");
		for (String s : list2) {
			System.out.println(s);
		}

		List<String> list3 = solution.removeInvalidParentheses(s3);
		System.out.println("list #3:");
		for (String s : list3) {
			System.out.println(s);
		}
	}

}
