import javax.swing.*;

import javax.swing.JFrame;

public class Square extends JFrame
{

public Square()
{
   JButton[] blackButtons = new JButton[4*8];
   JButton[] whiteButtons = new JButton[4*8];
   for (int i=0; i<blackButtons.length; i++)
   {
      blackButtons[i] = new JButton(" ");
   }
   for (int i=0; i<whiteButtons.length; i++)
   {
      whiteButtons[i] = new JButton(" ");
   }
   for (int i=0; i<8; i++)
   {
      if(i%2 ==0)
      {
         for (int j=0; j<4; j++)
         {
            add(blackButtons[4*i +j]);
            add(whiteButtons[4*i +j]);
         }
      }
      else
      {
         for (int j=0; j<4; j++)
         {
            add(whiteButtons[4*i +j]);
            add(blackButtons[4*i +j]);
         }
      }
   }
}

}
