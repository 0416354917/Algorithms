package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Remove Duplicates from Sorted Array II.
 * 
 * <p>
 * <b>Status: Accepted. </b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution80 {

	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		List<Integer> list = new ArrayList<Integer>();

		// remove:
		int nextPos = 0;
		int val = 0;
		while (nextPos < nums.length) {
			val = nums[nextPos];
			list.add(val);
			if (nextPos + 2 < nums.length && nums[nextPos + 1] == val) {
				nextPos += 2;
				list.add(val);
				while (nextPos < nums.length && nums[nextPos] == val) {
					nextPos++;
				}
			} else {
				nextPos++;
			}
		}

		// copy array:
		for (int index = 0; index < list.size(); index++)
			nums[index] = list.get(index);

		return list.size();
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		// int[] nums = {};
		// int[] nums =null;

		System.out.println(new Solution80().removeDuplicates(nums));
		if (nums != null) {
			for (int n : nums)
				System.out.println(n);
		}

	}

}
