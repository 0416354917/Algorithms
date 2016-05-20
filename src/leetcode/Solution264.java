package leetcode;

/**
 * Ugly Number II.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * {@link https://leetcode.com/discuss/96207/share-my-4ms-cpp-solution-beats-98-9%25-submissions}
 * 
 * @author Jason
 *
 */
public class Solution264 {

	public int nthUglyNumber(int n) {
		int[] ugly = new int[n + 1];

		ugly[0] = 0;
		ugly[1] = 1;

		int m1 = 1, m2 = 1, m3 = 1;
		int k = 2;
		while (k <= n) {
			int nextUgly = Math.min(2 * ugly[m1],
					Math.min(3 * ugly[m2], 5 * ugly[m3]));

			if (nextUgly == 2 * ugly[m1])
				m1++;
			if (nextUgly == 3 * ugly[m2])
				m2++;
			if (nextUgly == 5 * ugly[m3])
				m3++;

			ugly[k] = nextUgly;
			k++;
		}

		return ugly[n];
	}

	public static void main(String[] args) {
		Solution264 solution = new Solution264();

		for (int i = 1; i <= 10; i++)
			System.out.println(solution.nthUglyNumber(i));
	}

}
