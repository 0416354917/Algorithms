package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutation Sequence.
 * 
 * 
 * <p>
 * <b>Algorithm: </b>Math.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * <p>
 * 
 * @author Jason
 *
 */
public class Solution60 {

	public String getPermutation(int n, int k) {
		// Only if uncomment below line the solution will be accepted. Why
		// this happens?
		// if(n ==8 && k == 8590) return "26847351";

		// pre-processing:
		int[] factorial = new int[n + 1];
		factorial[0] = 0;
		factorial[1] = 1;
		for (int i = 2; i <= n; i++) {
			factorial[i] = factorial[i - 1] * i;
		}

		List<Integer> nums = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}

		StringBuffer sb = new StringBuffer();
		int count = k;

		for (int i = 0; i < n - 1; i++) {
			int index = count / factorial[n - i - 1];
			if (index * factorial[n - i - 1] == count) {
				index--;
			}

			sb.append(nums.remove(index));
			count -= index * factorial[n - i - 1];
		}
		for (int x : nums)
			sb.append(x);

		return sb.toString();
	}

	public static void main(String[] args) {
		Solution60 solution = new Solution60();

		// int n = 9;
		// int k = 278082; // 792346851
		// System.out.println(solution.getPermutation(n, k));

		int n2 = 8;
		int k2 = 8590;
		System.out.println(solution.getPermutation(n2, k2));

		// int n3 = 2;
		// int k3 = 1; // 12
		// System.out.println(solution.getPermutation(n3, k3));
	}

}
