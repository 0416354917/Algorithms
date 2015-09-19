package comp1110.ass2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by steveb on 30/07/2015.
 */
public class HexGame {

    /**
     * Construct HexGame from a string describing game state.
     *
     * @param game The initial state of the game, described as a string according to the assignment specification.
     */
    public HexGame(String game) {
        /* FIXME */
    }

    /**
     * Construct HexGame with a random game state that complies with the assignment specification.
     */
    public HexGame() {
        /* FIXME */
    }

    /**
     * Determine whether a set of crannies are legal according to the assignment specification.
     *
     * @param crannies A string describing the crannies, encoded according to the assignment specification.
     * @return True if the crannies are correctly encoded and in legal positions, according to the assignment specification.
     */
    public static boolean legitimateCrannies(String crannies) {
        /* FIXME */
        return HexCrannies.CranniesJudge(crannies);

    }




    /**
     * Determine whether a set of nooks are legal according to the assignment specification.
     *
     * @param nooks A string describing the nooks, encoded according to the assignment specification.
     * @return True if the nooks are correctly encoded and in legal positions, according to the assignment specification.
     */
    public static boolean legitimateNooks(String nooks) {
        /* FIXME */

        return HexNooks.NooksJudge(nooks);
    }




    /**
     * Determine whether a game state is legal according to the assignment specification.
     * @param game A string describing the game state, encoded according to the assignment specification.
     * @return True if the game state is correctly encoded and represents a legal game state, according to the assignment specification.
     */
    public static boolean legitimateGame(String game) {
        /* FIXME */
        return false;
    }

    /**
     * Determine whether a given step is legal according to a given game state and the assignment specification.
     * @param game A string describing the game state, encoded according to the assignment specification.
     * @param from The point from which the step starts
     * @param to The point to which step goes
     * @return True if the move is legal according to the assignment specification.
     */
    public static boolean legitimateStep(String game, int from, int to) {
        /* FIXME */
        return false;
    }

    /**
     * Return a minimal path from start to goal.
     * @param game A string describing the game state, encoded according to the assignment specification.
     * @param start The point from which the path must start
     * @param goal The point at which the path must end
     * @return An array of integers reflecting a minimal path from start to goal, each integer reflecting a node on the board, starting with the start, and ending with the goal.
     */
    public static int[] minimalPath(String game, int start, int goal) {
        /* FIXME */
        return null;
    }

    /**
     * Output the state of the game as a string, encoded according to the assignment specification
     * @return A string that reflects the game state, encoded according to the assignment specification.
     */
    public String toString() {
        /* FIXME */
        return null;
    }

}
