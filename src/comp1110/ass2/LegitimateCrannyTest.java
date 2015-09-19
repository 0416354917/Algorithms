package comp1110.ass2;

import comp1110.ass2.HexGame;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by steveb on 6/08/2015.
 */
public class    LegitimateCrannyTest {
    private static String[] crannies = {
            "171178187194205215", // ok
            "171171187194205215205", // too long
            "171171187194205", // too short
            "171171187194205215", // 171 repeated
            "132178187194205215", // 132 wrong ring
            "171178187194205171", // too many from tri 1
    };

    @Test
    public void testOK() {
        assertTrue("Incorrectly rejected correct crannies: " + crannies[0], HexGame.legitimateCrannies(crannies[0]));
    }

    @Test
    public void testTooLong() {
        assertFalse("Incorrectly accepted too many crannies: " + crannies[1], HexGame.legitimateCrannies(crannies[1]));
    }

    @Test
    public void testTooShort() {
        assertFalse("Incorrectly accepted too few crannies: " + crannies[2], HexGame.legitimateCrannies(crannies[2]));
    }

    @Test
    public void testRepeat() {
        assertFalse("Incorrectly accepted repeated baffle: " + crannies[3], HexGame.legitimateCrannies(crannies[3]));
    }

    @Test
    public void testWrongRing() {
        assertFalse("Incorrectly accepted baffle in wrong ring: " + crannies[4], HexGame.legitimateCrannies(crannies[4]));
    }

    @Test
    public void testTooMany() {
        assertFalse("Incorrectly accepted too many crannies in one triangle: " + crannies[5], HexGame.legitimateCrannies(crannies[5]));
    }

}
