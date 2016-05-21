package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Permutations II.
 * 
 * <p>
 * <b>Description: </b>Given a collection of numbers that might contain
 * duplicates, return all possible unique permutations.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Backtracking.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution47 {

	public void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	public void backtracking(List<List<Integer>> ans, int[] nums, int index) {
		if (index == nums.length) {
			List<Integer> temp = new ArrayList<Integer>();
			for (int x : nums)
				temp.add(x);
			ans.add(temp);
		}

		Set<Integer> explored = new HashSet<Integer>();
		for (int i = index; i < nums.length; i++) {
			if (explored.add(nums[i])) {
				swap(nums, index, i);
				backtracking(ans, nums, index + 1);
				swap(nums, index, i);
			}
		}
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		if (nums == null || nums.length == 0)
			return ans;

		backtracking(ans, nums, 0);

		return ans;
	}

	/* TLE Solution */

	/**
	 * TLE.
	 * 
	 * @param ans
	 * @param k
	 * @param nums
	 * @param a
	 * @param indices
	 */
	public void backtracking2(List<List<Integer>> ans, int k, int[] nums,
			List<Integer> a, Set<Integer> indices) {
		if (a.size() == k) {
			if (!ans.contains(a)) {
				ans.add(a);
			}
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (indices.contains(i))
				continue;
			Set<Integer> indices2 = new HashSet<Integer>();
			indices.stream().forEach(x -> indices2.add(x));
			indices2.add(i);
			List<Integer> a2 = new ArrayList<Integer>();
			a.stream().forEach(x -> a2.add(x));
			a2.add(nums[i]);
			backtracking2(ans, k, nums, a2, indices2);
		}
	}

	public List<List<Integer>> permuteUnique2(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		if (nums == null || nums.length == 0)
			return ans;

		int k = nums.length;
		List<Integer> a = new ArrayList<Integer>();
		Set<Integer> indices = new HashSet<Integer>();
		backtracking2(ans, k, nums, a, indices);

		return ans;
	}

	public static void main(String[] args) {
		Solution47 solution = new Solution47();

		// int[] nums = { 1, 1, 2 };
		int[] nums = { -1, 2, -1, 2, 1, -1, 2, 1 };

		List<List<Integer>> ans = solution.permuteUnique(nums);
		for (List<Integer> list : ans) {
			System.out.print("[");
			for (int i = 0; i < list.size() - 1; i++) {
				System.out.print(list.get(i) + ", ");
			}
			System.out.println(list.get(list.size() - 1) + "]");
		}
	}

}
