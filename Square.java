import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class Square extends JFrame
{
   private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JLabel[] blackButtons = new JLabel[4*8];
    private JButton[] whiteButtons = new JButton[4*8];

   public void getblackButtons(JLabel[] bb)
   {
      blackButtons = bb;
   }
   public void getwhiteButtons(JButton[] wb)
   {
      whiteButtons = wb;
   }

    public Square()
    {
        panel.setLayout(new GridLayout(8,8));
        panel.setSize(1000,1000);
        for (int i=0; i<blackButtons.length; i++)
        {
           blackButtons[i] = new JLabel();
        }
        for (int i=0; i<whiteButtons.length; i++)
        {
           whiteButtons[i] = new JButton();
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
