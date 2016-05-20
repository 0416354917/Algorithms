package leetcode;

/**
 * Super Ugly Number.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution313 {

	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] ugly = new int[n + 1];
		int[] index = new int[primes.length];

		ugly[0] = 0;
		ugly[1] = 1;
		for (int i = 0; i < index.length; i++)
			index[i] = 1;

		int k = 2;
		while (k <= n) {
			int next = Integer.MAX_VALUE;
			for (int i = 0; i < index.length; i++) {
				next = Math.min(next, primes[i] * ugly[index[i]]);
			}

			for (int i = 0; i < index.length; i++) {
				if (primes[i] * ugly[index[i]] <= next) {
					index[i]++;
				}
			}

			ugly[k] = next;

			k++;
		}

		return ugly[n];
	}

	public static void main(String[] args) {
		Solution313 solution = new Solution313();

		int[] primes = { 2, 7, 13, 19 };
		for (int n = 1; n <= 12; n++) {
			System.out.println(solution.nthSuperUglyNumber(n, primes));
		}
	}

}
