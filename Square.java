import javax.swing.*;
import java.awt.*;
import com.sun.prism.Image;
import java.awt.event.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Square implements ActionListener
{
   
   private JLabel[][] blackButtons = new JLabel[8][4];
   private JButton[][] whiteButtons = new JButton[8][4];
   private int[][] positionChecker = new int[8][4];
   private int[][] availablePlace = new int [8][4];
   private static final int EMPTY = 0, RED = 1, RED_KING = 2, WHITE = 3, WHITE_KING = 4;
   private boolean inPlay = false; 
// 1 -empty 2- white 3 - red 4 - selected 5- whiteking 6 -
 
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
     
      for (int i = 0; i < 8; i++) 
      {
          for (int j=0; j<4; j++)
          {
            ImageIcon im = new ImageIcon("empty2.png");
            blackButtons[i][j] = new JLabel(im);
          }
         
      }
      for (int i = 0; i < 8; i++) 
      {
        for (int j=0; j< 4; j++)
        {
             ImageIcon im = new ImageIcon("empty.png");
             whiteButtons[i][j] = new JButton(im);
             positionChecker[i][j] = EMPTY;
             
             if(i >=5 || i<=2)
             {
                setPieces(i,j);
             }
             
        }
         
         
      }
   }

   public void setPieces(int i, int j)
   {
      
      if (i>=5)
         {
             ImageIcon image = new ImageIcon("white.png");
             whiteButtons[i][j].setIcon(image);
             whiteButtons[i][j].addActionListener(this);
             positionChecker[i][j] = WHITE;
         }
      if (i<=2)
         {
            ImageIcon image = new ImageIcon("red.png");
            whiteButtons[i][j].setIcon(image);
            whiteButtons[i][j].addActionListener(this);
            positionChecker[i][j] = RED;
         } 
   }
   public void actionPerformed(ActionEvent e) 
   {
      JButton src = (JButton) e.getSource();
      for (int i = 0; i < 8; i++) 
      {
         for (int j=0; j< 4; j++)
         {
            if (src==whiteButtons[i][j] ) 
            {
               moveTo(i,j);
            }
         }
   
      }
   }
   public void moveTo(int i, int j)
   { 
      resetAvailablePlaces();
      getAvailablePlaces(i,j);
   }
   public void paintAvailablePlaces()
   {
      for (int i = 0; i < 8; i++) 
      {
         for (int j=0; j< 4; j++)
         {
            if (availablePlace[i][j] == 1)
            {
               ImageIcon image = new ImageIcon("selected.png");
               whiteButtons[i][j].setIcon(image);
            }
            if (availablePlace[i][j] == 0 && positionChecker[i][j] == EMPTY)
            {
               ImageIcon image = new ImageIcon("empty.png");
               whiteButtons[i][j].setIcon(image);
            }

         }
      }
   }
   public void resetAvailablePlaces()
   {
      for (int i = 0; i < 8; i++) 
      {
         for (int j=0; j< 4; j++)
         {
               availablePlace[i][j] = 0;
         }
      }
      paintAvailablePlaces();
   }
   
   public void getAvailablePlaces(int i, int j)
   {
      if (positionChecker[i][j] == RED)
            {
               movingDown(i,j);
            }
         if (positionChecker[i][j] == WHITE)
            {
               movingUp(i,j);
            }
   }
   public void movingDown(int i, int j)
   {
      if (i%2 == 0)
      {
         if (positionChecker[i+1][j] == EMPTY)
         {
            availablePlace[i+1][j] =1;
            inPlay = true;
         }
         if (j!=3)
         {
            if (positionChecker[i+1][j+1] == EMPTY)
            {
               availablePlace[i+1][j+1] =1;
               inPlay = true;
            }
         }
         
      }
      if (i%2 == 1)
      {
         if (positionChecker[i+1][j] == EMPTY)
         {
            availablePlace[i+1][j] =1;
            inPlay = true;
            
         }
         if(j!=3)
         {
            if (positionChecker[i+1][j-1] == EMPTY)
            {
               availablePlace[i+1][j-1] =1;
               inPlay = true;
            }
         }
         
      }
      paintAvailablePlaces();
        /*       if(availablePlace[i+1][j]== 0)
               {
                  ImageIcon image = new ImageIcon("selected.png");
                  whiteButtons[i+1][j].setIcon(image);
               }
               if (availablePlace[i+1][j+1] ==0)
               {
                  ImageIcon image = new ImageIcon("selected.png");
                  whiteButtons[i+1][j+1].setIcon(image);
               }
               else if (availablePlace[i+1][j-1] == 0)
               {
                  ImageIcon image = new ImageIcon("selected.png");
                  whiteButtons[i+1][j-1].setIcon(image);
               }
               else if (availablePlace[i+1][j+2] == 0)
               {
                  ImageIcon image = new ImageIcon("selected.png");
                  whiteButtons[i+1][j+2].setIcon(image);
               }
               */

   }
   public void movingUp(int i, int j)
   {
      if (i%2 == 0)
      {
         if (positionChecker[i-1][j] == EMPTY)
         {
            availablePlace[i-1][j] =1;
         }
         if(j!=3)
         {
            if (positionChecker[i-1][j+1] == EMPTY)
            {
               availablePlace[i-1][j+1] =1;
            }
         }
      }
      if (i%2 == 1)
      {
         if (positionChecker[i-1][j] == EMPTY)
         {
            availablePlace[i-1][j] =1;
            
         }
         if (j!=0) 
         {
            if (positionChecker[i-1][j-1] == EMPTY)
            {
               availablePlace[i-1][j-1] =1;
            }
         }
         
         
      }
      paintAvailablePlaces();
   }
}