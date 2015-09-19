package comp1110.ass2;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by steveb on 6/08/2015.
 */
public class LegitimateGameTest {
    private static String[] games = {
            "171178187194205215" + "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D" + "093", // ok
            "171178187194205215" + "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D" + "038", // ok
            "171178187194205215" + "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D" + "064", // ok
            "171178187194205215" + "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D" + "070", // ok
            "171178187194205215" + "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D" + "092", // 92 not nook
            "171178187194205215" + "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D" + "171", // 171 not nook
            "171178187194205215" + "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D" + "000", // 0 not nook
            "173183187197205214" + "093D064D038A100A024B070F075F026B105A052F110D114B033C085F054E089C018E058E" + "093", // not fully connected

            "171178187194205215" + "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D" + "093038064070", // ok
            "171178187194205215" + "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D" + "093093064070", // duplicate 93
    };

    @Test
    public void testOKSingle() {
        for (int i = 0; i < 4; i++)
            assertTrue("Incorrectly rejected correct game: " + games[i], HexGame.legitimateGame(games[i]));
    }

    @Test
    public void testNonNookStarts() {
        for (int i = 4; i < 7; i++)
            assertFalse("Incorrectly accepted game with piece at bad position: " + games[i], HexGame.legitimateGame(games[i]));
    }

    @Test
    public void testNonConnectedNooks() {
        assertFalse("Incorrectly accepted game with nodes that are not fully connected: " + games[7], HexGame.legitimateGame(games[7]));
    }

    @Test
    public void testOKMultiple() {
        assertTrue("Incorrectly rejected correct multi-piece game: " + games[8], HexGame.legitimateGame(games[8]));
    }

    @Test
    public void testDuplicatePieces() {
        assertFalse("Incorrectly accepted game with multiple pieces at a nook: " + games[9], HexGame.legitimateGame(games[9]));
    }
}
