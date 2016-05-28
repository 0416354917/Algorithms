package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Max Points on a Line.
 * 
 * <p>
 * <b>Description: </b>Given n points on a 2D plane, find the maximum number of
 * points that lie on the same straight line.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Hash Table, Math.
 * </p>
 * 
 * <p>
 * <b>Reference: </b>
 * {@link http://yucoding.blogspot.com.au/2013/12/leetcode-question-max-points-on-line.html}
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution149 {

	/**
	 * Definition for a point.
	 */
	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public int gcd(int x, int y) {
		if (x < y) {
			int t = x;
			x = y;
			y = t;
		}

		int r = x % y;
		while (r != 0) {
			x = y;
			y = r;
			r = x % y;
		}

		return y;
	}

	public String stringSlope(Point p1, Point p2) {
		int x = p1.x - p2.x;
		int y = p1.y - p2.y;

		int flag = 1;
		if (x < 0) {
			x = -x;
			flag = -flag;
		}
		if (y < 0) {
			y = -y;
			flag = -flag;
		}

		int gcd = gcd(x, y);
		x = x / gcd;
		y = y / gcd;

		StringBuffer sb = new StringBuffer();
		if (flag == -1)
			sb.append("-");
		sb.append(x);
		sb.append("/");
		sb.append(y);

		return sb.toString();
	}

	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0)
			return 0;

		if (points.length <= 2)
			return points.length;

		int ans = 0;

		for (int i = 0; i < points.length; i++) {
			int dup = 0;
			Map<String, Integer> map = new HashMap<String, Integer>();
			for (int j = 0; j < points.length; j++) {
				if (points[j].x == points[i].x && points[j].y == points[i].y) {
					dup++;
				} else if (points[j].x == points[i].x) {
					map.put("h", map.getOrDefault("h", 0) + 1);
				} else if (points[j].y == points[i].y) {
					map.put("v", map.getOrDefault("v", 0) + 1);
				} else {
					String slope = stringSlope(points[i], points[j]);
					map.put(slope, map.getOrDefault(slope, 0) + 1);
				}
			}
			if (map.isEmpty())
				ans = Math.max(ans, dup);
			else {
				int t = 0;
				for (int v : map.values()) {
					t = Math.max(t, v);
				}
				ans = Math.max(ans, t + dup);
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution149 solution = new Solution149();

		Point p1 = solution.new Point(0, 0);
		Point p2 = solution.new Point(1, 1);
		Point p3 = solution.new Point(1, -1);

		Point[] points = { p1, p2, p3 };

		System.out.println(solution.maxPoints(points));
	}

}
