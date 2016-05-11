package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Status: Accepted.
 * 
 * @author Jason
 *
 */
public class Solution347 {

	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
		for (int num : nums) {
			if (counter.containsKey(num)) {
				counter.put(num, counter.get(num) + 1);
			} else {
				counter.put(num, 1);
			}
		}

		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(
				counter.entrySet());
		Collections.sort(list, (entry1, entry2) -> entry1.getValue()
				.compareTo(entry2.getValue()));

		List<Integer> result = new ArrayList<Integer>();
		int index = list.size() - 1;
		while (result.size() != k) {
			result.add(list.get(index).getKey());
			index--;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		Solution347 solution = new Solution347();
		List<Integer> answer = solution.topKFrequent(nums, k);
		for (int num : answer) {
			System.out.println(num);
		}
	}

}
