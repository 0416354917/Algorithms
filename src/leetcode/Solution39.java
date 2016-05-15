package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution39 {

	public void backTracking(List<List<Integer>> ans, int[] candidates,
			List<Integer> a, int target) {

		if (target < 0) {
			return;
		}

		if (target == 0) {
			ans.add(a);
			return;
		}

		for (int i = 0; i < candidates.length; i++) {
			if (a.size() == 0 || candidates[i] >= a.get(a.size() - 1)) {
				List<Integer> a2 = new ArrayList<Integer>();
				for (int j = 0; j < a.size(); j++)
					a2.add(a.get(j));
				a2.add(candidates[i]);
				backTracking(ans, candidates, a2, target - candidates[i]);
			}
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		Arrays.sort(candidates);

		List<Integer> assignmnet = new ArrayList<Integer>();

		backTracking(ans, candidates, assignmnet, target);

		return ans;
	}

	public static void main(String[] args) {
		Solution39 solution = new Solution39();

		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;

		List<List<Integer>> ans = solution.combinationSum(candidates, target);
		for (List<Integer> list : ans) {
			System.out.print("[");
			for (int i : list) {
				System.out.print(i + ", ");
			}
			System.out.print("]");
		}
	}

}
