import java.awt.*;

public class BlackKey {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isPressed;
    private Image blackKey;
    private Image blackKeyDown;

    //constructor
    public BlackKey(int x, int y, int width, int height, Image blackKey, Image blackKeyDown) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.blackKey = blackKey;
        this.blackKeyDown = blackKeyDown;
        this.isPressed = false;
    }
}