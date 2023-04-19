import javax.swing.*;
import java.awt.*;
import java.util.*;
   
public class Piano {
//number of keys in 4 octaves
   private static final int WHITE_KEYS = 29; 
   private static final int BLACK_KEYS = 20;
   public static PianoLayout piano = new PianoLayout();

   private BlackKey[] blackKeys = new BlackKey[BLACK_KEYS];
   private WhiteKey[] whiteKeys = new WhiteKey[WHITE_KEYS];
   final static int SCREEN_WIDTH = 1300;
   final static int SCREEN_HEIGHT = 300;
    //black key images
   private static Image blackKey = new ImageIcon("blackKey.png").getImage();
   private static Image blackKeyDown = new ImageIcon("blackKeyDown.png").getImage();
   private static Image whiteKey = new ImageIcon("whiteKey.png").getImage();
   private static Image whiteKeyDown = new ImageIcon("whiteKeyDown.png").getImage();
   private static ImageIcon blackKeyI = new ImageIcon("blackKey.png");
   private static ImageIcon whiteKeyI = new ImageIcon("whiteKey.png");
   public Piano() {
      //white keys
      for (int i = 0; i < WHITE_KEYS; i++) {
         whiteKeys[i] = new WhiteKey(i * 20, 0, 20, 100, whiteKey, whiteKeyDown);
      }
   
      //black keys
      int blackKeyIndex = 0;
      for (int i = 0; i < BLACK_KEYS; i++) {
         if (i % 7 != 2 || i % 7 != 6) {
            blackKeys[blackKeyIndex] = new BlackKey(i * 20, 0, 20, 100, blackKey, blackKeyDown);
            blackKeyIndex++;
         }
      }
   }
   public static JButton createBlackKey() {
      ImageIcon i = new ImageIcon(blackKey);
      JButton black = new JButton("hi");
      black.setIcon(i);
      black.setBackground(Color.BLACK);
      black.setOpaque(true);
      return black;
   }

   public BlackKey[] getBlackKeys() {
      return blackKeys;
   }

   public WhiteKey[] getWhiteKeys() {
      return whiteKeys;
   }   
   public void paint(Graphics brush){
   
   }
   
   public static void main(String[]args)
   {
   
      JFrame frame = new JFrame("Piano");	//window title
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      frame.setResizable(false);
      JPanel panel = new JPanel(new BorderLayout());
      Container contentPane = frame.getContentPane();
      contentPane.setLayout(new FlowLayout());
      for(int i = 0; i < BLACK_KEYS; i++){
         JButton button = new JButton(blackKeyI);
         button.setBorderPainted(false);
         button.setContentAreaFilled(false);
         frame.add(button);
      }          
   }
}
