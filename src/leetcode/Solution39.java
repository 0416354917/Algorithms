package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum.
 * 
 * <p>
 * <b>Status: .</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution39 {

	public void backTracking(List<List<Integer>> ans, List<Integer> cands, List<Integer> assignments,
			int target) {
		if(target == 0) {
			ans.add(assignments);
		}
			
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
