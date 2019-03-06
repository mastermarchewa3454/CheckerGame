import javax.swing.*;

import com.sun.prism.Image;

import java.awt.GridLayout;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Square2 
{
   
   private JLabel[][] blackButtons = new JLabel[8][4];
   private JButton[][] whiteButtons = new JButton[8][4];
   private int[] whiteCounter = new int[12];
   private int[] redCounter = new int[12];

   public JLabel[][] getblackButtons() {
      return blackButtons;

   }

   public JButton[][] getwhiteButtons() {
      return whiteButtons;
   }

   public void setblackButtons(JLabel[][] bb) {
      this.blackButtons = bb;
   }

   public void setwhiteButtons(JButton[][] wb) {
      this.whiteButtons = wb;
   }
  

   public void setSquare() 
   {
     
      for (int i = 0; i < blackButtons[i].length; i++) 
      {
          for (int j=0; j<blackButtons[j].length; j++)
          {
            ImageIcon im = new ImageIcon("empty2.png");
            blackButtons[i][j] = new JLabel(im);
          }
         
      }
      for (int i = 0; i < whiteButtons[i].length; i++) 
      {
        for (int j=0; j< whiteButtons[j].length; j++)
        {
             ImageIcon im = new ImageIcon("empty.png");
             whiteButtons[i][j] = new JButton(im);
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
   }

   public void WhitePieces(int i)
   {
         ImageIcon image = new ImageIcon("white.png");
         whiteButtons[i][j].setIcon(image);
      }
   public void RedPieces(int i)
   {
         ImageIcon image = new ImageIcon("red.png");
         whiteButtons[i][j].setIcon(image);
         
   }
   
   public void moveTo(JButton[] whiteButtons)
   {
      

   }
}