package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Status: TLE.
 */
public class Solution318 {
	public int maxProduct2(String[] words) {
		int answer = 0;

		HashMap<Integer, HashSet<Character>> map = new HashMap<Integer, HashSet<Character>>();
		for (int i = 0; i < words.length; i++) {
			HashSet<Character> set = new HashSet<Character>();
			for (char ch : words[i].toCharArray()) {
				set.add(ch);
			}
			map.put(i, set);
		}

		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {

				if (!map.get(i).retainAll(map.get(j))) {
					answer = Math.max(answer,
							words[i].length() * words[j].length());
				}
			}
		}

		return answer;
	}

	public int maxProduct(String[] words) {
		int answer = 0;
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {
				char[] array1 = words[i].toCharArray();
				char[] array2 = words[j].toCharArray();
				boolean flag = true;
				for (char ch1 : array1) {
					for (char ch2 : array2) {
						if (ch1 == ch2) {
							flag = false;
							break;
						}
					}
					if (flag == false)
						break;
				}
				if (flag == true) {
					answer = Math.max(answer,
							words[i].length() * words[j].length());
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		String[] words = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
		System.out.println(new Solution318().maxProduct2(words));
	}

}
