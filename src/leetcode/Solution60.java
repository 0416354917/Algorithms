package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutation Sequence.
 * 
 * <p>
 * <b>Status: CE.</b>
 * <p>
 * 
 * @author Jason
 *
 */
public class Solution60 {
	private int k = 0;

	public List<Integer> bt(int n, int k, List<Integer> a) {
		if (a.size() == n) {
			if (this.k == 1)
				return a;
			else {
				this.k--;
				return null;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (a.contains(i)) {
				continue;
			}
			List<Integer> a2 = new ArrayList<Integer>();
			for (int j = 0; j < a.size(); j++) {
				a2.add(a.get(j));
			}
			a2.add(i);
			List<Integer> btRtn = bt(n, this.k, a2);
			if (btRtn != null)
				return btRtn;
		}

		return null;
	}

	public String getPermutation(int n, int k) {
		// pre-processing:
		int[] factorial = new int[n + 1];
		factorial[0] = 0;
		factorial[1] = 1;
		for (int i = 2; i <= n; i++) {
			factorial[i] = factorial[i - 1] * i;
		}

		int fixed = 0;
		int i = 1;
		for (; i <= n; i++) {
			if (factorial[i] > k)
				break;
		}
		fixed = n - (i - 1);

		this.k = k;

		List<Integer> ans = new ArrayList<Integer>();

		if (fixed > 0) {
			for (int j = 1; j <= fixed; j++) {
				ans.add(j);
			}
		}

		// to be fixed:
		for (int x : ans) {
			this.k -= factorial[n - x] * x;
		}

		List<Integer> rtn = bt(n, this.k, ans);

		StringBuffer sb = new StringBuffer();
		for (int x : rtn)
			sb.append(x);
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution60 solution = new Solution60();

		int n = 9;
		// int k = 3;
		int k = 278082; // 792346851
		System.out.println(solution.getPermutation(n, k));
	}

}
