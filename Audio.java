import jaco.mp3.player.MP3Player;
import java.io.File;

public class Audio {
    public static void playSound(String filename) {
        try {
            File file = new File(filename);
            MP3Player mp3Player = new MP3Player(file);
            mp3Player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
