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

		if (i == nums.length) {
			if (lower == upper)
				ans.add("" + lower);
			else
				ans.add(lower + "->" + upper);
			return ans;
		}

		// upper:
		int j = i;
		while (j < nums.length && upper > nums[j]) {
			j++;
		}

		if (j == i) {
			if (lower == upper) {
				if (nums[i] != lower)
					ans.add("" + lower);
			} else {
				if (upper != nums[i])
					ans.add(lower + "->" + upper);
				else {
					if (lower == upper - 1) {
						ans.add("" + lower);
					} else {
						ans.add(lower + "->" + (upper - 1));
					}
				}
			}
			return ans;
		}

		int last = lower;
		int k = i;
		for (; k <= j - 1; k++) {
			if (last + 1 == nums[k]) {
				ans.add("" + (last));
			} else if (last + 1 < nums[k]) {
				ans.add((last) + "->" + (nums[k] - 1));
			}
			last = nums[k];
		}

		k--;
		if (nums[k] + 1 == upper) {
			ans.add("" + upper);
		}
		if (nums[k] + 1 < upper) {
			ans.add((nums[k] + 1) + "->" + (upper));
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution163 solution = new Solution163();

		// int[] nums = { 0, 1, 3, 50, 75 };
		// int lower = 0;
		// int upper = 99;
		int[] nums = { -1 };
		int lower = -2;
		int upper = 0;

		List<String> ans = solution.findMissingRanges(nums, lower, upper);
		ans.stream().forEach(x -> System.out.println(x));
	}

}
