package leetcode;

/**
 * Self Crossing.
 * 
 * <p>
 * <b>Description: </b>You are given an array x of n positive numbers. You start
 * at point (0,0) and moves x[0] metres to the north, then x[1] metres to the
 * west, x[2] metres to the south, x[3] metres to the east and so on. In other
 * words, after each move your direction changes counter-clockwise.
 * 
 * Write a one-pass algorithm with O(1) extra space to determine, if your path
 * crosses itself, or not.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Math.
 * </p>
 * 
 * <p>
 * <b>Status: </b>WA.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution335 {

	class Point {
		int x;
		int y;

		Point() {

		}

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	class Line {
		Point p1;
		Point p2;

		Line() {

		}

		Line(Point p1, Point p2) {
			this.p1 = p1;
			this.p2 = p2;
		}
	}

	public boolean isSelfCrossing(int[] x) {
		if (x == null || x.length == 0)
			return false;

		int n = x.length;
		int x0 = 0, y0 = 0;
		Point p0 = new Point(x0, y0);
		Point p1 = new Point();
		Line left = null, right = null, up = null, bottom = null;

		int i = 0;
		while (i < n) {
			System.out.println(i);
			// move up: right line.
			if (i < n) {
				x0 -= x[i];
				p1 = new Point(x0, y0);
				if (right != null) {
					// check right:
					if (x0 >= Math.min(right.p1.x, right.p2.x)
							&& x0 <= Math.max(right.p1.x, right.p2.x)) {
						if (y0 == right.p1.y) {
							System.out.println("qwe");
							return true;
						}
						if (y0 > right.p1.y) {
							left = right;
						}
					}
				}
				right = new Line(p1, p0);
				// check right & up:
				if (up != null && y0 >= Math.min(up.p1.y, up.p2.y)
						&& y0 <= Math.max(up.p1.y, up.p2.y) && x0 <= up.p1.x) {
					System.out.println("(" + up.p1.x + ", " + up.p1.y + ")");
					System.out.println("(" + up.p2.x + ", " + up.p2.y + ")");
					System.out.println("asd");
					return true;
				}
			} else {
				return false;
			}

			i++;
			System.out.println(i);
			p0 = p1;
			// move left: up line.
			if (i < n) {
				y0 -= x[i];
				p1 = new Point(x0, y0);
				if (up != null) {
					if (y0 >= Math.min(up.p1.y, up.p2.y)
							&& y0 <= Math.max(up.p1.y, up.p2.y)) {
						if (x0 == up.p1.x) {
							return true;
						}

						if (x0 < up.p1.x) {
							bottom = up;
						}
					}
				}
				up = new Line(p1, p0);
				// check up & left:
				if (left != null && y0 <= left.p1.y
						&& x0 >= Math.min(left.p1.x, left.p2.x)
						&& x0 <= Math.max(left.p1.x, left.p2.x)) {
					return true;
				}
			} else {
				return false;
			}

			i++;
			System.out.println(i);
			p0 = p1;
			// move down: left line.
			if (i < n) {
				x0 += x[i];
				p1 = new Point(x0, y0);
				if (left != null) {
					if (x0 >= Math.min(left.p1.x, left.p2.x)
							&& x0 <= Math.max(left.p1.x, left.p2.x)) {
						if (y0 == left.p1.y) {
							return true;
						}
						if (y0 < left.p1.y) {
							right = left;
						}
					}
				}
				left = new Line(p0, p1);
				// check left & bottom:
				if (bottom != null && x0 >= bottom.p1.x
						&& y0 >= Math.min(bottom.p1.y, bottom.p2.y)
						&& y0 <= Math.max(bottom.p1.y, bottom.p2.y)) {
					return true;
				}
			} else {
				return false;
			}

			i++;
			System.out.println(i);
			p0 = p1;
			// move right: bottom line.
			if (i < n) {
				y0 += x[i];
				p1 = new Point(x0, y0);
				if (bottom != null) {
					if (y0 >= Math.min(bottom.p1.y, bottom.p2.y)
							&& y0 <= Math.max(bottom.p1.y, bottom.p2.y)) {
						if (x0 == bottom.p1.y) {
							return true;
						}
						if (x0 > bottom.p1.y) {
							up = bottom;
						}
					}
				}
				bottom = new Line(p0, p1);
				// check bottom & right:
				if (right != null && y0 >= right.p1.y
						&& x0 >= Math.min(right.p1.x, right.p2.x)
						&& x0 <= Math.max(right.p1.x, right.p2.x)) {
					return true;
				}

			} else {
				return false;
			}

			i++;
		}

		return false;
	}

	public static void main(String[] args) {
		Solution335 solution = new Solution335();

		// int[] x1 = { 2, 1, 1, 2 }; // true.
		// System.out.println(solution.isSelfCrossing(x1));
		//
		// int[] x2 = { 1, 2, 3, 4 }; // false.
		// System.out.println(solution.isSelfCrossing(x2));
		//
		// int[] x3 = { 1, 1, 1, 1 }; // true.
		// System.out.println(solution.isSelfCrossing(x3));

		int[] x4 = { 2, 1, 4, 4, 3, 2, 2, 1, 1 }; // false.
		System.out.println(solution.isSelfCrossing(x4));
	}

}
