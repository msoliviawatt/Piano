public class Key extends SoundEffect {
    private int totalKeys = 48;
    private String keyName;

    public Key(String s) {
        keyName = s;
    }

    public Key[] keys = new Key[totalKeys];

    public void playKey(int index, String key) {
        if (index < totalKeys) {
            playSound("AudioFiles/" + key + ".mp3");
        }
    } 
}
