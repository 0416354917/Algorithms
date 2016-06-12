package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Word Pattern II.
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution291 {

	public boolean bt(Map<String, String> map, int patternIndex, int strIndex,
			String pattern, String str) {
		if (patternIndex == pattern.length()) {
			if (strIndex != str.length())
				return false;
			else
				return true;
		} else {
			if (strIndex == str.length())
				return false;
		}

		String x = pattern.substring(patternIndex, patternIndex + 1);
		if (map.containsKey(x)) {
			String target = map.get(x);
			if (str.length() - strIndex < target.length()) {
				return false;
			} else if (!str.substring(strIndex, strIndex + target.length())
					.equals(target)) {
				return false;
			} else {
				strIndex += target.length();
				patternIndex++;
				return bt(map, patternIndex, strIndex, pattern, str);
			}
		} else {
			StringBuffer y = new StringBuffer();
			for (int i = strIndex; i < str.length(); i++) {
				y.append(str.charAt(i));
				if (!map.containsValue(y.toString())) {
					map.put(x, y.toString());
					if (bt(map, patternIndex + 1, i + 1, pattern, str)) {
						return true;
					} else {
						map.remove(x);
					}
				}
			}
		}

		return false;
	}

	public boolean wordPatternMatch(String pattern, String str) {
		if (pattern.length() > str.length()) {
			return false;
		}

		Map<String, String> map = new HashMap<>();

		return bt(map, 0, 0, pattern, str);
	}

	public static void main(String[] args) {
		Solution291 solution = new Solution291();

		String pattern = "abba";
		String str = "dogcatcatdog";

		System.out.println(solution.wordPatternMatch(pattern, str));
	}

}
