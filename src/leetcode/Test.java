package leetcode;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		Solution sol1 = new Solution();
		sol1.testMinSubArrayLen();

		ArrayList<Integer> array = new ArrayList<Integer>();
		ArrayList<String> array2 = new ArrayList<String>();
		array.add(2);
		array.add(3);
		array.add(1);
		array.sort(null);
		for (int i : array) {
			System.out.println(i);
		}
		array2.add("9");
		array2.add("30");
		array2.add("3");
		array2.sort(null);
		for (String s : array2) {
			System.out.println(s);
		}
	}

}
