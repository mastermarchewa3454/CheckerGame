import javax.swing.*;
import java.awt.*;

import com.sun.beans.util.Cache.Kind;
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
   private boolean canPlay= false; 
   private int tempI, tempJ;
   private int whoIsPlay = WHITE; 
   // tempI is a an old address i
   // tempJ is a an old address j
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
             whiteButtons[i][j].addActionListener(this);
        }
         
         
      }
   }

   public void setPieces(int i, int j)
   {
      
      if (i>=5)
         {
             ImageIcon image = new ImageIcon("white.png");
             whiteButtons[i][j].setIcon(image);
             positionChecker[i][j] = WHITE;  
         }
      if (i<=2)
         {
            ImageIcon image = new ImageIcon("red.png");
            whiteButtons[i][j].setIcon(image);
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
               if (canPlay == false && checkPlayer(i,j) == true)
               {
                  resetAvailablePlaces();
                  tempI = i;
                  tempJ = j; 
                  getAvailablePlaces(i,j);
               }
               else if (canPlay == true && availablePlace[i][j] == 1)
               {
                  moveTo(i,j, tempI, tempJ);
               }
               else if (canPlay == true && availablePlace[i][j] ==0)
               {
                  resetAvailablePlaces();
               }
            }
         }
   
      }
   }
   public void changePlayer()
   {
      if(whoIsPlay == RED)
      {
         whoIsPlay = WHITE;
      }
      else if (whoIsPlay == WHITE)
      {
         whoIsPlay = RED;
      }
   }
   public boolean checkPlayer(int i, int j)
   {
      if(whoIsPlay == RED && positionChecker[i][j] == RED )
      {
         return true;
      }
      if(whoIsPlay == WHITE && positionChecker[i][j] == WHITE )
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   public void paint()
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
            else if(positionChecker[i][j] == RED)
            {
               ImageIcon image = new ImageIcon("red.png");
               whiteButtons[i][j].setIcon(image);
            }
            else if (positionChecker[i][j] == WHITE)
            {
               ImageIcon image = new ImageIcon("white.png");
               whiteButtons[i][j].setIcon(image);
            }
            else if(positionChecker[i][j] == EMPTY)
            {
               ImageIcon image = new ImageIcon("empty.png");
               whiteButtons[i][j].setIcon(image);
            }
         }
      }
   }
   public void resetAvailablePlaces()
   {
      tempI=0;
      tempJ=0;
      canPlay = false;
      for (int i = 0; i < 8; i++) 
      {
         for (int j=0; j< 4; j++)
         {
               availablePlace[i][j] = 0;
         }
      }
      
      paint();
   }
   
   public void getAvailablePlaces(int i, int j)
   {
      canPlay = true;
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
         }
         if (j!=3)
         {
            if (positionChecker[i+1][j+1] == EMPTY)
            {
               
               availablePlace[i+1][j+1] =1;
             
            }
         }
         
      }
      if (i%2 == 1)
      {
         if (positionChecker[i+1][j] == EMPTY)
         {
            
            availablePlace[i+1][j] =1;      
         }
         if(j!=3)
         {
            if (positionChecker[i+1][j-1] == EMPTY)
            {
               
               availablePlace[i+1][j-1] =1;
            }
         }
         
      }
      paint();
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
      paint();
   }
   public void moveTo(int i, int j, int tempI, int tempJ)
   {
      int temp = positionChecker[tempI][tempJ];
      positionChecker[i][j] = temp;
      positionChecker[tempI][tempJ] = EMPTY;
      resetAvailablePlaces();
      changePlayer();
   }
}