package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution166 {

	public String fractionToDecimal(int numerator, int denominator) {
		// Edge cases.
		// if (numerator == 0)
		// return "0";
		// else if (denominator == 1)
		// return Integer.toString(numerator);
		// else
		if (numerator % denominator == 0) {
			return Integer.toString(numerator / denominator);
		}

		int flag = 1;
		if (numerator < 0) {
			numerator *= -1;
			flag *= -1;
		}
		if (denominator < 0) {
			denominator *= -1;
			flag *= -1;
		}

		StringBuffer ans = new StringBuffer();

		if (numerator < denominator) {
			ans.append("0.");
			while (numerator * 10 < denominator) {
				ans.append("0");
				numerator *= 10;
			}
		}

		List<Integer> list1 = new ArrayList<Integer>();

		int r = numerator;
		while (r != 0) {
			list1.add(r);

			r *= 10;
			int divisor = r / denominator;
			ans.append(divisor);

			r = r % denominator;
			if (list1.contains(r)) {
				int index = list1.indexOf(r);
				ans.insert(ans.length() - (list1.size() - index), "(");
				ans.append(")");
				break;
			}
		}

		if (flag == -1) {
			ans.insert(0, "-");
		}

		return ans.toString();
	}

	public static void main(String[] args) {
		Solution166 solution = new Solution166();

		int n1 = 1;
		int d1 = 2;
		System.out.println(
				n1 + " / " + d1 + " = " + solution.fractionToDecimal(n1, d1));

		int n2 = 2;
		int d2 = 1;
		System.out.println(
				n2 + " / " + d2 + " = " + solution.fractionToDecimal(n2, d2));

		int n3 = 2;
		int d3 = 3;
		System.out.println(
				n3 + " / " + d3 + " = " + solution.fractionToDecimal(n3, d3));

		int n4 = 4;
		int d4 = 330;
		System.out.println(
				n4 + " / " + d4 + " = " + solution.fractionToDecimal(n4, d4));

		int n5 = -2147483648;
		int d5 = -1;
		System.out.println(n5 / d5);
		System.out.println(n5 % d5);
		System.out.println(
				n5 + " / " + d5 + " = " + solution.fractionToDecimal(n5, d5));
	}

}
