package leetcode;

/**
 * Flip Game II.
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
public class Solution294 {

	public boolean bt(String s) {
		StringBuffer sb = new StringBuffer(s);

		for (int i = 0; i < s.length() - 1; i++) {
			if (sb.charAt(i) == '+' && sb.charAt(i + 1) == '+') {
				sb.setCharAt(i, '-');
				sb.setCharAt(i + 1, '-');
				if (bt(sb.toString()) == false) {
					return true;
				}
				sb.setCharAt(i, '+');
				sb.setCharAt(i + 1, '+');
			}
		}

		return false;
	}

	public boolean canWin(String s) {
		if (s == null || s.length() < 2)
			return false;

		return bt(s);
	}

	public static void main(String[] args) {
		Solution294 solution = new Solution294();

		String s = "++++";
		System.out.println(solution.canWin(s));
	}

}
