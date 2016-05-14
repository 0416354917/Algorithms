package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Count of Smaller Numbers After Self.
 * 
 * <p>
 * <b>Status: TLE.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution315 {

	public List<Integer> countSmaller(int[] nums) {
		if (nums == null)
			return null;

		List<Integer> counts = new ArrayList<Integer>();

		if (nums.length == 0)
			return counts;

		counts.add(0);
		while (counts.size() != nums.length) {
			int num1 = nums[nums.length - counts.size() - 1];
			int count1 = 0;
			for (int i = 0; i < counts.size(); i++) {
				int num2 = nums[nums.length - counts.size() + i];
				// if (num1 > num2) {
				// count1 = counts.get(i) + 1;
				// break;
				// }
				if (num1 > num2)
					count1++;
			}
			counts.add(0, count1);
		}

		return counts;
	}

	public static void main(String[] args) {
		Solution315 solution = new Solution315();

		int[] nums = { 5, 2, 6, 1 };
		// int[] nums = { 2, 0, 1 };
		List<Integer> counts = solution.countSmaller(nums);
		for (int count : counts)
			System.out.print(count + " ");
	}

}
