import java.awt.*;
import javax.swing.*;

public class Piano {
    private final int WHITE_KEYS = 52;
    private int BLACK_Keys = 36;

    private BlackKey[] blackKeys = new BlackKey[BLACK_Keys];
    private WhiteKey[] whiteKeys = new WhiteKey[WHITE_KEYS];

    //black key images
    private Image blackKey = new ImageIcon("blackKey.png").getImage();
    private Image blackKeyDown = new ImageIcon("blackKeyDown.png").getImage();

    public Piano() {
        //white keys
        // for (int i = 0; i < WHITE_KEYS; i++) {
        //     whiteKeys[i] = new WhiteKey(i * 20, 0, 20, 100);
        // }

        //black keys
        int blackKeyIndex = 0;
        for (int i = 0; i < WHITE_KEYS; i++) {
            if (i % 7 != 2 || i % 7 != 6) {
                blackKeys[blackKeyIndex] = new BlackKey(i * 20, 0, 20, 100, blackKey, blackKeyDown);
                blackKeyIndex++;
            }
        }
    }

    public BlackKey[] getBlackKeys() {
        return blackKeys;
    }

    public WhiteKey[] getWhiteKeys() {
        return whiteKeys;
    }

    public static void  main(String[] arg) {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        PianoLayout pianoLayout = new PianoLayout();
    }
}
