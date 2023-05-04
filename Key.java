import java.io.File;
import javax.swing.JButton;

public class Key extends Audio {
    private int totalKeys = 48;
    private String keyName;
    private File audioFile;
    private JButton keyButton;


    public Key(String s, JButton b) {
        keyName = s;
        keyButton = b;
        audioFile = new File("AudioFiles/" + keyName + ".mp3");
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

    public Key[] keys = new Key[totalKeys];

    public void playKey(int index, String keyName) {
        if (index < totalKeys) {
            playSound("AudioFiles/" + keyName + ".mp3");
        }
    } 
}
