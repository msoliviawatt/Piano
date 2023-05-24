import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
   
public class PianoLayout implements KeyListener {

   static Key[] keys;
   static HashMap<Integer, String> keyFile = null;

   //background images
   ImageIcon background = new ImageIcon("wood.jpeg");
   Image scaledImage = background.getImage().getScaledInstance(1300, 500,Image.SCALE_DEFAULT);
   ImageIcon scaledBackground = new ImageIcon(scaledImage);

   //black key image management
   static ImageIcon blackKeyImage = new ImageIcon("BlackKey.png");
   static Image tempBK = blackKeyImage.getImage().getScaledInstance(30, 90,Image.SCALE_DEFAULT);
   static ImageIcon scaledBlackKey = new ImageIcon(tempBK);

   static ImageIcon blackKeyDown = new ImageIcon("BlackKeyDown.png");
   static Image tempBKD = blackKeyDown.getImage().getScaledInstance(30, 90,Image.SCALE_DEFAULT);
   static ImageIcon scaledBlackKeyDown = new ImageIcon(tempBKD);

   //white key image management
   static ImageIcon whiteKeyImage = new ImageIcon("WhiteKey.png");
   static Image tempWK = whiteKeyImage.getImage().getScaledInstance(40, 150,Image.SCALE_DEFAULT);
   static ImageIcon scaledWhiteKey = new ImageIcon(tempWK);

   static ImageIcon whiteKeyDown = new ImageIcon("WhiteKeyDown.png");
   static Image tempWKD = whiteKeyDown.getImage().getScaledInstance(40, 150,Image.SCALE_DEFAULT);
   static ImageIcon scaledWhiteKeyDown = new ImageIcon(tempWKD);

   //screen
   final static int SCREEN_WIDTH = 1300;
   final static int SCREEN_HEIGHT = 500;
   static JFrame frame = null;

   //keyboard
   static String[] whiteKeyboard = {"`", "2", "4", "5", "7", "9", "-", "=", "W", "R", "T", "U", "O", "[", "]", "CAPS LOCK", "S", "D", "G", "J", "L", ";", "Z", "C", "V", "N", ",", "/"};
   static String[] blackKeyboard = {"1", "3", "6", "8", "0", "Q", "E", "Y", "I", "P", "\\", "A", "F", "H", "K", "SHIFT", "X", "B", "M", "."};

   //sets up JFrame format
   public PianoLayout() {
      frame = new JFrame("Piano");
      JLabel contentPane = new JLabel();
      contentPane.setIcon(scaledBackground);
      contentPane.setLayout(new BorderLayout());
      frame.setContentPane(contentPane);
   
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
            
      frame.addKeyListener(this);
      frame.requestFocusInWindow();
   }
      
   public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode();
      // Play audio and print out name of the note played
      String fileName = keyFile.get(key);
      if (fileName != null && key != KeyEvent.VK_TAB) {
         Audio.playSound("AudioFiles/" + fileName);
         System.out.println(fileName.substring(0, fileName.length()-4));//removes ".mp3" so it just shows the note name
      }
   }

   public void keyReleased(KeyEvent e) {
   }


   public void keyTyped(KeyEvent e) {
   }
   
 //create piano
   public static JLayeredPane initComponents() {
      JLayeredPane layer = new JLayeredPane();
      layer.setSize(1120, 1150);
      keys = new Key[48];
      int keyIndex = 0, i;
            
      String[] whiteKeyNames = {"C", "D", "E", "F", "G", "A", "B"};
      String[] blackKeyNames = {"C#", "D#", "F#", "G#", "A#"};
      int octave = 3; // starting octave number
      int blackKeyIndex = 0; //keep track of the black keys
      
      //create 28 white keys
      for (i = 0; i < 28; i++) {
         JButton whiteKey = createWhiteKey(i);
         String whi = whiteKeyName(i, whiteKeyNames, octave);
         keys[keyIndex] = new Key(whi, whiteKey);
         layer.add(keys[keyIndex].getButton(), 0, -1);
         keyIndex += 1;
         if (i % 7 != 2 && i % 7 != 6) {//checks if there should be a black key
            JButton blackKey = createBlackKey(i, blackKeyIndex);
            String bhi = blackKeyName(blackKeyIndex, blackKeyNames, octave);
            keys[keyIndex] = new Key(bhi, blackKey);
            layer.add(keys[keyIndex].getButton(), 1, -1);
            keyIndex += 1;
            blackKeyIndex++;
         }
      
        // Update octave number
         if (i % 7 == 6) {
            octave++;
         }
      }
     
     // Initiate Key-Filename mapping
      keyFile = new HashMap<Integer, String>();
      keyFile.put(KeyEvent.VK_BACK_QUOTE, "C3.mp3");
      keyFile.put(KeyEvent.VK_1, "C#3.mp3");
      keyFile.put(KeyEvent.VK_2, "D3.mp3");
      keyFile.put(KeyEvent.VK_3, "D#3.mp3");
      keyFile.put(KeyEvent.VK_4, "E3.mp3");
      keyFile.put(KeyEvent.VK_5, "F3.mp3");
      keyFile.put(KeyEvent.VK_6, "F#3.mp3");
      keyFile.put(KeyEvent.VK_7, "G3.mp3");
      keyFile.put(KeyEvent.VK_8, "G#3.mp3");
      keyFile.put(KeyEvent.VK_9, "A3.mp3");
      keyFile.put(KeyEvent.VK_0, "A#3.mp3");
      keyFile.put(KeyEvent.VK_MINUS, "B3.mp3");
      keyFile.put(KeyEvent.VK_EQUALS, "C4.mp3");
      keyFile.put(KeyEvent.VK_Q, "C#4.mp3");
      keyFile.put(KeyEvent.VK_W, "D4.mp3");
      keyFile.put(KeyEvent.VK_E, "D#4.mp3");
      keyFile.put(KeyEvent.VK_R, "E4.mp3");
      keyFile.put(KeyEvent.VK_T, "F4.mp3");
      keyFile.put(KeyEvent.VK_Y, "F#4.mp3");
      keyFile.put(KeyEvent.VK_U, "G4.mp3");
      keyFile.put(KeyEvent.VK_I, "G#4.mp3");
      keyFile.put(KeyEvent.VK_O, "A4.mp3");
      keyFile.put(KeyEvent.VK_P, "A#4.mp3");
      keyFile.put(KeyEvent.VK_OPEN_BRACKET, "B4.mp3");
      keyFile.put(KeyEvent.VK_CLOSE_BRACKET, "C5.mp3");
      keyFile.put(KeyEvent.VK_BACK_SLASH, "C#5.mp3");
      keyFile.put(KeyEvent.VK_CAPS_LOCK, "D5.mp3");
      keyFile.put(KeyEvent.VK_A, "D#5.mp3");
      keyFile.put(KeyEvent.VK_S, "E5.mp3");
      keyFile.put(KeyEvent.VK_D, "F5.mp3");
      keyFile.put(KeyEvent.VK_F, "F#5.mp3");
      keyFile.put(KeyEvent.VK_G, "G5.mp3");
      keyFile.put(KeyEvent.VK_H, "G#5.mp3");
      keyFile.put(KeyEvent.VK_J, "A5.mp3");
      keyFile.put(KeyEvent.VK_K, "A#5.mp3");
      keyFile.put(KeyEvent.VK_L, "B5.mp3");
      keyFile.put(KeyEvent.VK_SEMICOLON, "C6.mp3");
      keyFile.put(KeyEvent.VK_SHIFT, "C#6.mp3");
      keyFile.put(KeyEvent.VK_Z, "D6.mp3");
      keyFile.put(KeyEvent.VK_X, "D#6.mp3");
      keyFile.put(KeyEvent.VK_C, "E6.mp3");
      keyFile.put(KeyEvent.VK_V, "F6.mp3");
      keyFile.put(KeyEvent.VK_B, "F#6.mp3");
      keyFile.put(KeyEvent.VK_N, "G6.mp3");
      keyFile.put(KeyEvent.VK_M, "G#6.mp3");
      keyFile.put(KeyEvent.VK_COMMA, "A6.mp3");
      keyFile.put(KeyEvent.VK_PERIOD, "A#6.mp3");
      keyFile.put(KeyEvent.VK_SLASH, "B6.mp3"); 
           
     
      return layer;
   }

   public static JButton createWhiteKey(int i) {
      //creates a jbutton for each white key with an image and and a string(which key to press to play the note)
      JButton whiteKey = new JButton(whiteKeyboard[i], scaledWhiteKey);
      whiteKey.setLocation(90 + i*40, SCREEN_HEIGHT/4);
      whiteKey.setSize(40, 150);
      whiteKey.setBorder(BorderFactory.createLineBorder(Color.GRAY));
      whiteKey.setHorizontalTextPosition(SwingConstants.CENTER);               
      whiteKey.addMouseListener( //change the image when white key is clicked
         new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
               whiteKey.setIcon(scaledWhiteKeyDown);
            }
         
            public void mouseReleased(MouseEvent e) {
               whiteKey.setIcon(scaledWhiteKey);
            }
         });
      return whiteKey;
   }

   public static JButton createBlackKey(int i, int j) {
      //creates a jbutton for each black key with an image and and a string(which key to press to play the note)
      JButton blackKey = new JButton(blackKeyboard[j], scaledBlackKey);
      blackKey.setContentAreaFilled(false);
      blackKey.setBorder(null);
      blackKey.setHorizontalTextPosition(JButton.CENTER);
      blackKey.setVerticalTextPosition(JButton.CENTER);
      blackKey.setMargin(new Insets(0, 0, 0, 0));
      blackKey.setForeground(Color.WHITE);
      if (blackKeyboard[j].equals("SHIFT")) {
         Font shiftFont = new Font("Arial", Font.PLAIN, 10); // Set a smaller font size for "Shift" because it doesn't fit
         blackKey.setFont(shiftFont);
      }
   
      blackKey.setLocation(90 + SCREEN_WIDTH/52 + i * 40, SCREEN_HEIGHT/4);
      blackKey.setSize(30, 90);
   
      blackKey.addMouseListener(//change the image when black key is clicked
         new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
               blackKey.setIcon(scaledBlackKeyDown);
            }
         
            public void mouseReleased(MouseEvent e) {
               blackKey.setIcon(scaledBlackKey);
            }
         });
   
      return blackKey;
   }

     //get the white key name for the audio file
   public static String whiteKeyName(int i, String[] whiteKeyNames, int octave) {
      String keyName = whiteKeyNames[i % 7];
      return keyName + octave;
   }
   
    //get the black key name for the audio file
   public static String blackKeyName(int i, String[] blackKeyNames, int octave) {
      String keyName = blackKeyNames[i % 5];
      return keyName + octave;
   }
  

   public static void main(String[] args) {
      new PianoLayout();
   }
}
