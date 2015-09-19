package comp1110.ass2;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by steveb on 6/08/2015.
 */
public class ToStringTest {

    private static String[] games = {
            "171178187194205215" + "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D" + "093", // ok
            "171178187194205215" + "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D" + "038", // ok
            "171178187194205215" + "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D" + "064", // ok
            "171178187194205215" + "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D" + "070", // ok
            "171178187194205215" + "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D" + "093038064070", // ok
    };


    @Test
    public void testToString() {
        for (int i = 0; i < 5; i++) {
            HexGame game = new HexGame(games[i]);
            String result = game.toString();
            assertTrue("Bad string returned for game state: "+games[i]+", got: "+result, result.equals(games[i]));
        }
    }
}
