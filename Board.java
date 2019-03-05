import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.JFrame;
public class Board extends JFrame
{
    public static void main (String [] args)
    {
        Square square = new Square();
        square.setSize(600,600);
        square.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        square.setVisible(true);
    }
}