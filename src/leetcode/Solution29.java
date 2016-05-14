package leetcode;

/**
 * Divide Two Integers.
 * 
 * <p>
 * <b>Status: .</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution29 {

	/**
	 * TLE.
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public int divide2(int dividend, int divisor) {
		if (divisor == 0)
			return Integer.MAX_VALUE;

		if (dividend == 0)
			return 0;

		if (dividend < divisor)
			return 0;

		int ans = 0;
		int flag = ((dividend > 0 && divisor > 0)
				|| (dividend < 0 && divisor < 0)) ? 1 : -1;
		dividend = dividend > 0 ? dividend : -dividend;
		divisor = divisor > 0 ? divisor : -divisor;
		while (dividend > divisor) {
			ans += 1;
			dividend -= divisor;
		}

		return flag * ans;
	}

	public int divide(int dividend, int divisor) {
		if (divisor == 1)
			return dividend;

		if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
			return Integer.MAX_VALUE;

		if (dividend == divisor)
			return 1;

		if (dividend == 0 || divisor == Integer.MIN_VALUE)
			return 0;

		int ans = 1;
		int originalDividend = dividend;
		int flag = ((dividend > 0 && divisor > 0)
				|| (dividend < 0 && divisor < 0)) ? 1 : -1;
		if (dividend == Integer.MIN_VALUE)
			dividend = Integer.MAX_VALUE;
		else
			dividend = dividend > 0 ? dividend : -dividend;
		divisor = divisor > 0 ? divisor : -divisor;

		if (dividend < divisor)
			return 0;

		if (dividend == divisor)
			return flag;

		int reminder = dividend;
		int dividendCopy = dividend;

		while (reminder > (divisor << 1) && reminder > 2) {
			int temp = dividend;
			dividend = (dividend >> 1);
			if (dividend > divisor) {
				ans = (ans << 1);
				if (originalDividend == Integer.MIN_VALUE) {
					dividend++;
					originalDividend = 0;
				}
			} else {
				dividend = temp;
				reminder = dividendCopy - divisor * ans
						+ ((originalDividend == 0) ? 1 : 0);
				System.out.println("r = " + reminder);
				break;
			}
		}

		ans += reminder / divisor;


		return flag * ans;
	}

	public static void main(String[] args) {
		Solution29 solution = new Solution29();

		int n = 100, m = 23;
		n = -2147483648;
		m = 2;

		System.out.println(n + " / " + m + " = " + solution.divide(n, m));
	}

}
