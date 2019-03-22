/**
 * Models a square board for checkers game.
 * This class represent a board. When combined with Square class,
 * board can be represented on the screen with black or white squares.
*/
// All extension needed for this class
import javax.swing.*; 
import java.awt.GridLayout;
import javax.swing.JFrame;
public class Board extends JFrame
{
   // The following instance variables define the information needed to represent a Board
   
   private JPanel panel = new JPanel();          // the panel for the board
   private int col = 8;                          // the number of columns in board (needed to setup squares)
   private int row = 4;                          // the number of rows in board (needed to setup squares)

   public Board()
   {
      Square square = new Square();                            // import a square class to board
      JLabel[][] blackButtons = square.getblackButtons();      // import a black-nonplay buttons
      JButton[][] whiteButtons = square.getwhiteButtons();     // import a white buttons which play
      panel.setLayout(new GridLayout(col, col));               // set a panel throughout gridlayout
      setResizable(false);                                     // blocking ability to changing a size of the board
      panel.setVisible(true);                                  // make panel visible
      setSize(700, 700);                                       // set a size for panel
      square.setSquare();                                      // paint squares from Square class
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          
      setVisible(true);                                        // make the whole board visible

      /** 
       * Constructor. Create a new instance of a Board.
       * Add all black buttons (JLabel) to panel.
       * Add all white buttons (JButton) to panel.
       * For the even columns black button is setup first.
       * For the odd columns white button is setup first.
      */
      for (int i = 0; i < col; i++) 
      {
         
         if (i % 2 == 0) 
         {
            for (int j = 0; j < row; j++) 
            {
               panel.add(blackButtons[i][j]);
               panel.add(whiteButtons[i][j]);  
            }
         } 
         else 
         {
            for (int j = 0; j < row; j++) 
            {
               
               panel.add(whiteButtons[i][j]);
               panel.add(blackButtons[i][j]);
               
            }
         }
      }
      super.add(panel); // this command is used to show all buttons on the screen
   }

    public static void main (String [] args)
    {
        Board board = new Board(); // setting up a board in main to show it on the screen
    }
}