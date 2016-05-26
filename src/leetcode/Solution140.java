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
 * <b>Status: </b>TLE>
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
			List<String> ass, int index) {
		if (index == s.length()) {
			ans.add(String.join(" ", ass));
			return true;
		}

		for (int i = index; i < s.length(); i++) {
			String sub = s.substring(index, i + 1);
			if (wordDict.contains(sub)) {
				ass.add(sub);
				bt(ans, s, wordDict, ass, i + 1);
				ass.remove(ass.size() - 1);
			}
		}

		return false;
	}

	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> ans = new ArrayList<String>();

		if (s != null && s.length() != 0) {
			List<String> ass = new ArrayList<String>();
			bt(ans, s, wordDict, ass, 0);
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
