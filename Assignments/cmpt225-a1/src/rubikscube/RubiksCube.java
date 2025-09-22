package rubikscube;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RubiksCube {

    private char[][] cube_state;

    /**
     * default constructor
     * Creates a Rubik's Cube in an initial state:
     * OOO
     * OOO
     * OOO
     * GGGWWWBBBYYY
     * GGGWWWBBBYYY
     * GGGWWWBBBYYY
     * RRR
     * RRR
     * RRR
     */
    public RubiksCube() {
        this.cube_state = new char[9][12];

        // Fill Rows 0-2 and 6-8: positions 0-2 should be spaces
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                cube_state[row][col] = ' ';
            }
        }

        for (int row = 6; row < 9; row++) {
            for (int col = 0; col < 3; col++) {
                cube_state[row][col] = ' ';
            }
        }

        // Fill Face - Up (Orange)
        for (int row = 0; row < 3; row++) {
            for (int col = 3; col < 6; col++) {
                cube_state[row][col] = 'O';
            }
        }

        // Fill Face - Left (Green)
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < 3; col++) {
                cube_state[row][col] = 'G';
            }
        }

        // Fill Face - Front (White)
        for (int row = 3; row < 6; row++) {
            for (int col = 3; col < 6; col++) {
                cube_state[row][col] = 'W';
            }
        }

        // Fill Face - Right (Blue)
        for (int row = 3; row < 6; row++) {
            for (int col = 6; col < 9; col++) {
                cube_state[row][col] = 'B';
            }
        }

        // Fill Face - Back (Yellow)
        for (int row = 3; row < 6; row++) {
            for (int col = 9; col < 12; col++) {
                cube_state[row][col] = 'Y';
            }
        }

        // Fill Face - Down (Red)
        for (int row = 6; row < 9; row++) {
            for (int col = 3; col < 6; col++) {
                cube_state[row][col] = 'R';
            }
        }
    }

    /**
     * @param fileName
     * @throws IOException
     * @throws IncorrectFormatException Creates a Rubik's Cube from the description in fileName
     */
    public RubiksCube(String fileName) throws IOException, IncorrectFormatException {
        this.cube_state = new char[9][12];

        // Read file 'fileName'
        BufferedReader input = new BufferedReader(new FileReader(fileName));

        // Read each line in the file
        String line;
        for(int i = 0; i < cube_state.length; i++){
            line = input.readLine();

            // Ensure we are reading only and all 9 rows
            if(line == null){
                throw new IncorrectFormatException("Incorrect format, Filename: " + fileName);
            }

            // Each row has a maximum of 12 chars
            if(line.length() > cube_state[i].length){
                throw new IncorrectFormatException("Incorrect format, Filename: " + fileName);
            }

            // Store our read data onto our cube
            for(int j = 0; j < line.length(); j++){
                cube_state[i][j] = line.charAt(j);
            }
        }
        input.close();
    }

    /**
     * @param moves Applies the sequence of moves on the Rubik's Cube
     */
    public void applyMoves(String moves) {
        switch (moves){
            case "F":
                moveFront();
                break;
            case "B":
                moveBack();
                break;
            case "R":
                moveRight();
                break;
            case "L":
                moveLeft();
                break;
            case "U":
                moveUp();
                break;
            case  "D":
                moveDown();
                break;
        }
    }

    public void moveFront(){
        char[] temp = new char[3];

        // Save Up bottom row
        for (int i = 0; i < 3; i++) {
            temp[i] = cube_state[2][3 + i];
        }

        // Up <- Left (reversed)
        for (int i = 0; i < 3; i++) {
            cube_state[2][3 + i] = cube_state[5 - i][2];
        }

        // Left <- Down
        for (int i = 0; i < 3; i++) {
            cube_state[3 + i][2] = cube_state[6][3 + i];
        }

        // Down <- Right (reversed)
        for (int i = 0; i < 3; i++) {
            cube_state[6][3 + i] = cube_state[5 - i][6];
        }

        // Right <- temp (original Up)
        for (int i = 0; i < 3; i++) {
            cube_state[3 + i][6] = temp[i];
        }
    }

    public void moveBack(){}
    public void moveRight(){}
    public void moveLeft(){}
    public void moveUp(){}
    public void moveDown(){}

    /**
     * returns true if the current state of the Cube is solved,
     * i.e., it is in this state:
     * OOO
     * OOO
     * OOO
     * GGGWWWBBBYYY
     * GGGWWWBBBYYY
     * GGGWWWBBBYYY
     * RRR
     * RRR
     * RRR
     */
    public boolean isSolved() {
        // TODO implement me
        return false;
    }

    @Override
    public String toString() {
        // TODO implement me
        StringBuilder sb = new StringBuilder();

        // Must turn our 2D array into a String
        for(int i = 0; i < cube_state.length; i++){
            if(i < 3 || i > 5) {
                // Rows 0-2 and 6-8: Output only 6 chars including spaces
                for (int j = 0; j < 6; j++) {
                    sb.append(cube_state[i][j]);
                }
            }

            else{
                // Rows 3-5: Outrputs all 12 chars
                for(int j = 0; j < 12; j++){
                    sb.append(cube_state[i][j]);
                }
            }
            sb.append('\n');
        }

        // Method returns String, not StringBuilder obj.
        return sb.toString();
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

