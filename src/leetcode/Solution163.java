package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution163 {

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> ans = new ArrayList<>();

		// corner cases:
		if (nums == null || nums.length == 0) {
			if (lower == upper)
				ans.add("" + lower);
			else
				ans.add(lower + "->" + upper);
			return ans;
		}

		// lower:
		int i = 0;
		for (; i < nums.length; i++) {
			if (lower <= nums[i]) {
				break;
			}
		}

		// upper:
		int j = i;
		for (; j < nums.length; j++) {
			if (upper > nums[j]) {
				break;
			}
		}
		

		// if (i == nums.length) {
		// if (lower == upper)
		// ans.add("" + lower);
		// else
		// ans.add(lower + "->" + upper);
		// return ans;
		// }
		//
		// if (lower == nums[i] - 2) {
		// ans.add("" + (lower + 1));
		// } else if (lower < nums[i] - 2) {
		// ans.add((lower + 1) + "->" + (nums[i] - 1));
		// }

		return ans;
	}

	public static void main(String[] args) {
		Solution163 solution = new Solution163();

		int[] nums = { 0, 1, 3, 50, 75 };
		int lower = 0;
		int upper = 99;

		List<String> ans = solution.findMissingRanges(nums, lower, upper);
		ans.stream().forEach(x -> System.out.println(x));
	}

}
