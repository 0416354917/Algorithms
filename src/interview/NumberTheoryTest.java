package interview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class NumberTheoryTest {

	@Test
	public void testGcd() {
		assertEquals(4, NumberTheory.gcd(8, 12));
	}

	@Test
	public void testLcd() {
		assertEquals(24, NumberTheory.lcd(8, 12));
	}

	@Test
	public void arrayGcd() {
		fail("Not implemneted!");
	}

	@Test
	public void arrayLcd() {
		fail("Not implemneted!");
	}

}
