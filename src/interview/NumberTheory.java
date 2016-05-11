package interview;

public class NumberTheory {

	/**
	 * Greatest Common Divisor of 2 non-negative integers.
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static int gcd(int m, int n) {
		// let n be the larger number.
		int a = m > n ? m : n;
		int b = m < n ? m : n;
		n = a;
		m = b;

		int r = n % m;
		while (r != 0) {
			n = m;
			m = r;
			r = n % m;
		}

		return m;
	}

	/**
	 * Least Common Multiple.
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static int lcd(int m, int n) {
		return m * n / gcd(m, n);
	}

	/**
	 * Greatest Common Divisor of an array of non-negative integers.
	 * 
	 * @param nums
	 * @return
	 */
	public static int arrayGcd(int[] nums) {
		return 0;
	}

	/**
	 * Least Common Multiple of an array of non-negative integers.
	 * 
	 * @param nums
	 * @return
	 */
	public static int arrayLcd(int[] nums) {
		return 0;
	}

}
