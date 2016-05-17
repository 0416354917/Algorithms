package leetcode;

/**
 * Factorial Trailing Zeroes.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * <p>
 * {@link https://en.wikipedia.org/wiki/Trailing_zero}
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution172 {

	public int trailingZeroes(int n) {
		if (n < 5)
			return 0;

		int ans = 0;
		int q = n / 5;
		while (q != 0) {
			ans += q;
			q /= 5;
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution172 solution = new Solution172();

		int n = 32;
		System.out.println(solution.trailingZeroes(n));
	}

}
