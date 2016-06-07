package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Palindrome Permutation II.
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
public class Solution267 {

	public List<String> generatePalindromes(String s) {
		List<String> ans = new ArrayList<>();

		if (s == null || s.length() < 1)
			return ans;

		Map<Character, Integer> counter = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			int x = counter.getOrDefault(s.charAt(i), 0);
			counter.put(s.charAt(i), x + 1);
		}

		// get middle:
		int odd = 0;
		StringBuffer mid = new StringBuffer();
		Iterator<Entry<Character, Integer>> it = counter.entrySet().iterator();
		while (it.hasNext()) {
			char x = it.next().getKey();
			int count = counter.get(x);
			if (count % 2 != 0) {
				odd++;
				if (odd > 1) {
					return ans;
				} else {
					mid.append(x);
					count--;
					if (count == 0)
						it.remove();
				}
			}
		}

		// get first half:
		StringBuffer sb = new StringBuffer();
		it = counter.entrySet().iterator();
		while (it.hasNext()) {
			char x = it.next().getKey();
			int count = counter.get(x) / 2;
			while (count != 0) {
				sb.append(x);
				count--;
			}
		}

		if (sb.length() == 0) {
			ans.add(mid.toString());
			return ans;
		}

		// backtracking:
		bt(ans, sb.toString().toCharArray(), 0);
		for (int i = 0; i < ans.size(); i++) {
			StringBuffer ass = new StringBuffer(ans.get(i));
			StringBuffer right = new StringBuffer(ans.get(i)).reverse();
			ass.append(mid);
			ass.append(right);
			ans.set(i, ass.toString());
		}

		return ans;
	}

	public void bt(List<String> ass, char[] chars, int index) {
		if (index == chars.length) {
			ass.add(new StringBuffer().append(chars).toString());
		}

		Set<Character> explored = new HashSet<>();
		for (int i = index; i < chars.length; i++) {
			if (explored.add(chars[i])) {
				swap(chars, i, index);
				bt(ass, chars, index + 1);
				swap(chars, i, index);
			}
		}
	}

	public void swap(char[] chars, int i, int j) {
		char t = chars[i];
		chars[i] = chars[j];
		chars[j] = t;
	}

	public static void main(String[] args) {
		Solution267 solution = new Solution267();

		String s = "aabbccc";
		List<String> ans = solution.generatePalindromes(s);
		ans.forEach(x -> System.out.println(x));
	}

}
