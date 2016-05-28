package leetcode;

/**
 * Minimum Window Substring.
 * 
 * <p>
 * <b>Description: </b>Given a string S and a string T, find the minimum window
 * in S which will contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the empty string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Two Pointers.
 * </p>
 * 
 * 
 * <p>
 * <b>Reference: </b>
 * {@link https://leetcode.com/discuss/87685/template-subarray-substring-substring-repeating-characters}
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution76 {

	public String minWindow(String s, String t) {
		if (s == null || s.length() == 0 || s.length() < t.length()) {
			return "";
		}

		char[] sa = s.toCharArray();
		char[] ta = t.toCharArray();
		int[] counter = new int[256];
		for (char ch : ta) {
			counter[ch]++;
		}

		int start = 0, end = 0;
		int count = ta.length;
		int minStart = 0, minLength = s.length() + 1;
		while (end < sa.length) {
			if (counter[sa[end]] > 0) {
				count--;
			}
			counter[sa[end]]--;

			while (count == 0) {
				int length = end - start + 1;
				if (length < minLength) {
					minStart = start;
					minLength = length;
				}

				counter[sa[start]]++;

				if (counter[sa[start]] > 0) {
					count++;
				}

				start++;
			}
			end++;
		}

		return minLength == s.length() + 1 ? ""
				: s.substring(minStart, minStart + minLength);
	}

	public static void main(String[] args) {
		Solution76 solution = new Solution76();

		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(solution.minWindow(s, t));
	}

}
