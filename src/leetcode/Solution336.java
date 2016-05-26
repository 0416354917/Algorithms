package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Palindrome Pairs.
 * 
 * <p>
 * <b>Description: </b>Given a list of unique words. Find all pairs of distinct
 * indices (i, j) in the given list, so that the concatenation of the two words,
 * i.e. words[i] + words[j] is a palindrome.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>...
 * </p>
 * 
 * <p>
 * <b>Status: </b>TLE.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution336 {

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

	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		if (words == null || words.length < 2)
			return ans;

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if (j == i)
					continue;
				StringBuffer sb1 = new StringBuffer(words[i]);
				StringBuffer sb2 = new StringBuffer(words[j]);
				if (this.isPalindrome(sb1.append(sb2).toString())) {
					ans.add(Arrays.asList(i, j));
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution336 solution = new Solution336();

		// String[] words = { "bat", "tab", "cat" };
		String[] words = { "abcd", "dcba", "lls", "s", "sssll" };
		List<List<Integer>> ans = solution.palindromePairs(words);
		for (List<Integer> list : ans) {
			System.out.println("[" + list.get(0) + ", " + list.get(1) + "]");
		}
	}

}
