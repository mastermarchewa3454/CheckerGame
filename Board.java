import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.JFrame;
public class Board extends JFrame
{
   private JFrame frame = new JFrame();
   private JPanel panel = new JPanel();
   private int width = 8;
   public Board()
   {
      Square square = new Square();
      JLabel[] blackButtons = square.getblackButtons();
      JButton[] whiteButtons = square.getwhiteButtons();
      panel.setLayout(new GridLayout(width, width));
      panel.setVisible(true);
      square.setSquare();
      setSize(600, 600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      for (int i = 0; i < width; i++) 
      {
         
         if (i % 2 == 0) 
         {
            for (int j = 0; j < 4; j++) 
            {
               panel.add(blackButtons[4 * i + j]);
               panel.add(whiteButtons[4 * i + j]);  
            }
         } 
         else 
         {
            for (int j = 0; j < 4; j++) 
            {
               
               panel.add(whiteButtons[4 * i + j]);
               panel.add(blackButtons[4 * i + j]);
               
            }
         }
      }
      super.add(panel);
   }
   
    public static void main (String [] args)
    {
        Board board = new Board();
    }
}