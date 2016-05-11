package leetcode;

/**
 * Status: Accepted.
 * 
 * @author Jason
 *
 */
public class Solution343 {

	public int integerBreak(int n) {
		int product = 1;

		if (n == 2)
			return 1;
		else if (n == 3)
			return 2;
		else {
			int reminder = n;
			while (reminder > 4) {
				product *= 3;
				reminder -= 3;
			}
			product *= reminder;
		}

		return product;
	}

	public static void main(String[] args) {
		for (int n = 2; n <= 10; n++) {
			System.out.println("n = " + n + ", solution = "
					+ new Solution343().integerBreak(n));
		}
	}

}
