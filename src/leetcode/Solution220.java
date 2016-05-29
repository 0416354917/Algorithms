package leetcode;

import java.util.TreeSet;

/**
 * Contains Duplicate III.
 * 
 * <p>
 * <b>Description: </b>
 * 
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the difference between nums[i] and nums[j] is at
 * most t and the difference between i and j is at most k.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>TreeSet.
 * </p>
 * 
 * <p>
 * <b>Reference: </b>
 * {@link https://leetcode.com/discuss/102273/easy-and-clear-java-solution-using-treeset}
 * </p>
 * 
 * <p>
 * <b>Note: </b>...
 * <p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution220 {
	/**
	 * TreeSet.
	 * 
	 * Status: Accepted.
	 * 
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k == 0)
			return false;

		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			if (set.floor(val) != null && (set.floor(val) + t >= val))
				return true;
			if (set.ceiling(val) != null && (set.ceiling(val) - t <= val))
				return true;
			if (i >= k)
				set.remove(nums[i - k]); // This remove step can make sure there
											// would not be any duplicate of val
											// in the treeset.
			set.add(val);
		}

		return false;
	}

	public static void main(String[] args) {
		Solution220 solution = new Solution220();

		int[] nums = { -5, 1, 6, 12, 20 };
		int k = 3;
		int t = 3;
		System.out.println(solution.containsNearbyAlmostDuplicate(nums, k, t));
	}

}
