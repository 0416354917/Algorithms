package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome Partitioning.
 * 
 * <p>
 * <b>Description: </b>Given a string s, partition s such that every substring
 * of the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [ ["aa","b"], ["a","a","b"] ]
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Backtracking.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution131 {

	public boolean isPalindrome(String s) {
		if (s.length() == 1)
			return true;

		StringBuffer sb1 = new StringBuffer(), sb2 = new StringBuffer();
		sb1.append(s.substring(0, s.length() / 2));
		if (s.length() % 2 == 0) {
			sb2.append(s.substring(s.length() / 2));
		} else {
			sb2.append(s.substring(s.length() / 2 + 1));
		}

		return sb2.reverse().toString().equals(sb1.toString());
	}

	public void bt(List<List<String>> ans, List<String> ass, int index,
			String s) {
		if (index == s.length()) {
			ans.add(ass);
			return;
		}

		for (int i = index; i < s.length(); i++) {
			String sub = s.substring(index, i + 1);
			if (isPalindrome(sub)) {
				List<String> ass2 = new ArrayList<String>();
				ass.stream().forEach(x -> ass2.add(x));
				ass2.add(sub);
				bt(ans, ass2, i + 1, s);
			}
		}
	}

	public List<List<String>> partition(String s) {
		List<List<String>> ans = new ArrayList<List<String>>();

		if (s != null && s.length() != 0) {
			List<String> ass = new ArrayList<String>();
			int index = 0;
			bt(ans, ass, index, s);
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution131 solution = new Solution131();

		String s = "aab";
		List<List<String>> ans = solution.partition(s);
		for (List<String> list : ans) {
			System.out.print("[");
			for (String x : list) {
				System.out.print(x + " ");
			}
			System.out.println("]");
		}
	}

}
