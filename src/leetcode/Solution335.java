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
 * <b>Algorithm: </b>...
 * </p>
 * 
 * <p>
 * <b>Status: </b>...
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution335 {

	public boolean isSelfCrossing(int[] x) {
		if (x[3] < x[1])
			return false;
		else {
			if (x[2] <= x[0])
				return true;
			else
				return false;
		}
	}

	public static void main(String[] args) {
		Solution335 solution = new Solution335();

		int[] x1 = { 2, 1, 1, 2 };
		System.out.println(solution.isSelfCrossing(x1));

		int[] x2 = { 1, 2, 3, 4 };
		System.out.println(solution.isSelfCrossing(x2));

		int[] x3 = { 1, 1, 1, 1 };
		System.out.println(solution.isSelfCrossing(x3));
	}

}
