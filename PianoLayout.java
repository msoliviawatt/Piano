import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;

public class PianoLayout extends JScrollPane {
    public PianoLayout() {
        initComponents();
    }

    private void initComponents() {
        JLayeredPane layer = new JLayeredPane();
        layer.setSize(1120,150);
        JButton[] keys = new JButton[48];
        int keyIndex = 0, i;

            for(i=0;i<28;i++)
            {
                keys[keyIndex] = createWhiteKey(i);
                layer.add(keys[keyIndex], 0, -1);
                keyIndex+=1;
                if(i%7!=2 && i%7!=6)
                {
                    keys[keyIndex] = createBlackKey(i);
                    layer.add(keys[keyIndex], 1, -1);
                    keyIndex+=1;
                }
            }
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.setViewportView(layer);
        setSize(280, 150);     
        setLocation(110,100);
    }

    ImageIcon bk = new ImageIcon("blackKey.png");
    ImageIcon wk = new ImageIcon("whiteKey.png");

    private JButton createBlackKey(int x) {
        JButton blackKey = new JButton();
        blackKey.setIcon(bk);
        blackKey.setBackground(Color.BLACK);
        blackKey.setOpaque(true);
        return blackKey;
    }

    private JButton createWhiteKey(int x) {
        JButton whiteKey = new JButton();
        whiteKey.setIcon(wk);
        whiteKey.setBackground(Color.WHITE);
        whiteKey.setOpaque(true);
        return whiteKey;
    }
}
