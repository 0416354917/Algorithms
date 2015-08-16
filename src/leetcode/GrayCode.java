package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Algorithm(s): Backtracking.
 * 
 * Bit manipulation.
 * 
 * @author Jason
 *
 */
public class GrayCode {

	/**
	 * Bit manipulation.
	 * 
	 * @param n
	 * @return
	 */
	public static List<Integer> grayCode1(int n) {
		List<Integer> res = new ArrayList<Integer>();
		res.add(0);
		int t = 1;
		for (int i = 0; i < n; i++) {
			for (int j = res.size() - 1; j >= 0; j--) {
				res.add(res.get(j) ^ t);
			}
			t <<= 1;
		}
		return res;
	}

	/**
	 * Backtracking.
	 * 
	 * @param n
	 * @return
	 */
	public static List<Integer> grayCode2(int n) {
		return null;
	}

	public static void main(String[] args) {
		int n = 2;
		List<Integer> res = grayCode1(n);
		for (int code : res) {
			System.out.println(code);
		}
	}
}
