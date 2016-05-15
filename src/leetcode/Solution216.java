package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum III.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution216 {

	public void bt(List<List<Integer>> ans, List<Integer> a, int target,
			int k) {
		if (target < 0 || (target > 0 && a.size() == k)
				|| (target == 0 && a.size() != k))
			return;

		if (target == 0 && a.size() == k) {
			ans.add(a);
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (a.size() != 0) {
				int last = a.get(a.size() - 1);
				if (i <= last)
					continue;
			}

			List<Integer> a2 = new ArrayList<Integer>();
			for (int j = 0; j < a.size(); j++)
				a2.add(a.get(j));
			a2.add(i);

			bt(ans, a2, target - i, k);
		}

	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		List<Integer> a = new ArrayList<Integer>();

		bt(ans, a, n, k);

		return ans;
	}

	public static void main(String[] args) {
		Solution216 solution = new Solution216();
		int k = 3;
		int n = 9;

		List<List<Integer>> ans = solution.combinationSum3(k, n);
		for (List<Integer> list : ans) {
			System.out.print("[");
			for (int i : list) {
				System.out.print(i + ", ");
			}
			System.out.print("]");
		}
	}

}
