package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution254 {

	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if (n == 1) {
			return ans;
		} else {
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {

					List<Integer> ass = new ArrayList<>();
					ass.add(i);
					ass.add(n / i);
					ans.add(ass);

					List<List<Integer>> ans2 = getFactors(n / i);
					if (!ans2.isEmpty()) {
						for (List<Integer> list2 : ans2) {
							List<Integer> list = new ArrayList<>();
							list.add(i);
							if (list2.get(0) >= i) {
								list.addAll(list2);
								ans.add(list);
							}
						}
					}

				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Solution254 solution = new Solution254();

		int n = 12;
		List<List<Integer>> ans = solution.getFactors(12);
		for (List<Integer> list : ans) {
			list.stream().forEach(x -> System.out.print(x + "  "));
			System.out.println();
		}

	}

}
