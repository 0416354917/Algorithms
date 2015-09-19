package comp1110.ass2;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by steveb on 6/08/2015.
 */
public class MinimalPathTest {

    static int[][] paths = {
            {122, 125, 1, 1},
            {112, 196, 72, 2, 1},
            {60, 212, 122, 125, 3, 1},
            {16, 125, 122, 212, 60, 4, 1},
            {122, 210, 200, 201, 205, 82, 5, 1},
            {60, 212, 209, 206, 118, 19, 100, 6, 1},
            {125, 16, 54, 74, 191, 188, 106, 108, 7, 1},
            {106, 188, 71, 185, 187, 101, 183, 105, 72, 106, 108, 192, 202, 201, 195, 78, 76, 72, 8, 2},
    };

    private static final String CRANNIES = "171178187194205215";
    private static final String NOOKS = "093D038D064E070C100D043D106A108F072A080A051D112F082B016C118D060D125B122D";


    @Test
    public void testMinimalPaths() {
        for (int i = 0; i < 8; i++) {
            String result = minimal(i);
            assertTrue(result, result == null);
        }
    }

    /**
     * Determine whether the game can find a minimal path.
     *
     * @param i The index into an array of paths, indicating which to test
     * @return A string describing the error, or null if there was no error
     */
    private String minimal(int i) {
        /* establish which path is being tested, pull out key information */
        int[] test = paths[i];
        int num = test[test.length-1];
        int len = test[test.length-2];
        int goal = test[test.length-3];
        String piece = String.format("%03d",test[0]);
        String game = CRANNIES+NOOKS+piece;
        int[] result = HexGame.minimalPath(game, test[0], goal);
        String reason = null;
        if (result[0] != test[0]) {
            reason = "Wrong start value :"+result[0];
        } else {
            /* check whether the supplied answer matches one of possible minimal paths */
            String answer = "";
            for (int j = 0; j < num; j++) {
                if (j > 0) { answer += ", or "; }
                boolean bad = false;
                for (int k = 0; k < len; k++) {
                    if (result[k] != test[(j*(len+1))+k])
                        bad = true;
                    answer += String.format("%03d", test[(j*(len+1))+k]);
                }
                if (!bad) return null; // correct, so no error message
            }
            String theirs = "";
            for (int j = 0; j < result.length; j++) {
                theirs += String.format("%03d", result[j]);
            }

            if (result.length != len+1) {
                reason = "Path between " + test[0] + " and " + goal + " returned (" + theirs + ") is not minimal (" + answer + ")";
            } else {
                reason = "Path between " + test[0] + " and " + goal + " returned " + theirs + ") is not correct (" + answer + ")";
            }
        }
        return reason;
    }

}
