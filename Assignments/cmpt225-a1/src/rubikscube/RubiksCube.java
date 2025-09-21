package rubikscube;

import java.io.IOException;

public class RubiksCube {
    /**
     * default constructor
     * Creates a Rubik's Cube in an initial state:
     *    OOO
     *    OOO
     *    OOO
     * GGGWWWBBBYYY
     * GGGWWWBBBYYY
     * GGGWWWBBBYYY
     *    RRR
     *    RRR
     *    RRR
     */
    public RubiksCube() {
        // TODO implement me
    }

    /**
     * @param fileName
     * @throws IOException
     * @throws IncorrectFormatException
     * Creates a Rubik's Cube from the description in fileName
     */
    public RubiksCube(String fileName) throws IOException, IncorrectFormatException {
        // TODO implement me
    }

    /**
     * @param moves
     * Applies the sequence of moves on the Rubik's Cube
     */
    public void applyMoves(String moves) {
        // TODO implement me
    }

    /**
     * returns true if the current state of the Cube is solved,
     * i.e., it is in this state:
     *    OOO
     *    OOO
     *    OOO
     * GGGWWWBBBYYY
     * GGGWWWBBBYYY
     * GGGWWWBBBYYY
     *    RRR
     *    RRR
     *    RRR
     */
    public boolean isSolved() {
        // TODO implement me
        return false;
    }

    @Override
    public String toString() {
        // TODO implement me
        return super.toString();
    }

    /**
     *
     * @param moves
     * @return the order of the sequence of moves
     */
    public static int order(String moves) {
        // TODO implement me
        return -1;
    }
}
