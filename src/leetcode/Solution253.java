package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Meeting Rooms II.
 * 
 * <p>
 * <b>Description: </b>Given an array of meeting time intervals consisting of
 * start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number
 * of conference rooms required.
 * 
 * For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 * 
 * Show Company Tags Show Tags Show Similar Problems
 * 
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Greedy.
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
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
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

		List<List<Interval>> rooms = new ArrayList<>();

		List<Interval> room1 = new ArrayList<>();
		room1.add(intervals[0]);
		rooms.add(room1);
		ans++;
		for (int i = 1; i < intervals.length; i++) {
			Interval it = intervals[i];
			boolean scheduled = false;
			for (List<Interval> room : rooms) {
				if (room.get(room.size() - 1).end <= it.start) {
					room.add(it);
					scheduled = true;
					break;
				}
			}
			if (!scheduled) {
				List<Interval> newRoom = new ArrayList<>();
				newRoom.add(it);
				rooms.add(newRoom);
				ans++;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution253 solution = new Solution253();

		Interval it1 = solution.new Interval(0, 30);
		Interval it2 = solution.new Interval(5, 10);
		Interval it3 = solution.new Interval(15, 20);

		Interval[] intervals = { it1, it2, it3 };
		System.out.println(solution.minMeetingRooms(intervals));
	}

}
