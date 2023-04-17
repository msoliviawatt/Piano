import java.awt.*;
public class WhiteKey {
   private int x;
   private int y;
   private int width;
   private int height;
   private boolean isPressed;
   private Image whiteKey;
   private Image whiteKeyDown;

   //constructor
   public WhiteKey(int x, int y, int width, int height, Image whiteKey, Image whiteKeyDown) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.whiteKey = whiteKey;
      this.whiteKeyDown = whiteKeyDown;
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

   public Image getWhiteKey() {
      return whiteKey;
   }

   public Image getWhiteKeyDown() {
      return whiteKeyDown;
   }

   public void setWhiteKey(Image whiteKey) {
      this.whiteKey = whiteKey;
   }

   public void setWhiteKeyDown(Image whiteKeyDown) {
      this.whiteKeyDown = whiteKeyDown;
   }

   public void draw(Graphics g) {
      if (isPressed) {
         g.drawImage(whiteKeyDown, x, y, width, height, null);
      } else {
         g.drawImage(whiteKey, x, y, width, height, null);
      }
   }

   public void press() {
      isPressed = true;
   }

   public void release() {
      isPressed = false;
   }
}  
 
