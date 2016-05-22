package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Insert Interval.
 * 
 * <p>
 * <b>Description: </b>Given a set of non-overlapping intervals, insert a new
 * interval into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>...
 * </p>
 * 
 * <p>
 * <b>Status: </b>...
 * </p>
 * *
 * 
 * @author Jason
 *
 */
public class Solution57 {

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

	public List<Interval> insert(List<Interval> intervals,
			Interval newInterval) {
		// corner cases:
		if (intervals == null || intervals.size() == 0) {
			if (newInterval != null) {
				List<Interval> ans = new ArrayList<Interval>();
				ans.add(newInterval);
				return ans;
			}
		} else if (newInterval == null) {
			return intervals;
		} else if (newInterval.end < intervals.get(0).start) {
			intervals.add(0, newInterval);
			return intervals;
		}

		// find position to insert:
		Interval p = intervals.get(0);
		int index = 0;
		while (index < intervals.size()) {
			p = intervals.get(index);
			if (newInterval.start > p.start) {
				index++;
			} else {
				break;
			}
		}
		intervals.add(index, newInterval);

		// merge left:
		int left = index - 1;
		int countLeft = 0;
		if (left >= 0 && newInterval.start <= intervals.get(left).end) {
			newInterval.start = intervals.get(left).start;
			if (newInterval.end <= intervals.get(left).end) {
				newInterval.end = intervals.get(left).end;
				intervals.remove(left);
				return intervals;
			}
			countLeft = 1;
		}

		// merge right:
		int right = index + 1;
		int countRight = 0;
		while (right < intervals.size()) {
			Interval r = intervals.get(right);
			if (newInterval.end < r.start)
				break;
			else if (newInterval.end >= r.start && newInterval.end <= r.end) {
				countRight++;
				newInterval.end = r.end;
				break;
			} else {
				countRight++;
				right++;
			}
		}
		// delete right:
		while (countRight != 0) {
			intervals.remove(index + 1);
			countRight--;
		}
		// delete left:
		if (countLeft == 1)
			intervals.remove(left);

		return intervals;
	}

	public static void main(String[] args) {
		Solution57 solution = new Solution57();

		List<Interval> intervals = new ArrayList<Interval>();
		Interval i1 = solution.new Interval(1, 2);
		Interval i2 = solution.new Interval(3, 5);
		Interval i3 = solution.new Interval(6, 7);
		Interval i4 = solution.new Interval(8, 10);
		Interval i5 = solution.new Interval(12, 16);
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		intervals.add(i5);

		Interval newInterval = solution.new Interval(4, 9);

		List<Interval> ans = solution.insert(intervals, newInterval);

		for (Interval x : ans) {
			System.out.println("[" + x.start + ", " + x.end + "]");
		}
	}

}
