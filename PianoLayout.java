import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.util.*;
   
public class PianoLayout 
{

   final static int SCREEN_WIDTH = 1300;
   final static int SCREEN_HEIGHT = 300;

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
      Icon whiteKeyIcon = new ImageIcon("WhiteKey.png");
      JButton whiteKey = new JButton(whiteKeyIcon);
      whiteKey.setBorder(new LineBorder(Color.BLACK));
      whiteKey.setLocation(i*40, SCREEN_HEIGHT/4);
      whiteKey.setSize(40, 150);
      return whiteKey;
   }

   private static JButton createBlackKey(int i)
   {
      Icon blackKeyIcon = new ImageIcon("BlackKey.png");
      JButton blackKey = new JButton(blackKeyIcon);
      blackKey.setLocation(SCREEN_WIDTH/52 + i * 40, SCREEN_HEIGHT/4);
      blackKey.setSize(30, 90);
      return blackKey;
   }
    public static void main(String[] args)
   {
      JPanel panel = new JPanel(null);
      JFrame mainFrame = new JFrame();
      mainFrame.add(panel);
      panel.add(initComponents());
      mainFrame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
      mainFrame.setVisible(true);
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

}
