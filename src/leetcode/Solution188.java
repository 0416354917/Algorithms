package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Best Time to Buy and Sell Stock IV.
 * 
 * <p>
 * <b>Description: </b> Say you have an array for which the ith element is the
 * price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Dynamic Programming.
 * </p>
 * 
 * <p>
 * <b>Reference: </b>...
 * </p>
 * 
 * <p>
 * <b>Note: </b>...
 * <p>
 * 
 * <p>
 * <b>Status: </b>...
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution188 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(200);
		list.add(300);

		for (int x : list) {
			if (x == 200)
				list.remove(new Integer(200));
		}

		List<Integer> ans = list.stream().filter(x -> x != 5)
				.collect(Collectors.toList());
		for (int x : ans)
			System.out.println(x);

	}

}
