import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
// import java.util.*;
   
public class PianoLayout {
   static int counterA = 0;
   static int counterB = 0;
   static int counterC = 0;
   static int counterD = 0;
   static int counterE = 0;
   static int counterF = 0;
   static int counterG = 0;
   static int counterSharpC = 0;
   static int counterSharpD = 0;
   static int counterSharpF = 0;
   static int counterSharpG = 0;
   static int counterSharpA = 0;


   final static int SCREEN_WIDTH = 1300;
   final static int SCREEN_HEIGHT = 300;

   public static JLayeredPane initComponents() {
      JLayeredPane layer = new JLayeredPane();
      //ScrollableLayeredPane layer = new ScrollableLayeredPane();
      layer.setSize(1120,1150);
      Key[] keys = new Key[48];
      int keyIndex = 0, i;
   
      for(i=0;i<28;i++)
      {
         JButton whiteKey = createWhiteKey(i);
         String whi = whiteKeyName(i);
         keys[keyIndex].setButton(whiteKey);
         if(whi.equals("A")) {
            counterA++;
            whi = whi + counterA;
         } else if (whi.equals("B")) {
            counterB++;
            whi = whi + counterB;
         } else if (whi.equals("C")) {
            counterC++;
            whi = whi + counterC;
         } else if (whi.equals("D")) {
            counterD++;
            whi = whi + counterD;
         } else if (whi.equals("E")) {
            counterE++;
            whi = whi + counterE;
         } else if (whi.equals("F")) {
            counterF++;
            whi = whi + counterF;
         } else if (whi.equals("G")) {
            counterG++;
            whi = whi + counterG;
         }
         keys[keyIndex].setKey(whi);
         layer.add(keys[keyIndex].getButton(), 0, -1);
         keyIndex+=1;
         if(i%7!=2 && i%7!=6)
         {
            JButton blackKey = createBlackKey(i);
            String bhi = blackKeyName(i);
            keys[keyIndex].setButton(blackKey);
            if(bhi.equals("C#")) {
               counterSharpC++;
               bhi = bhi + counterSharpC;
            } else if (bhi.equals("D#")) {
               counterSharpD++;
               bhi = bhi + counterSharpD;
            } else if (bhi.equals("F#")) {
               counterSharpF++;
               bhi = bhi + counterSharpF;
            } else if (bhi.equals("G#")) {
               counterSharpG++;
               bhi = bhi + counterSharpG;
            } else if (bhi.equals("A#")) {
               counterSharpA++;
               bhi = bhi + counterSharpA;
            }
            keys[keyIndex].setKey(bhi);
            layer.add(keys[keyIndex].getButton(), 1, -1);
            keyIndex+=1;
         }
      }
      return layer;
   }

   public static JButton createWhiteKey(int i) {
      Icon whiteKeyIcon = new ImageIcon("WhiteKey.png");
      JButton whiteKey = new JButton(whiteKeyIcon);
      whiteKey.setBorder(new LineBorder(Color.BLACK));
      whiteKey.setLocation(i*40, SCREEN_HEIGHT/4);
      whiteKey.setSize(40, 150);
      return whiteKey;
   }

   public static JButton createBlackKey(int i) {
      Icon blackKeyIcon = new ImageIcon("BlackKey.png");
      JButton blackKey = new JButton(blackKeyIcon);
      blackKey.setLocation(SCREEN_WIDTH/52 + i * 40, SCREEN_HEIGHT/4);
      blackKey.setSize(30, 90);
      return blackKey;
   }
    public static void main(String[] args) {
      JPanel panel = new JPanel(null);
      JFrame mainFrame = new JFrame();
      mainFrame.add(panel);
      panel.add(initComponents());
      mainFrame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
      mainFrame.setVisible(true);
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static String whiteKeyName(int i) {
      String[] whiteKeyNames = {"C","D","E","F","G","A","B"};
      return whiteKeyNames[i%7];
   }

   public static String blackKeyName(int i) {
      String[] blackKeyNames = {"C#","D#","F#","G#","A#"};
      return blackKeyNames[i%5];
   }
}