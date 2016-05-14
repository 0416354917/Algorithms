package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Group Anagrams.
 * 
 * <p>
 * <b>Status: Accepted. </b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution49 {

	public String toSortedString(String s) {
		if (s.length() == 0)
			return "";

		StringBuffer sb = new StringBuffer();

		int index = 0;
		sb.append(s.charAt(index));
		index++;
		while (index < s.length()) {
			char ch = s.charAt(index);
			int pos = 0;
			while (pos < index && ch > sb.charAt(pos)) {
				pos++;
			}
			sb.insert(pos, ch);
			index++;
		}

		return sb.toString();
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();

		if (strs == null || strs.length == 0)
			return result;

		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s : strs) {
			String sortedStr = toSortedString(s);
			if (map.containsKey(sortedStr)) {
				map.get(sortedStr).add(s);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(s);
				map.put(sortedStr, list);
			}
		}

		for (String key : map.keySet()) {
			List<String> value = map.get(key);
			Collections.sort(value);
			result.add(value);
		}

		return result;
	}

	public static void main(String[] args) {
		// String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		String[] strs = { "" };
		List<List<String>> solution = new Solution49().groupAnagrams(strs);
		for (List<String> list : solution) {
			for (String s : list) {
				System.out.print("#" + s + " ");
			}
			System.out.println();
		}

	}

}
