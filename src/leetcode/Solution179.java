package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Largest Number.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution179 {

	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0)
			return "";

		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++)
			strs[i] = Integer.toString(nums[i]);

		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o1 + o2).compareTo(o2 + o1);
			}
		});

		// construct the solution :
		StringBuffer sb = new StringBuffer();
		int i = strs.length - 1;
		while (i > 0 && strs[i].equals("0")) {
			i--;
		}
		for (; i >= 0; i--)
			sb.append(strs[i]);
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution179 solution = new Solution179();

		// int[] nums = { 3, 30, 34, 5, 9 };
		int[] nums = { 12, 121 };
		// int[] nums = { 0, 0 };
		System.out.println(solution.largestNumber(nums));
	}

}
