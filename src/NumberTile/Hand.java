/*
Ziad Malik
Section U01
Hand.java
I affirm that this program is entirely my own work 
and none of it is the work of any other person.
 */
package NumberTile;

/**
 * The Hand Class is the class for the hands within the game specifically. This
 * Class constructs the hand and also is the way to access specific
 * characteristics of the hand such as obtaining a tile at a specific index and
 * also obtaining the size of the hand. The class that converts hands into
 * strings.
 *
 * @author Ziad Malik
 *
 */
// A player's hand of NumberTiles
public class Hand {

    private NumberTile[] hand;    // a player's hand of tiles
    private int handSize;          // current number of tiles in the hand
    private static final int MAX_TILES = 50;    // maximum hand size
    private static final int INITIAL_SIZE = 5;  // starting hand size

    /**
     * Creates a new hand of 5 NumberTiles
     */
    // Creates a new hand containing INITIAL_SIZE NumberTiles, but with a 
    // capacity of MAX_TILES
    public Hand() {
        handSize = 5;
        hand = new NumberTile[MAX_TILES];
        for (int i = 0; i < INITIAL_SIZE; i++) {

            hand[i] = new NumberTile();

        }
    }

    /**
     * Get the NumberTile at the specified index in this Hand
     *
     * @param index Is the Parameter that tells the method which Tile within the
     * hand the Caller of the method wants.
     * @return The Method then moves onto Returning that specific Tile Similar
     * to the Board get Method
     */
    // Get the NumberTile at the specified index in this Hand
    public NumberTile get(int index) {

        return hand[index];

    }

    /**
     * Get the number of tiles in this Hand
     *
     * @return Returns the Number of Tiles in the Hand in the form of an Integer
     * That is tracked by our handSize Integer that Changes as we add and remove
     * Tiles from the Hand. We implement the code for the change of the handSize
     * within the Remove and Add Tile Methods within this class.
     */
    // Get the number of tiles in this Hand
    public int getSize() {

        return handSize;

    }

    /**
     * Adds a new NumberTile to this Hand and also Increments the HandSize
     * Integer in order to keep track of the Hand's Size
     */
    // Add a new NumberTile to this Hand
    public void addTile() {

        hand[handSize] = new NumberTile();
        handSize++;
    }

    /**
     * Remove the NumberTile at the specified index from this Hand
     *
     * @param index This Parameter indicates which specific tile within the hand
     * to remove. For example if index = 0 it will remove the tile at index (0)
     * of the hand. Since we are now doing Arrays I must implement a code within
     * my remove Method that Pushes all the Tiles after the Specified Tile to be
     * removed, Down one unit in order to cover for the empty space that is now
     * there because of the Removal of Tile at the Specified Index within the
     * Hand. handSize Counter is also Decremented to keep track of the Size of
     * the Hand.
     */
    // Remove the NumberTile at the specified index from this Hand
    public void removeTile(int index) {

        for (int i = index; i < handSize - 1; i++) {

            hand[i] = hand[i + 1];

        }

        handSize--;

    }

    /**
     * This method check to see if this hand is empty. If the HandSize integer 
     * is equal to 0, the Boolean is set to true and vice versa for when it 
     * is not equal to 0
     *
     * @return True or False is Returned Depending on if the method finds the
     * handSize to be empty or not. If empty, True is returned. If not, False.
     */
    // Is this hand empty?
    public boolean isEmpty() {

        if (handSize == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Return this Hand as a multi-line String.
     *
     * @return Returns the String Version of the Hand and if it is Empty,
     * Returns an Appropriate String.
     */
    // Return this Hand as a multiline String.
    // If this Hand is empty, return an appropriate message
    public String toString() {

        String Hand;
        /*
        String Hand is a holder and Initializer for the String that will be
        Returned to the Method Caller.
         */
        Hand = "";
        if (isEmpty()) {

            Hand = "This Hand is Empty!\n";

        } else {

            for (int i = 0; i < handSize; i++) {

                String handAdd;
                handAdd = (hand[i].toString() + "\n");

                Hand = Hand + handAdd;
            }

        }
        return Hand;
    }
}
