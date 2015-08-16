/**Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Ensure that numbers within the set are sorted in ascending order.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CombinationSum {

	static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int num = 1; num <= 9; num++) {
			List<Integer> list = new ArrayList<Integer>();

		}
		return null;

	}

	public static void main(String[] args) {
		// Calculate the sum of an array with the use of stream (since Java 1.8):
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		System.out.println(IntStream.of(nums).sum());
	}

}
