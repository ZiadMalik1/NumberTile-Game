/*
Ziad Malik
Section U01
TileGame.java
I affirm that this program is entirely my own work 
and none of it is the work of any other person.
 */
package NumberTile;

/**
 * The Tile Game Class is the Class where the build of the Game itself is
 * Created. The Methods within the class decide how the game is played and also
 * decides when and how the game comes to a finish and who is the winner.
 */
// Implements a domino-like game where two players, both of whom are
// the computer, take turns inserting NumberTiles into a Board
public class TileGame {
    // instance vars

    private Board board;     // the game board
    private Hand hand1;      // Player 1 hand
    private Hand hand2;      // Player 2 hand
    private String winner;   // the winner - player1, player2, or a tie game

    /**
     * This is the Constructor of the TileGame Class where it creates a new game
     * with a new board and new winner String which is set when the results are
     * given to the game with the below Parameters.
     *
     * @param firstHand This is Player 1's Hand
     * @param secondHand This is Player 2's Hand
     */
    // Creates a new TileGame with two initial hands and a board
    public TileGame(Hand firstHand, Hand secondHand) {

        board = new Board();
        hand1 = firstHand;
        hand2 = secondHand;

    }

    /**
     * The Play Method is Used to keep the game going up until the point that
     * one of the hands within the game is empty. Once one of the hands is empty
     * this method calls the getResults Method to assign a winner and rReturn
     * the Final Board and Winner String of the Game.
     */
    /* 
    Play Method Initially Prints out the Starting Board. Then, 
    Players take turn moving until one or both hand are empty. When this
    is the case, the getResults(); Method is called and the Results are returned
    to the Tester Class to give as Output to the User.
     */
    public void play() {
        System.out.println("The Initial Board: \n" + board.toString());
        while (!hand1.isEmpty() && !hand2.isEmpty()) {

            makeMove(hand1);
            makeMove(hand2);

        }
        getResults();
    }

    // Utility method called by method makeMove.  Returns the index at which a
    // new tile will be inserted into the board, or -1 if the tile cannot
    // be inserted.  The new tile may be inserted either (1) between two 
    // existing tiles, (2) as the new first tile, or (3) as the new last tile
    private int getIndexForFit(NumberTile tile) {

        /*
        
        The getIndexForFit() Method is used within the Makemove() Method to 
        Determine the Index for where a matching tile from the Player's Hand 
        can be added onto the Board. First The Method checks to see if the 
        Right side of the Hand's Tile matches the Left side of the Very First
        Tile. If so, The Hand's Tile is added to the Very Beginning. 
         */
        if (tile.getRight() == board.getTile(0).getLeft()) {

            return 0;

        } /*
        If this 
        is not the case, the Method moves onto the Next Condition. If the Left 
        Side of the Hand's Tile Matches the Right of the Very Last tile, then
        it is added to the end of the Board Array. I am checking to see if the
        Tile can be added to the Beginning and End because those are the only 
        two Spots on the Board where Both sides of the Tile do not have to match
        another number. 
        
         */ else if (tile.getLeft()
                == board.getTile(board.getSize() - 1).getRight()) {

            return board.getSize();

        } /*
        If this is also not the case for the Tile at hand within
        the method, we move onto the last condition. If AND ONLY IF Both sides 
        of the Hand's Tile match one another, it is possible for the tile to be
        added somewhere in between two pre-existing Board tiles. Why? Because of
        the fact that if two tiles are already on the board, they have matching
        Right and Left Sides Respectively. If a Tile is to be added in between
        BoardTile(i) which shares a Right Side with BoardTile(i + 1)'s Left 
        Side, It has to have Whatever number the BoardTile's (i) and (i+1) share 
        in common as both its Left and Right Side. For Example:
        
    Board Before Adding of Tile           Board After Adding Of Tile 
                                   With Matching 7's on Both Left and Right:
           9          5                        9        5        5
        3     7    7     2                  3     7  7     7  7     2
           6          2                        6        3        2
         */ else if (tile.getLeft() == tile.getRight()) {

            for (int i = 0; i < board.getSize() - 1; i++) {

                if (tile.getLeft() == board.getTile(i).getRight()
                        && tile.getRight() == board.getTile(i + 1).getLeft()) {

                    return i + 1;

                }

            }

        }

        return -1;
    }

    // Utility method called by method play().  Checks consecutive tiles in the 
    // hand - by calling method getIndexForFit() - to see if one can be inserted 
    // into the board. When the first tile that fits is found, removes it from
    // the hand, inserts it into the board, and the move ends.  The tile may be
    // rotated up to 3 times. If none of the tiles fit, adds a new, random tile
    // to the hand  
    private void makeMove(Hand hand) {

        boolean tileFit = false;

        /*
        When Tile is found this Boolean Becomes True and allows for 
        the Loops to exit To avoid the Checking and Moving of Multiple 
        Tiles at once.
         */
        for (int i = 0; i < hand.getSize() && !tileFit; i++) {
            /*
            Checks all Tiles within hand to see if Anyone
            Fits Without Rotation Needed. If a fit is found, It is added to the
            Board and Removed from the Hand. The Hand Remove() Method Takes Care
            Of the Hand Counter which keeps track of the Size of the Hand. Same
            Goes for the Board and its Size within the Board Add() Method.
             */
            if (getIndexForFit(hand.get(i)) != -1) {

                board.addTile(getIndexForFit(hand.get(i)), hand.get(i));
                hand.removeTile(i);

                break;
                /*
            When A fit is not found after checking all tiles within the Hand 
            As is, The next step within my MakeMove() Method is to start 
            Rotating each tile at least 3 times to see if it will fit after a 
            Rotation has been made. If so, The same Steps occur as they did in 
            The If Statement Above.
                 */
            } else {

                for (int j = 0; j < 3 && !tileFit; j++) {

                    hand.get(i).rotate();
                    if (getIndexForFit(hand.get(i)) != -1) {

                        board.addTile(getIndexForFit(hand.get(i)), hand.get(i));
                        hand.removeTile(i);
                        tileFit = true;

                    }

                }

            }

        }
        /*
        If No tile fits within the Board even after each tile has been 
        Rotated at least Three times, a new tile is added to the Hand that is 
        currently in play and it becomes the next player's Turn to make a move.
         */
        if (!tileFit) {

            hand.addTile();

        }

    }

    /**
     * @return results of the game as a huge multi-line String containing the
     * final board and the winner
     */
    // Return results of the game as a humongous multi-line String containing
    // the final board, both both player's final hands, and the winner
    public String getResults() {
        if (hand1.isEmpty() && hand2.isEmpty()) {

            winner = "It is a Tie!";

        } else if (hand1.isEmpty()) {

            winner = "Player 1 is the Winner!";

        } else if (hand2.isEmpty()) {

            winner = "Player 2 is the Winner!";

        }

        return board.toString() + "\n" + winner;
    }
} // end of TileGame2 class
