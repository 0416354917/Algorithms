package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Intersection of Two Arrays.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution349 {

	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null)
			return nums2;

		if (nums2 == null)
			return nums1;

		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		Arrays.stream(nums1).forEach(i -> set1.add(i));
		Arrays.stream(nums2).forEach(i -> set2.add(i));
		return set1.stream().filter(i -> set2.contains(i))
				.mapToInt(i -> i.intValue()).toArray();
	}

	public static void main(String[] args) {
		Solution349 solution = new Solution349();

		int[] nums1 = { 1, 3, 5, 7 };
		int[] nums2 = { 1, 2, 3 };

		int[] result = solution.intersection(nums1, nums2);
		if (result != null) {
			for (int x : result)
				System.out.println(x);
		}
	}

}
