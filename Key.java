import java.io.File;

public class Key extends SoundEffect {
    private int totalKeys = 48;
    private String keyName;
    private File audioFile;


    public Key(String s) {
        keyName = s;
        audioFile = new File("AudioFiles/" + keyName + ".mp3");
    }

    public String getKey() {
        return keyName;
    }

    public File getFile() {
        return audioFile;
    }

    public Key[] keys = new Key[totalKeys];

    public void playKey(int index, String keyName) {
        if (index < totalKeys) {
            playSound("AudioFiles/" + keyName + ".mp3");
        }
    } 
}
