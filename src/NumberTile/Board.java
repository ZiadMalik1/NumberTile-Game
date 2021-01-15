/*
Ziad Malik
Section U01
Board.java
I affirm that this program is entirely my own work 
and none of it is the work of any other person.
 */
package NumberTile;

/**
 * The Board Class is the class that has everything to do with the Board itself
 * This includes Printing the board as a string and also getting Characteristics
 * of the Board such as its size or a tile at a given index of the board.
 */

// The board for the NumberTile game  
public class Board {

    private NumberTile[] board;   // the board for the game
    private int boardSize;         // current number of tiles on the board
    private static final int MAX_BOARD = 100;  // maximum number of tiles

    /**
     * Creates a new Board containing a single NumberTile
     */
    // Creates a new Board that can hold up to MAX_BOARD tiles
    // that contains a single NumberTile
    public Board() {

        boardSize = 0;
        board = new NumberTile[MAX_BOARD];
        board[0] = new NumberTile();
        boardSize++;

    }

    /**
     * This Method Returns the NumberTile at the specified index on this Board
     *
     * @param index The Specified Index for which the Caller of the Method
     * Requires the contents of that Specific Index.
     * @return Returns the Tile at the Specific Index of the Board.
     */
    // Return the NumberTile at the specified index on this Board
    public NumberTile getTile(int index) {

        return board[index];
    }

    /**
     * This Method Returns the current number of tiles on this Board
     *
     * @return Returns the Size of the Board in the form of an Integer which
     * is given by the BoardSize Counter that we created to keep track of the 
     * Size. We do this by Incrementing and Decrementing the Integer when Tiles
     * Are added or removed from the Board.
     */
    // Return the current number of tiles on this Board
    public int getSize() {

        return boardSize;
    }

    /**
     * Insert a new tile into this Board at the specified index
     *
     * @param index This Parameter is used to specify at which index or spot the
     * Parameter tile is to be added
     * @param tile The specific Tile that is eligible to fit within the specific
     * Index of the board given by the parameter index
     * In order to add a tile at a specific index within the Board we have to
     * first move all elements from the end of the board to the index up one 
     * element in order to make room for the tile that is to be added at the
     * Specified index.
     * We also Increment the boardSize counter after we have Successfully added
     * the Tile onto the Board.
     */
    // Insert a new tile into this Board at the specified index
    public void addTile(int index, NumberTile tile) {

        for (int i = boardSize; i > index; i--) {

            board[i] = board[i - 1];

        }

        board[index] = tile;
        boardSize++;

    }

    /**
     * 
     * @return Return a multi-line string containing all the tiles on this Board
     * This Method Gets all elements of the Board and presents them as Output
     * In the Form of Strings Containing each and every single Tile within the
     * Board.
     */
    // Return a multiline string containing all the tiles on this Board
    public String toString() {

        String Board = "The Board \n--------------------------\n\n";
        /*
        String Board is a holder and Initializer for the String that will be
        Returned to the Method Caller.
         */
        for (int i = 0; i < boardSize; i++) {

            Board = Board + board[i].toString() + "\n";

        }

        return Board;
    }
}
