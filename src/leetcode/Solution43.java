package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Multiply Strings.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution43 {

	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";

		List<Integer> answer = new ArrayList<Integer>();
		int offset = 0;
		for (int i = num1.length() - 1; i >= 0; i--) {
			for (int j = num2.length() - 1; j >= 0; j--) {
				int x = num1.charAt(i) - 48;
				int y = num2.charAt(j) - 48;
				int z = x * y;
				int pos = num2.length() - 1 - j + offset;
				if (pos == answer.size()) {
					answer.add(z);
				} else {
					answer.set(pos, answer.get(pos) + z);
				}
			}
			offset++;
		}
		for (int i = 0; i < answer.size() - 1; i++) {
			int x = answer.get(i);
			if (x >= 10) {
				answer.set(i, x % 10);
				answer.set(i + 1, answer.get(i + 1) + x / 10);
			}
		}
		while (answer.get(answer.size() - 1) >= 10) {
			answer.add(answer.get(answer.size() - 1) / 10);
			answer.set(answer.size() - 2, answer.get(answer.size() - 2) % 10);
		}

		StringBuffer sb = new StringBuffer();
		for (int i = answer.size() - 1; i >= 0; i--)
			sb.append(Integer.toString(answer.get(i)));
		return sb.toString();
	}

	public static void main(String[] args) {
		String num1 = "9";
		String num2 = "9";
		System.out.println(new Solution43().multiply(num1, num2));
	}

}
