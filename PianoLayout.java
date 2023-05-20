import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
   
public class PianoLayout extends Canvas implements KeyListener {
   //counters
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
   static Key[] keys;

   //keys
   static boolean isPressed = false;
   static boolean isReleased = false;
   static boolean A2 = false;
   static boolean A3 = false;
   static boolean A4 = false;
   static boolean A5 = false;
   static boolean As2 = false;
   static boolean As3 = false;
   static boolean As4 = false;
   static boolean As5 = false;
   static boolean B2 = false;
   static boolean B3 = false;
   static boolean B4 = false;
   static boolean B5 = false;
   static boolean C2 = false;
   static boolean C3 = false;
   static boolean C4 = false;
   static boolean C5 = false;
   static boolean Cs2 = false;
   static boolean Cs3 = false;
   static boolean Cs4 = false;
   static boolean Cs5 = false;
   static boolean D2 = false;
   static boolean D3 = false;
   static boolean D4 = false;
   static boolean D5 = false;
   static boolean Ds2 = false;
   static boolean Ds3 = false;
   static boolean Ds4 = false;
   static boolean Ds5 = false;
   static boolean E2 = false;
   static boolean E3 = false;
   static boolean E4 = false;
   static boolean E5 = false;
   static boolean F2 = false;
   static boolean F3 = false;
   static boolean F4 = false;
   static boolean F5 = false;
   static boolean Fs2 = false;
   static boolean Fs3 = false;
   static boolean Fs4 = false;
   static boolean Fs5 = false;
   static boolean G2 = false;
   static boolean G3 = false;
   static boolean G4 = false;
   static boolean G5 = false;
   static boolean Gs2 = false;
   static boolean Gs3 = false;
   static boolean Gs4 = false;
   static boolean Gs5 = false;

   final static int SCREEN_WIDTH = 1300;
   final static int SCREEN_HEIGHT = 500;

   public PianoLayout() {
      JFrame frame = new JFrame("Piano");
      frame.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
      frame.getContentPane().setBackground(Color.GRAY);
      frame.add(initComponents());
      frame.setVisible(true);
      frame.setResizable(false);
      frame.addWindowListener(
         new WindowAdapter() { 
            public void windowClosing(WindowEvent e) {System.exit(0);} 
         });
      frame.setLocationRelativeTo(null);
   
      requestFocus();
      setFocusable(true);
   
      addKeyListener(this);
   
      requestFocusInWindow();}
      

   public void keyPressed(KeyEvent e) {
      if(e.getKeyCode() == KeyEvent.VK_Q) {
         C2 = true;
      }
   }

   public void keyReleased(KeyEvent e) {
   }

   public void keyTyped(KeyEvent e) {
   }

 
   public static JLayeredPane initComponents() {
      JLayeredPane layer = new JLayeredPane();
      layer.setSize(1120, 1150);
      keys = new Key[48];
      int keyIndex = 0, i;
      ImageIcon backgroundImage = new ImageIcon("wood.jpg");
      JLabel backgroundLabel = new JLabel(backgroundImage);
      backgroundLabel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
      layer.add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE));
   
      String[] whiteKeyNames = {"C", "D", "E", "F", "G", "A", "B"};
      String[] blackKeyNames = {"C#", "D#", "F#", "G#", "A#"};
   
      int octave = 3; // starting octave number
   
      for (i = 0; i < 28; i++) {
         JButton whiteKey = createWhiteKey(i);
         String whi = whiteKeyName(i, whiteKeyNames, octave);
         keys[keyIndex] = new Key(whi, whiteKey);
         layer.add(keys[keyIndex].getButton(), 0, -1);
         keyIndex += 1;
         if (i % 7 != 2 && i % 7 != 6) {
            JButton blackKey = createBlackKey(i);
            String bhi = blackKeyName(i, blackKeyNames, octave);
            keys[keyIndex] = new Key(bhi, blackKey);
            layer.add(keys[keyIndex].getButton(), 1, -1);
            keyIndex += 1;
         }
      
        // Update octave number
         if (i % 7 == 6) {
            octave++;
         }
      }
      return layer;
   }

   public static JButton createWhiteKey(int i) {
      Icon whiteKeyIcon = new ImageIcon("WhiteKey.png");
      JButton whiteKey = new JButton(whiteKeyIcon);
      whiteKey.setBorder(new LineBorder(Color.BLACK));
      whiteKey.setLocation(90 + i*40, SCREEN_HEIGHT/4);
      whiteKey.setSize(40, 150);
   
      return whiteKey;
   }

   public static JButton createBlackKey(int i) {
      Icon blackKeyIcon = new ImageIcon("BlackKey.png");
      JButton blackKey = new JButton(blackKeyIcon);
      blackKey.setLocation(90 + SCREEN_WIDTH/52 + i * 40, SCREEN_HEIGHT/4);
      blackKey.setSize(30, 90);
   
      return blackKey;
   }

   public static String whiteKeyName(int i, String[] whiteKeyNames, int octave) {
      String keyName = whiteKeyNames[i % 7];
      return keyName + octave;
   }
  
   public static String blackKeyName(int i, String[] blackKeyNames, int octave) {
      String keyName = blackKeyNames[i % 5];
      return keyName + octave;
   }

   public static void main(String[] args) {
      new PianoLayout();
   }
}
