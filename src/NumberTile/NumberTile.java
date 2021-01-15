/*
Ziad Malik
Section U01
NumberTile.java
I affirm that this program is entirely my own work 
and none of it is the work of any other person.
 */
package NumberTile;

import java.util.Random;

/**
 * The NumberTile Class is for the Number Tiles within the Game Specifically.
 * This class is the means to how the rest of Java Application Obtains and
 * Manipulates the Number-tiles within the Game. The Number-tile Class is also
 * Responsible for Constructing the Number-tiles within the class.
 */
// A NumberTile is a square tile with a number from 1 to 9 on each side
/**
 * Create a NumberTile object with 4 random integers in the range 1 to 9
 */
public class NumberTile {

    private int[] tile;    // the 4-sided tile

    // Create a NumberTile object with 4 random ints in the range 1 to 9
    public NumberTile() {
        Random gen = new Random();  // DO NOT ERASE THIS DECLARATION
        tile = new int[4];
        for (int i = 0; i < 4; i++) {

            tile[i] = (gen.nextInt(9) + 1);

        }
    }

    /**
     * Rotates the Specific NumberTile 90 degrees Counter-Clockwise.
     */
    // Rotate this NumberTile 90 degrees
    public void rotate() {

        int holder = tile[0];
        /*
        Integer Holder is a holder for the First Element of the Array that will
        be added to the end in order to complete the Rotation and Prevent the 
        Loss of the Element itself because of how the Rotation is Done.
         */
        for (int i = 0; i < tile.length - 1; i++) {
            tile[i] = tile[i + 1];
        }
        tile[3] = holder;
    }

    /**
     * Return the number on the left side of this NumberTile
     *
     * @return This Returns the Number that is on the Left side of the Specific
     * Number-tile
     */
    // Return the number on the left side of this NumberTile
    public int getLeft() {

        return tile[0];
    }

    /**
     * Return the number on the right side of this NumberTile
     *
     * @return This Returns the Number that is on the Right side of the Specific
     * Number-tile
     */
    // Return the number on the right side of this NumberTile
    public int getRight() {

        return tile[2];
    }

    /**
     * Return this NumberTile as a multi-line string in the form: 9 3 7 6
     *
     * @return Returns the String that now has created the Number-tile in the
     * form of a String as seen above.
     */
    // Return this NumberTile as a multiline string in the form:
    //     9
    //  3     7
    //     6
    //
    public String toString() {

        String Tile = "   " + tile[1] + "\n" + tile[0] + "     " + tile[2]
                + "\n   " + tile[3];
        /*
        String Tile is a holder for the String that will be Returned to the 
        Method Caller. It is also the String that presents all Tiles within the
        Game as a 4-sided Tile when printed.
         */
        return Tile;
    }
} // end of NumberTile class
