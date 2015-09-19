package comp1110.ass2;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by steveb on 6/08/2015.
 */
public class LegitimateStepTest {
    private static String[] games = {
            "171178187194205215" + "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D" + "093", // ok
    };

    private static int[][] steps = {
            { 93, 215 }, // OK
            { 93, 171 }, // OK
            { 93, 173 }, // OK
            { 93, 169 }, // two steps
            { 93, 92  }, // no barrier, can't stop
            { 93, 63  }, // barrier in the way
            { 175, 64 }, // piece not at 175
    };


    @Test
    public void testOK() {
        for (int i = 0; i < 3; i++) {
            assertTrue("Incorrect    ly rejected correct step: " + steps[i][0] + " to " + steps[i][1] + " for game " + games[0], HexGame.legitimateStep(games[0], steps[i][0], steps[i][1]));
}
}

    @Test
    public void testTwoSteps() {
        for (int i = 3; i < 4; i++) {
            assertFalse("Incorrectly accepted step that required two steps: " + steps[i][0] + " to " + steps[i][1] + " for game " + games[0], HexGame.legitimateStep(games[0], steps[i][0], steps[i][1]));
        }
    }

    @Test
    public void testNoBarrier() {
        for (int i = 4; i < 5; i++) {
            assertFalse("Incorrectly accepted move that stopped before barrier: " + steps[i][0] + " to " + steps[i][1] + " for game " + games[0], HexGame.legitimateStep(games[0], steps[i][0], steps[i][1]));
        }
    }

    @Test
    public void testBarrier() {
        for (int i = 5; i < 6; i++) {
            assertFalse("Incorrectly accepted move that stopped jumped barrier: " + steps[i][0] + " to " + steps[i][1] + " for game " + games[0], HexGame.legitimateStep(games[0], steps[i][0], steps[i][1]));
        }
    }

    @Test
    public void testNoPiece() {
        for (int i = 6; i < 7; i++) {
            assertFalse("Incorrectly accepted move with no piece at start: " + steps[i][0] + " to " + steps[i][1] + " for game " + games[0], HexGame.legitimateStep(games[0], steps[i][0], steps[i][1]));
        }
    }

}
