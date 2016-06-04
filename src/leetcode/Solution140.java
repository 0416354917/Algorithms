package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Word Break II.
 * 
 * <p>
 * <b>Description: </b>Given a string s and a dictionary of words dict, add
 * spaces in s to construct a sentence where each word is a valid dictionary
 * word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand",
 * "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Backtracking.
 * </p>
 * 
 * <p>
 * <b>Status: </b>TLE.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution140 {

	/**
	 * public void bt(List<String> ans, String s, Set<String> wordDict, List
	 * <String> ass, int index) { if (index == s.length()) {
	 * ans.add(String.join(" ", ass)); return; }
	 * 
	 * for (int i = index; i < s.length(); i++) { String sub =
	 * s.substring(index, i + 1); if (wordDict.contains(sub)) { List
	 * <String> ass2 = new ArrayList<String>(); ass.stream().forEach(x ->
	 * ass2.add(x)); ass2.add(sub); bt(ans, s, wordDict, ass2, i + 1); } } }
	 */

	public boolean bt(List<String> ans, String s, Set<String> wordDict,
			List<String> ass, int index, int minLength, int maxLength) {
		if (index == s.length()) {
			ans.add(String.join(" ", ass));
			return true;
		}

		if (index + minLength > s.length())
			return false;

		StringBuffer sb = new StringBuffer(
				s.substring(index, index + minLength - 1));

		for (int i = index + minLength; i <= Math.min(s.length(),
				index + maxLength); i++) {
			sb.append(s.charAt(i - 1));
			if (wordDict.contains(sb.toString())) {
				ass.add(sb.toString());
				bt(ans, s, wordDict, ass, i, minLength, maxLength);
				ass.remove(ass.size() - 1);
			}
		}

		return false;
	}

	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> ans = new ArrayList<String>();

		if (s != null && s.length() != 0) {
			int minLength = Integer.MAX_VALUE, maxLength = -1;
			for (String ss : wordDict) {
				minLength = Math.min(minLength, ss.length());
				maxLength = Math.max(maxLength, ss.length());
			}

			List<Set<Integer>> paths = new ArrayList<>();
			for (int i = 0; i < s.length() - minLength; i++) {
				int length = minLength;
				StringBuffer sb = new StringBuffer(s.substring(i, i + length));
				while (length < maxLength && i + length <= s.length()) {
					// if()
					length++;
				}
			}

			// List<String> ass = new ArrayList<String>();
			// bt(ans, s, wordDict, ass, 0, minLength, maxLength);
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution140 solution = new Solution140();

		String s = "catsanddog";
		Set<String> wordDict = new HashSet<String>();
		wordDict.addAll(Arrays.asList("cat", "cats", "and", "sand", "dog"));

		List<String> ans = solution.wordBreak(s, wordDict);
		for (String x : ans) {
			System.out.println(x);
		}
	}

}
