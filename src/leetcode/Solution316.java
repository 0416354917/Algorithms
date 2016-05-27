package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution316 {

	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() < 2)
			return s;

		char[] arr = s.toCharArray();
		Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			List<Integer> indices = map.get(arr[i]);
			if (indices == null) {
				indices = new ArrayList<Integer>();
				map.put(arr[i], indices);
			}
			indices.add(i);
		}

		int lastCharIndex = arr.length;
		for (char ch = 'a'; ch <= 'z'; ch++) {
			List<Integer> indices = map.get(ch);
			if (indices == null)
				continue;
			else {
				Collections.sort(indices);
				if (indices.get(indices.size() - 1) < lastCharIndex) {
					int i = 1;
					while (i < indices.size()) {
						arr[indices.get(i)] = '#';
						i++;
					}
					lastCharIndex = indices.get(0);
				} else {
					int i = indices.size() - 1;
					while (indices.get(i) > lastCharIndex && i >= 0) {
						i--;
					}
					i++;

					lastCharIndex = indices.get(i);
					i = 0;
					while (i < indices.size()) {
						if (indices.get(i) != lastCharIndex) {
							arr[indices.get(i)] = '#';
						}
						i++;
					}
				}
			}
		}

		StringBuffer ans = new StringBuffer();
		for (char ch : arr) {
			if (ch != '#') {
				ans.append(ch);
			}
		}

		return ans.toString();
	}

	public static void main(String[] args) {
		Solution316 solution = new Solution316();

//		String s1 = "bcabc";
//		System.out.println(solution.removeDuplicateLetters(s1));

		String s2 = "cbacdcbc";
		System.out.println(solution.removeDuplicateLetters(s2));
	}

}
