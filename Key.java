import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Key extends Audio {
    private static int totalKeys = 48;
    private String keyName;
    private File audioFile;
    private JButton keyButton;
    private boolean keyPressed;


    public Key(String s, JButton b) {
        keyName = s;
        keyButton = b;
        audioFile = new File("AudioFiles/" + keyName + ".mp3");

        keyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playKey();
                System.out.println(keyName);
                PianoLayout.frame.requestFocusInWindow();
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                setKeyPressed(true);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                setKeyPressed(false);
            }
        });
    }

    public String getKey() {
        return keyName;
    }

    public File getFile() {
        return audioFile;
    }

    public JButton getButton() {
        return keyButton;
    }

    public void setKey(String s) {
        keyName = s;
    }

    public void setFile(File f) {
        audioFile = f;
    }

    public void setButton(JButton b) {
        keyButton = b;
    }

    public void setKeyPressed(boolean pressed) {
        keyPressed = pressed;
    }

    public static Key[] keys = new Key[totalKeys];

    public void playKey() {
        String keyName = getKey();
        playSound("AudioFiles/" + keyName + ".mp3");
    } 
}
