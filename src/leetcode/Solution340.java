package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring with At Most K Distinct Characters.
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution340 {

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s == null || k == 0) {
			return 0;
		}

		if (s.length() <= k) {
			return s.length();
		}

		int n = s.length();
		Map<Character, Integer> counter = new HashMap<>();
		for (int i = 0; i < k; i++) {
			int count = counter.getOrDefault(s.charAt(i), 0);
			counter.put(s.charAt(i), count + 1);
		}

		int ans = k;
		int startIndex = 0;
		int endIndex = k;
		while (startIndex <= n - k) {
			while (endIndex < n) {
				char ch = s.charAt(endIndex);

				endIndex++;

				int count = counter.getOrDefault(ch, 0);
				counter.put(ch, count + 1);
				if (counter.size() <= k) {
					ans = Math.max(ans, endIndex - startIndex);
				} else {
					break;
				}
			}
			if (endIndex == n) {
				break;
			}
			while (counter.size() > k) {
				char ch = s.charAt(startIndex);

				startIndex++;

				int count = counter.get(ch);
				if (count > 1) {
					counter.put(ch, count - 1);
				} else {
					counter.remove(ch);
					break;
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution340 solution = new Solution340();

		String s = "abcabcabc";
		int k = 2;
		System.out.println(solution.lengthOfLongestSubstringKDistinct(s, k));
	}

}
