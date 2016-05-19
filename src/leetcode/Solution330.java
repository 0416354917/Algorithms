package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution330 {

	public void bt(Set<Integer> sums, int[] nums, List<Integer> a,
			int startIndex, int length) {
		if (a.size() == length) {
			sums.add(a.stream().reduce(0, (x, y) -> x + y));
			return;
		}

		for (int i = startIndex; i < nums.length; i++) {
			List<Integer> a2 = new ArrayList<Integer>();
			for (int j = 0; j < a.size(); j++)
				a2.add(a.get(j));
			a2.add(nums[i]);
			bt(sums, nums, a2, i + 1, length);
		}
	}

	/**
	 * MLE.
	 * 
	 * @param nums
	 * @param n
	 * @return
	 */
	public int minPatches1(int[] nums, int n) {
		// int[] flags = new int[n + 1];
		List<Integer> flags = new ArrayList<Integer>();
		flags.add(-1);
		for (int i = 1; i <= n; i++) {
			flags.add(0);
		}
		int count = n;

		Set<Integer> sums = new HashSet<Integer>();

		for (int length = 1; length <= nums.length; length++) {
			List<Integer> a = new ArrayList<Integer>();
			bt(sums, nums, a, 0, length);
		}

		for (int x : sums) {
			flags.set(x, 1);
			count--;
			// System.out.println(x);
		}

		int ans = 0;
		while (count != 0) {
			ans++;
			int patch = flags.indexOf(0);
			for (int i = 1; i <= n; i++) {
				int cur = flags.get(i);
				if (cur == 1) {
					int j = i + patch;
					if (j <= n && flags.get(j) != 1) {
						flags.set(j, 1);
						count--;
					}
				}
			}
			flags.set(patch, 1);
			count--;
		}

		return ans;
	}

	/**
	 * WA.
	 * 
	 * @param nums
	 * @param n
	 * @return
	 */
	public int minPatches(int[] nums, int n) {
		int ans = 0;

		int acc = 0;
		int next = 0;
		while (acc < n) {
			next++;
			acc += next;
			if (acc < 0)
				break;
		}

		ans = next;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= next)
				ans--;
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution330 solution = new Solution330();

		int[] nums = { 1, 3 };
		int n = 6;
		System.out.println(solution.minPatches(nums, n)); // 1

		int[] nums1 = { 1, 5, 10 };
		int n1 = 20;
		System.out.println(solution.minPatches(nums1, n1)); // 2

		int a = 1;
		int b = 2147483647;
		System.out.println(a + b);
	}

}
