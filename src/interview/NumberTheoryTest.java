package interview;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NumberTheoryTest {

	int[] nums = { 2, 4, 6, 8 };

	@Test
	public void testGcd() {
		assertEquals(4, NumberTheory.gcd(8, 12));
	}

	@Test
	public void testLcd() {
		assertEquals(24, NumberTheory.lcm(8, 12));
	}

	@Test
	public void testArrayGcd() {

		assertEquals(2, NumberTheory.arrayGcd(nums));
	}

	@Test
	public void testArrayLcm() {
		assertEquals(24, NumberTheory.arrayLcm(nums));
	}

	@Test
	public void testIsPrime() {
		int[] primes = { 2, 3, 5, 7 };
		int[] nonPrimes = { 1, 4, 6, 8, 9, 10 };
		for (int p : primes) {
			assertTrue(NumberTheory.isPrime(p));
		}
		for (int np : nonPrimes) {
			assertFalse(NumberTheory.isPrime(np));
		}

		// combination with sieveOfEratosthenes():
		for (int x : NumberTheory.sieveOfEratosthenes(10000)) {
			assertTrue(NumberTheory.isPrime(x));
		}
	}

	@Test
	public void testSieveOfEratosthenes() {
		int n = 10;
		int[] expected = { 2, 3, 5, 7 };
		assertArrayEquals(expected, NumberTheory.sieveOfEratosthenes(n));
	}

}
