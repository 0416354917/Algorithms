package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Maximum Gap.
 * 
 * <p>
 * <b>Description: </b>Given an unsorted array, find the maximum difference
 * between the successive elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * You may assume all elements in the array are non-negative integers and fit in
 * the 32-bit signed integer range.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>(Radix) Sort.
 * </p>
 * {@link https://en.wikipedia.org/wiki/Radix_sort#Iterative_version_using_queues}
 * <p>
 * <b>Status: </b>...
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution164 {

	public int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2)
			return 0;

		HashMap<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();

		List<Integer> q0 = new LinkedList<Integer>();
		List<Integer> q1 = new LinkedList<Integer>();
		List<Integer> q2 = new LinkedList<Integer>();
		List<Integer> q3 = new LinkedList<Integer>();
		List<Integer> q4 = new LinkedList<Integer>();
		List<Integer> q5 = new LinkedList<Integer>();
		List<Integer> q6 = new LinkedList<Integer>();
		List<Integer> q7 = new LinkedList<Integer>();
		List<Integer> q8 = new LinkedList<Integer>();
		List<Integer> q9 = new LinkedList<Integer>();

		map.put('0', q0);
		map.put('1', q1);
		map.put('2', q2);
		map.put('3', q3);
		map.put('4', q4);
		map.put('5', q5);
		map.put('6', q6);
		map.put('7', q7);
		map.put('8', q8);
		map.put('9', q9);

		int index = 0;
		for (int pos = 0; pos <= 9; pos++) {
			int index2 = index;
			for (; index2 < nums.length; index2++) {
				int num = nums[index2];
				String s = Integer.toString(num);
				map.get(s.charAt(s.length() - 1 - pos)).add(num);
			}

			List<Integer> l = new ArrayList<Integer>();
			for (char ch = '0'; ch <= '9'; ch++) {
				List<Integer> bucket = map.get(ch);
				while (!bucket.isEmpty()) {
					int num = bucket.remove(0);
					if (Integer.toString(num).length() == pos + 1) {
						nums[index++] = num;
					} else {
						l.add(num);
					}
				}
			}

			index2 = index;
			for (int x : l) {
				nums[index2++] = x;
			}

			// if no more change happens:
			if (l.isEmpty())
				break;
		}

		int ans = nums[1] - nums[0];
		for (int i = 2; i < nums.length; i++)
			ans = Math.max(ans, nums[i] - nums[i - 1]);

		return ans;
	}

	public static void main(String[] args) {
		Solution164 solution = new Solution164();

		int[] nums = { 12, 15, 3, 104, 4, 5, 7 };
		System.out.println(solution.maximumGap(nums));
	}

}
