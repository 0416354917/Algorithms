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
		// s1 and s2 is guaranteed to have the same length.
		if (s1 == null || s1.length() == 0)
			return true;

		if (!compareSubStr(s1, s2))
			return false;
		else {
			if (s1.length() < 3) {
				return true;
			}
		}

		for (int i = 0; i < s1.length() - 1; i++) {
			String s3 = s1.substring(0, i + 1);
			String s4 = s2.substring(0, i + 1);
			if (compareSubStr(s3, s4))
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
