package leetcode;

/**
 * Power of Four.
 * 
 * Status: Accepted.
 * 
 * Note: A number is a power of two, it must also be a power of 2.
 * 
 * @author Jason
 *
 */
public class Solution342 {

	public boolean isPowerOfFour(int num) {
//		System.out.println("=====");
//		System.out.println("Math.round(Math.log(num) / Math.log(2)) = " + Math.round(Math.log(num) / Math.log(2)));
//		System.out.println("Math.log(base=2, num) = " + Math.log(num) / Math.log(2));
		return num > 0 && (int) Math.pow(4, (int)(Math.log(Integer.MAX_VALUE) / Math.log(4))) % num == 0
				&& Math.round(Math.log(num) / Math.log(2)) % 2 == 0; 
	}

	public static void main(String[] args) {
		for(int num = 0; num < 100; num++) {
			System.out.println("num = " + num + ", solution = " + new Solution342().isPowerOfFour(num));
		}
	}

}
