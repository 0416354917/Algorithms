package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Common algorithms in <b>Number Theory</b>.
 * 
 * <p>
 * TODO: Mathematical proof of all formulas.
 * </p>
 * 
 * @author Jun Chen (tlnd.sky@gmail.com)
 *
 */
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
	public static int lcm(int m, int n) {
		return m * n / gcd(m, n);
	}

	/**
	 * Greatest Common Divisor of an array of non-negative integers.
	 * 
	 * @param nums
	 * @return
	 */
	public static int arrayGcd(int[] nums) {
		if (nums == null || nums.length == 0) {
			System.out.println("Empty array! Program exits.");
			System.exit(0);
		}

		if (nums.length == 1)
			return nums[0];

		int arrayGcd = gcd(nums[0], nums[1]);
		for (int index = 2; index < nums.length; index++)
			arrayGcd = gcd(arrayGcd, nums[index]);

		return arrayGcd;
	}

	/**
	 * Least Common Multiple of an array of non-negative integers.
	 * 
	 * @param nums
	 * @return
	 */
	public static int arrayLcm(int[] nums) {
		if (nums == null || nums.length == 0) {
			System.out.println("Empty array! Program exits.");
			System.exit(0);
		}

		if (nums.length == 1)
			return nums[0];

		int arrayLcm = lcm(nums[0], nums[1]);
		for (int index = 2; index < nums.length; index++)
			arrayLcm = lcm(arrayLcm, nums[index]);

		return arrayLcm;
	}

	/**
	 * Prime Test.
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		} else if (n <= 3) {
			return true;
		} else {
			for (int i = 2; i <= (int) Math.sqrt(n); i++) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * Sieve of Eratosthenes.
	 * 
	 * <p>
	 * Finding all prime numbers up to any given limit.
	 * </p>
	 * 
	 * <a>https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes</a>
	 * 
	 * @return
	 */
	public static int[] sieveOfEratosthenes(int n) {
		List<Integer> primes = new ArrayList<Integer>();

		List<Integer> candidates = new ArrayList<Integer>();
		List<Integer> marks = new ArrayList<Integer>();
		for (int i = 2; i <= n; i++) {
			candidates.add(i);
			marks.add(1);
		}

		int index = -1;
		while (index < candidates.size()) {
			// get:
			int i = index + 1;
			for (; i < candidates.size(); i++) {
				if (marks.get(i) == 1) {
					primes.add(candidates.get(i));
					break;
				}
			}

			// update:
			index = i;
			if (index == candidates.size())
				break;

			// mark:
			int gap = candidates.get(index);
			int target = index + gap;
			while (target < candidates.size()) {
				marks.set(target, 0);
				target += gap;
			}
		}

		int[] result = new int[primes.size()];
		for (int i = 0; i < result.length; i++)
			result[i] = primes.get(i);

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 4, 6, 8 };
		System.out.println(NumberTheory.arrayGcd(nums));
		System.out.println(NumberTheory.arrayLcm(nums));
		for (int i = 1; i <= 10; i++) {
			System.out.println(isPrime(i));
		}
	}

}
