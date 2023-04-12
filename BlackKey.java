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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void setPressed(boolean isPressed) {
        this.isPressed = isPressed;
    }

    public Image getBlackKey() {
        return blackKey;
    }

    public Image getBlackKeyDown() {
        return blackKeyDown;
    }

    public void setBlackKey(Image blackKey) {
        this.blackKey = blackKey;
    }

    public void setBlackKeyDown(Image blackKeyDown) {
        this.blackKeyDown = blackKeyDown;
    }

    public void draw(Graphics g) {
        if (isPressed) {
            g.drawImage(blackKeyDown, x, y, width, height, null);
        } else {
            g.drawImage(blackKey, x, y, width, height, null);
        }
    }

    public void press() {
        isPressed = true;
    }

    public void release() {
        isPressed = false;
    }
}