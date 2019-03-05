import javax.swing.*;

import com.sun.prism.Image;

import java.awt.GridLayout;

public class Square extends JFrame {
   private JFrame frame = new JFrame();
   private JPanel panel = new JPanel();
   private JLabel[] blackButtons = new JLabel[4 * 8];
   private JButton[] whiteButtons = new JButton[4 * 8];

   public JLabel[] getblackButtons()
   {
      return blackButtons;

   }
   public JButton[] getwhiteButtons()
   {
      return whiteButtons;
   }
   public void setblackButtons(JLabel[] bb)
   {
      this.blackButtons = bb;
   } 
   public void setwhiteButtons(JButton[] wb)
   {
      this.whiteButtons = wb;
   }

    public Square()
    {
        panel.setLayout(new GridLayout(8,8));
        panel.setSize(1000,1000);
        for (int i=0; i<blackButtons.length; i++)
        {
           ImageIcon im = new ImageIcon("empty2.png");
           blackButtons[i] = new JLabel(im);
        }
        for (int i=0; i<whiteButtons.length; i++)
        {
           ImageIcon im = new ImageIcon("empty.png");
           whiteButtons[i] = new JButton(im);
        }
        for (int i=0; i<8; i++)
        {
           if(i%2 ==0)
           {
              for (int j=0; j<4; j++)
              {
                 panel.add(blackButtons[4*i +j]);
                 panel.add(whiteButtons[4*i +j]);
              }
           }
           else
           {
              for (int j=0; j<4; j++)
              {
                 panel.add(whiteButtons[4*i +j]);
                 panel.add(blackButtons[4*i +j]);
              }
           }
        }
        super.add(panel);
     } 
}
