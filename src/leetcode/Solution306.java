package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Additive Number.
 * 
 * <p>
 * <b>Description: </b>Additive number is a string whose digits can form
 * additive sequence.
 * 
 * A valid additive sequence should contain at least three numbers. Except for
 * the first two numbers, each subsequent number in the sequence must be the sum
 * of the preceding two.
 * </p>
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
public class Solution306 {

	/**
	 * Sum of two integers represented in strings.
	 * 
	 * @param num1
	 * @param num2
	 * @return string representation of the sum of two integers.
	 */
	public String sum(String num1, String num2) {
		if (num1.length() < num2.length()) {
			String t = num1;
			num1 = num2;
			num2 = t;
		}

		char[] chArr1 = num1.toCharArray();
		char[] chArr2 = num2.toCharArray();

		int[] arr1 = new int[chArr1.length];
		int[] arr2 = new int[chArr2.length];

		for (int i = 0; i < chArr1.length; i++) {
			arr1[i] = chArr1[i] - 48;
		}
		for (int i = 0; i < chArr2.length; i++) {
			arr2[i] = chArr2[i] - 48;
		}

		int offset = arr1.length - arr2.length;
		int i = arr2.length - 1;
		while (i >= 0) {
			arr1[i + offset] += arr2[i];
			i--;
		}

		StringBuffer ans = new StringBuffer();
		int j = arr1.length - 1;
		for (; j > 0; j--) {
			ans.insert(0, arr1[j] % 10);
			arr1[j - 1] += arr1[j] / 10;
		}
		ans.insert(0, arr1[0]);

		return ans.toString();
	}

	public boolean isAdditiveNumber(String num) {
		if (num == null || num.length() < 3)
			return false;

		List<String> ass = new ArrayList<String>();

		int startIndex = 0;
		if (num.charAt(0) == '0') {
			ass.add("0");
			startIndex++;
		}

		return bt(num, ass, startIndex, 1);
	}

	public boolean bt(String num, List<String> ass, int index, int length) {
		int size = ass.size();

		if (size >= 3) {
			if (!ass.get(size - 1)
					.equals(sum(ass.get(size - 2), ass.get(size - 3)))) {
				return false;
			} else {
				if (index == num.length())
					return true;
			}
		} else if (index + length > num.length()) {
			return false;
		} else if (num.charAt(index) == '0' && length > 1) {
			return false;
		}

		while (index + length <= num.length()) {
			if (num.charAt(index) == '0' && length > 1) {
				length++;
				continue;
			}
			ass.add(num.substring(index, index + length));
			if (bt(num, ass, index + length, 1))
				return true;
			else {
				ass.remove(ass.size() - 1);
				length++;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Solution306 solution = new Solution306();

		String num1 = "112358";
		System.out.println(solution.isAdditiveNumber(num1)); // true.

		String num2 = "199100199";
		System.out.println(solution.isAdditiveNumber(num2)); // true.

		String num3 = "1203";
		System.out.println(solution.isAdditiveNumber(num3)); // true.

		String num4 = "19910011992";
		System.out.println(solution.isAdditiveNumber(num4)); // false.
	}

}
