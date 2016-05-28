package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Scramble String.
 * 
 * <p>
 * <b>Description: </b>Given a string s1, we may represent it as a binary tree
 * by partitioning it to two non-empty substrings recursively.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>...
 * </p>
 * 
 * <p>
 * <b>Status: </b>...
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution87 {

	public boolean compareSubStr(String s1, String s2) {
		List<String> list1 = new ArrayList<String>();
		for (int i = 0; i < s1.length(); i++)
			list1.add(s1.substring(i, i + 1));
		list1.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}

		});

		List<String> list2 = new ArrayList<String>();
		for (int i = 0; i < s2.length(); i++)
			list2.add(s2.substring(i, i + 1));
		list2.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}

		});

		return list1.equals(list2);
	}

	public boolean isScramble(String s1, String s2) {
		if (s1 == null || s1.length() == 0)
			return true;

		int[] smallAlp = new int[26];
		int[] upperAlp = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			if (Character.isLowerCase(s1.charAt(i))) {
				smallAlp[s1.charAt(i) - 'a']++;
			} else {
				upperAlp[s1.charAt(i) - 'A']++;
			}

			if (Character.isLowerCase(s2.charAt(i))) {
				smallAlp[s2.charAt(i) - 'a']--;
			} else {
				upperAlp[s2.charAt(i) - 'A']--;
			}
		}

		for (int i = 0; i < 26; i++) {
			if (smallAlp[i] != 0 || upperAlp[i] != 0)
				return false;
		}

		for (int i = 1; i < s1.length(); i++) {
			if (isScramble(s1.substring(0, i), s2.substring(0, i))
					&& isScramble(s1.substring(i), s2.substring(i)))
				return true;
			if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
					&& isScramble(s1.substring(i),
							s2.substring(0, s2.length() - i)))
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		Solution87 solution = new Solution87();

		String s1 = "great";
		String s2 = "rgeat";
		String s3 = "rgtae";
		String s4 = "geart";
		String s5 = "retag";

		System.out.println(solution.isScramble(s1, s2)); // true
		System.out.println(solution.isScramble(s1, s3)); // true
		System.out.println(solution.isScramble(s1, s4)); // true
		System.out.println(solution.isScramble(s1, s5)); // false
	}

}
