package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Intersection of Two Arrays II.
 * 
 * <p>
 * <b>Description: </b>Given two arrays, write a function to compute their
 * intersection.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Hash Table.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution350 {

	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null)
			return nums2;

		if (nums2 == null)
			return nums1;

		Map<Integer, Integer> counter1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> counter2 = new HashMap<Integer, Integer>();
		for (int x : nums1) {
			if (counter1.containsKey(x))
				counter1.put(x, counter1.get(x) + 1);
			else
				counter1.put(x, 1);
		}
		for (int x : nums2) {
			if (counter2.containsKey(x))
				counter2.put(x, counter2.get(x) + 1);
			else
				counter2.put(x, 1);
		}

		List<Integer> ans = new ArrayList<Integer>();
		for (int key : counter1.keySet()) {
			if (counter2.containsKey(key)) {
				int count = Math.min(counter1.get(key), counter2.get(key));
				for (int i = 0; i < count; i++)
					ans.add(key);
			}
		}

		return IntStream.range(0, ans.size()).map(i -> ans.get(i)).toArray();
	}

	public static void main(String[] args) {
		Solution350 solution = new Solution350();

		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };

		int[] ans = solution.intersect(nums1, nums2);
		Arrays.stream(ans).forEach(i -> System.out.println(i + "  "));
	}

}
