import javax.swing.*;

import com.sun.prism.Image;

import java.awt.GridLayout;

public class Square extends JFrame {
   private JFrame frame = new JFrame();
   private JPanel panel = new JPanel();
   private JLabel[] blackButtons = new JLabel[4 * 8];
   private JButton[] whiteButtons = new JButton[4 * 8];
   private int[] whiteCounter = new int[12];
   private int[] redCounter = new int[12];
   private int width = 8;

   public JLabel[] getblackButtons() {
      return blackButtons;

   }

   public JButton[] getwhiteButtons() {
      return whiteButtons;
   }

   public void setblackButtons(JLabel[] bb) {
      this.blackButtons = bb;
   }

   public void setwhiteButtons(JButton[] wb) {
      this.whiteButtons = wb;
   }

   public void setSquare() {
     // panel.setLayout(new GridLayout(width, width));
    // panel.setSize(1000, 1000);
      for (int i = 0; i < blackButtons.length; i++) {
         ImageIcon im = new ImageIcon("empty2.png");
         blackButtons[i] = new JLabel(im);
      }
      for (int i = 0; i < whiteButtons.length; i++) {
         ImageIcon im = new ImageIcon("empty.png");
         whiteButtons[i] = new JButton(im);
         if(i >19)
         {
            WhitePieces(i);
         }
         if (i <12)
         {
            RedPieces(i);
         }
      }
   }
    /*  for (int i = 0; i < width; i++) 
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
   */

   public void WhitePieces(int i)
   {
         ImageIcon image = new ImageIcon("white.png");
         whiteButtons[i].setIcon(image);
   }
   public void RedPieces(int i)
   {
         ImageIcon image = new ImageIcon("red.png");
         whiteButtons[i].setIcon(image);
   }
}
