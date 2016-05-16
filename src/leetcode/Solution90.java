package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subsets II.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution90 {

	public void bt(List<List<Integer>> ans, int[] nums, List<Integer> subset,
			int length, int startIndex) {
		if (subset.size() == length) {
			boolean flag = true;
			for (List<Integer> list : ans) {
				if (list.equals(subset)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				ans.add(subset);
			}
			return;
		}

		for (int i = startIndex; i < nums.length; i++) {
			List<Integer> subset2 = new ArrayList<Integer>();
			for (int j = 0; j < subset.size(); j++) {
				subset2.add(subset.get(j));
			}
			subset2.add(nums[i]);
			bt(ans, nums, subset2, length, i + 1);
		}

	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		if (nums == null) {
			return ans;
		}

		Arrays.sort(nums);

		for (int length = 0; length <= nums.length; length++) {
			List<Integer> subset = new ArrayList<Integer>();
			bt(ans, nums, subset, length, 0);
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution90 solution = new Solution90();

		int[] nums = { 1, 2, 3, 4 };

		List<List<Integer>> ans = solution.subsetsWithDup(nums);
		for (List<Integer> list : ans) {
			System.out.print("[");
			for (int i : list) {
				System.out.print(i + ", ");
			}
			System.out.print("]");
		}
	}

}
