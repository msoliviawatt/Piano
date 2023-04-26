import javax.swing.*;
import java.awt.*;
import java.util.*;
   
public class PianoLayout 
{
   private static JLayeredPane initComponents()
   {
      JLayeredPane layer = new JLayeredPane();
      //ScrollableLayeredPane layer = new ScrollableLayeredPane();
      layer.setSize(1120,1150);
      JButton[] keys = new JButton[48];
      int keyIndex = 0, i;
   
      for(i=0;i<28;i++)
      {
         keys[keyIndex] = createWhiteKey(i);
         layer.add(keys[keyIndex], 0, -1);
         keyIndex+=1;
         if(i%7!=2 && i%7!=6)
         {
            keys[keyIndex] = createBlackKey(i);
            layer.add(keys[keyIndex], 1, -1);
            keyIndex+=1;
         }
      }
      return layer;
   }
   private static JButton createWhiteKey(int i)
   {
      JButton whiteKey = new JButton();
      whiteKey.setBackground(Color.WHITE);
      whiteKey.setLocation(i*40,0);
      whiteKey.setSize(40, 150);
      return whiteKey;
   }

   private static JButton createBlackKey(int i)
   {
      JButton blackKey = new JButton();
      blackKey.setBackground(Color.BLACK);
      blackKey.setLocation(25 + i*40,0);
      blackKey.setSize(30, 90);
      return blackKey;
   }
    public static void main(String[] args)
   {
      JPanel panel = new JPanel(null);
      JFrame mainFrame = new JFrame();
      // mainFrame
      // PianoLayout pianoLayout = new PianoLayout();
      mainFrame.add(panel);
      panel.add(initComponents());
      mainFrame.setSize(500,500);
      mainFrame.setVisible(true);
   }

}
