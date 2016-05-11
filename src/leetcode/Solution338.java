package leetcode;

/**
 * Counting Bits.
 * 
 * Status: Accepted.
 * 
 * @author Jason
 *
 */
public class Solution338 {

	public int[] countBits(int num) {
		int[] result = new int[num + 1];

		result[0] = 0;
		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0) {
				result[i] = result[i / 2];
			} else {
				result[i] = result[i - 1] + 1;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		for (int num = 0; num <= 10; num++) {
			int[] result = new Solution338().countBits(num);
			System.out.println("num = " + num + ", solution = "
					+ result.toString());
		}
	}

}
