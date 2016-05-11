package leetcode;

/**
 * Power of Three.
 * 
 * Status: Accepted.
 * 
 * @author Jason
 *
 */
public class Solution326 {

	public boolean isPowerOfThree(int n) {
		// (int) Math.pow(3, (int) (Math.log(Integer.MAX_VALUE) /
		// Math.log(3.0))) = 1162261467
		if (n <= 0)
			return false;
		else
			return 1162261467 % n == 0;
	}

	/**
	 * {@link https://leetcode.com/discuss/100490/java-one-line-solution}
	 * 
	 * @author jinwu
	 * @param n
	 * @return
	 */
	public boolean isPowerOfThree2(int n) {
		// The expression "(int) Math.pow(3, (int) (Math.log(Integer.MAX_VALUE)
		// / Math.log(3.0))" returns max integer that is "power of 3"
		return n > 0 && (int) Math.pow(3,
				(int) (Math.log(Integer.MAX_VALUE) / Math.log(3.0))) % n == 0;
	}

	/**
	 * Wrong Answer!
	 * 
	 * @param n
	 * @return
	 */
	public boolean isPowerOfThree3(int n) {
		if (n > 0) {
			System.out.println(
					Math.round(Math.pow(3, Math.log(n) / Math.log(3))));
			System.out.println(
					(int) Math.pow(3, (int) (Math.log(n) / Math.log(3))));
			// Math.round(Math.pow(3, (int) (Math.log(n) / Math.log(3)))));
			if ((int) Math.pow(3, (int) (Math.log(n) / Math.log(3))) == n) {
				// if (Math.round(
				// Math.pow(3, (int) (Math.log(n) / Math.log(3)))) == n) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// System.out.println((int) Math.pow(3, (int)
		// (Math.log(Integer.MAX_VALUE) / Math.log(3.0))));
		for (int n = 0; n <= 10; n++)
			System.out.println("n = " + n + ", solution = "
					+ new Solution326().isPowerOfThree3(n));
		System.out.println("n = " + 243 + ", solution = "
				+ new Solution326().isPowerOfThree3(243));

		// System.out.println(new Solution326().isPowerOfThree2(243));
	}

}
