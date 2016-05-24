package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reconstruct Itinerary.
 * 
 * <p>
 * <b>Description: </b>Given a list of airline tickets represented by pairs of
 * departure and arrival airports [from, to], reconstruct the itinerary in
 * order. All of the tickets belong to a man who departs from JFK. Thus, the
 * itinerary must begin with JFK.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Backtracking.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution332 {

	public boolean bt(Map<String, List<String>> map, List<String> ans, int k) {
		if (ans.size() == k)
			return true;

		List<String> next = map.get(ans.get(ans.size() - 1));

		if (next == null || next.isEmpty())
			return false;

		Collections.sort(next);

		for (int i = 0; i < next.size(); i++) {
			String s = next.get(i);
			ans.add(s);
			next.remove(i);
			if (bt(map, ans, k))
				return true;
			else {
				next.add(i, s);
				ans.remove(ans.size() - 1);
			}
		}

		return false;
	}

	public List<String> findItinerary(String[][] tickets) {
		List<String> ans = new ArrayList<String>();

		if (tickets == null || tickets.length == 0 || tickets[0].length == 0)
			return ans;

		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (int row = 0; row < tickets.length; row++) {
			String from = tickets[row][0];
			String to = tickets[row][1];
			if (!map.containsKey(from)) {
				List<String> list = new ArrayList<String>();
				list.add(to);
				map.put(from, list);
			} else {
				map.get(from).add(to);
			}
		}

		ans.add("JFK");

		bt(map, ans, tickets.length + 1);

		return ans;
	}

	public static void main(String[] args) {
		Solution332 solution = new Solution332();

		// String[][] tickets = { { "MUC", "LHR" }, { "JFK", "MUC" },
		// { "SFO", "SJC" }, { "LHR", "SFO" } };

		String[][] tickets = { { "JFK", "SFO" }, { "JFK", "ATL" },
				{ "SFO", "ATL" }, { "ATL", "JFK" }, { "ATL", "SFO" } };
		List<String> ans = solution.findItinerary(tickets);
		for (String s : ans)
			System.out.println(s);
	}

}
