package comp1110.ass2;

import comp1110.ass2.HexGame;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by steveb on 6/08/2015.
 */
public class LegitimateNookTest {
    private static String[] nooks = {
            "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D",  // ok
            "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B",      // too few
            "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D125C", // too many
            "393D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D",  // 393
            "093K038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D",  // 93K bad orientation
            "049D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D",  // 49 invalid position, inner
            "202D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D",  // 202 invalid, outer
            "093D094D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D",  // 93, 94 adjacent
            "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B096D"   // too many from one tri
    };

    @Test
    public void testOK() {
        assertTrue("Incorrectly rejected correct nooks: " + nooks[0], HexGame.legitimateNooks(nooks[0]));
    }

    @Test
    public void testTooLong() {
        assertFalse("Incorrectly accepted too many nooks: " + nooks[1], HexGame.legitimateNooks(nooks[1]));
    }


    @Test
    public void testTooShort() {
        assertFalse("Incorrectly accepted too few nooks: " + nooks[2], HexGame.legitimateNooks(nooks[2]));
    }

    @Test
    public void testBadNook() {
        assertFalse("Incorrectly accepted bad nook (393): " + nooks[3], HexGame.legitimateNooks(nooks[3]));
    }

    @Test
    public void testBadOrientation() {
        assertFalse("Incorrectly accepted bad nook orientation (93K): " + nooks[4], HexGame.legitimateNooks(nooks[4]));
    }

    @Test
    public void testIllegalLocationInner() {
        assertFalse("Incorrectly accepted bad nook location, inner (49): " + nooks[5], HexGame.legitimateNooks(nooks[5]));
    }

    @Test
    public void testIllegalLocationOuter() {
        assertFalse("Incorrectly accepted bad nook location, outer (202): " + nooks[6], HexGame.legitimateNooks(nooks[6]));
    }

    @Test
    public void testIllegalAdjacent() {
        assertFalse("Incorrectly accepted adjacent nooks (93, 94): " + nooks[7], HexGame.legitimateNooks(nooks[7]));
    }

    @Test
    public void testIllegalTooMany() {
        assertFalse("Incorrectly accepted too many nooks from one triangle: " + nooks[8], HexGame.legitimateNooks(nooks[8]));
    }
}
