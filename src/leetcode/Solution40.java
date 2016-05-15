package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum II.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */

public class Solution40 {

	public void bt2(List<List<Integer>> ans, List<Integer> a, int target,
			int[] cand) {
		if (target < 0 || (target > 0 && a.size() == cand.length))
			return;

		if (target == 0) {
			ans.add(a);
			return;
		}

		for (int i = a.size(); i < cand.length; i++) {
			int offset = 0;
			if (a.size() != 0) {
				int last = a.get(a.size() - 1);
				if (cand[i] < last)
					continue;
				if (cand[i] == last) {
					int firstIndex = a.indexOf(last);
					int lastIndex = a.lastIndexOf(last);
					offset = lastIndex - firstIndex + 1;
					while (i > 0 && cand[i - 1] == cand[i]) {
						i--;
					}
					i += offset;
				}
			}

			List<Integer> a2 = new ArrayList<Integer>();
			for (int j = 0; j < a.size(); j++)
				a2.add(a.get(j));
			a2.add(cand[i]);

			bt2(ans, a2, target - cand[i], cand);
		}

	}

	public void bt(List<List<Integer>> ans, List<Integer> a, int target,
			int[] cand, int startIndex) {
		if (target < 0 || (target > 0 && a.size() == cand.length))
			return;

		if (target == 0) {
			boolean flag = true;
			for (List<Integer> list : ans) {
				if (list.equals(a)) {
					flag = false;
					break;
				}
			}
			if (flag)
				ans.add(a);
			return;
		}

		for (int i = startIndex; i < cand.length; i++) {
			List<Integer> a2 = new ArrayList<Integer>();
			for (int j = 0; j < a.size(); j++)
				a2.add(a.get(j));
			a2.add(cand[i]);

			bt(ans, a2, target - cand[i], cand, i + 1);
		}

	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		Arrays.sort(candidates);

		List<Integer> a = new ArrayList<Integer>();

		bt(ans, a, target, candidates, 0);

		return ans;
	}

	public static void main(String[] args) {
		Solution40 solution = new Solution40();

		// int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		// int target = 8;
		int[] candidates = { 1, 1, 2, 3 };
		int target = 4;

		List<List<Integer>> ans = solution.combinationSum2(candidates, target);
		for (List<Integer> list : ans) {
			System.out.print("[");
			for (int i : list) {
				System.out.print(i + ", ");
			}
			System.out.print("]");
		}
	}

}
