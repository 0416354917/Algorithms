package leetcode;

import java.util.List;

/**
 * Insert Interval.
 * 
 * <p>
 * <b>Status: .</b>
 * </p>
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
		if (intervals == null) {
			if (newInterval != null) {
				intervals.add(newInterval);
				return intervals;
			}
		} else if (newInterval == null) {
			return intervals;
		}

		int index = 0;
		Interval first = intervals.get(0);
		Interval last = intervals.get(intervals.size() - 1);
//		if(newInterval.end)
		while (newInterval.start > first.start) {
			if (newInterval.end <= first.end)
				break;
			else {
				index++;
				first = intervals.get(index);
			}
		}

		return intervals;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
