package leetcode;

/**
 * Power of Two. 
 * 
 * Status: Accepted.
 * 
 * @author Jason
 *
 */
public class Solution231 {

	public boolean isPowerOfTwo(int n) {
		if (n > 0 && (n & (n - 1)) == 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		for (int n = 0; n <= 10; n++) {
			System.out.println("n = " + n + ", solution = "
					+ new Solution231().isPowerOfTwo(n));
		}
	}

}
