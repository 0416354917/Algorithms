package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution253 {

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

	public int minMeetingRooms(Interval[] intervals) {
		int ans = 0;

		if (intervals == null || intervals.length == 0)
			return 0;

		Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start < o2.start) {
					return -1;
				} else if (o1.start > o2.start) {
					return 1;
				} else if (o1.start == o2.start) {
					if (o1.end < o2.end) {
						return -1;
					} else if (o1.end > o2.end) {
						return 1;
					} else {
						return 0;
					}
				}
				return 0;
			}

		});
		List<Integer> end = new ArrayList<>();
		end.add(intervals[0].end);
		ans++;
		int i = 0;
		int minStart = intervals[0].end;
		while (i < intervals.length - 1) {
			i++;
			Interval it = intervals[i];
			if(it.end < minStart) {
				
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
