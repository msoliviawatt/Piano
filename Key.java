import java.io.File;
import javax.swing.JButton;

public class Key extends Audio {
    private static int totalKeys = 48;
    private String keyName;
    private File audioFile;
    private JButton keyButton;


    public Key(String s, JButton b) {
        keyName = s;
        keyButton = b;
        audioFile = new File("AudioFiles/" + keyName + ".mp3");

        keyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playKey();
                System.out.println(keyName);
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

    public static Key[] keys = new Key[totalKeys];

    public void playKey() {
        String keyName = getKey();
        playSound("AudioFiles/" + keyName + ".mp3");
    } 
}
