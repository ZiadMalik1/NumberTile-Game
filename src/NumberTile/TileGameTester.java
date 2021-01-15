/*
Ziad Malik
Section U01
TileGameTester.java
I affirm that this program is entirely my own work 
and none of it is the work of any other person.
 */
package NumberTile;

import javax.swing.JOptionPane;

/**
 *
 * The Tile Game Tester Class is Used to Run an Instance of the Tile Game Class
 * Within The Class Two Instances of Hands are created and they are used to play
 * The game.
 *
 */
public class TileGameTester {

    /**
     * @param args the command line arguments The Main Method of the Class that
     * creates the initial Player hands and starts the game and obtains the
     * results of the game with the given hands.
     */
    public static void main(String[] args) {

        /*
        The String startGame is used to keep the Game Restarting for as long 
        as the User wants to Observe two computer hands playing against one
        Another. Will take input and based on the Input see if the Game Will
        Continue
         */
        String startGame = JOptionPane.showInputDialog("Please Hit Any Key to "
                + "Start a Game (Press Cancel to end) ");

        while (startGame != null) {

            Hand Player1 = new Hand();
            Hand Player2 = new Hand();
            System.out.println("Starting a New Game...");
            System.out.println("Player 1's Initial Hand\n\n" + Player1);
            System.out.println("-----------------\n");
            System.out.println("Player 2's Initial Hand\n\n" + Player2);
            System.out.println("-----------------\n");
            TileGame newGame = new TileGame(Player1, Player2);
            newGame.play();
            System.out.println("After the Game...\n-----\nPlayer 1's Hand:\n\n"
                    + Player1.toString() + "-----\nPlayer 2's Hand:\n\n"
                    + Player2.toString() + "\n" + newGame.getResults()
                    + "\n-------------------");
            startGame = JOptionPane.showInputDialog("Would you Like to "
                    + "Start another Game? (Press Cancel to end) ");
        }
        JOptionPane.showMessageDialog(null, "Thank You",
                "NumberTile Game", JOptionPane.PLAIN_MESSAGE);

    }
}
