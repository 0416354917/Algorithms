package leetcode;

import java.util.HashMap;

public class Solution273 {

	public String smallNumToWords(int num) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "Zero");
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");
		map.put(7, "Seven");
		map.put(8, "Eight");
		map.put(9, "Nine");

		if (num < 10)
			return map.get(num);
		// if(num >= 10 && num <= 99)

		return "";
	}

	public String numberToWords(int num) {
		return "";
	}

	public static void main(String[] args) {
		Solution273 solution = new Solution273();

		int num1 = 123;// -> "One Hundred Twenty Three";
		int num2 = 12345;// -> "Twelve Thousand Three Hundred Forty Five";
		int num3 = 1234567;// -> "One Million Two Hundred Thirty Four Thousand
							// Five Hundred Sixty Seven";

		System.out.println("num = " + num1 + ", solution = "
				+ solution.numberToWords(num1));
		System.out.println("num = " + num2 + ", solution = "
				+ solution.numberToWords(num2));
		System.out.println("num = " + num3 + ", solution = "
				+ solution.numberToWords(num3));
	}

}
