package Shapes;

import javax.swing.*;
import java.awt.*;

public class Interactive extends JPanel {
    Tongue tongue;
    public Interactive() {
        setOpaque(false);

        tongue = new Tongue();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        tongue.paintComponent(g);
    }
}
