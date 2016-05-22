package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals.
 * 
 * <p>
 * <b>Description: </b>Given a collection of intervals, merge all overlapping
 * intervals. For example, Given [1,3],[2,6],[8,10],[15,18], return
 * [1,6],[8,10],[15,18].
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Sort.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution56 {

	// Definition for an interval.
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> ans = new ArrayList<Interval>();

		if (intervals == null || intervals.size() == 0)
			return ans;

		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start < o2.start)
					return -1;
				else if (o1.start == o2.start) {
					if (o1.end < o2.end)
						return -1;
					else if (o1.end == o2.end)
						return 0;
					else
						return 1;
				} else
					return 1;
			}

		});

		ans.add(intervals.get(0));
		Interval p = ans.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval q = intervals.get(i);
			if (q.start <= p.end) {
				p.end = Math.max(p.end, q.end);
			} else {
				ans.add(q);
				p = q;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution56 solution = new Solution56();

		List<Interval> intervals = new ArrayList<Interval>();
		Interval i1 = solution.new Interval(1, 3);
		Interval i2 = solution.new Interval(2, 6);
		Interval i3 = solution.new Interval(8, 10);
		Interval i4 = solution.new Interval(15, 18);
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);

		List<Interval> ans = solution.merge(intervals);

		for (Interval x : ans) {
			System.out.println("[" + x.start + ", " + x.end + "]");
		}

	}

}
