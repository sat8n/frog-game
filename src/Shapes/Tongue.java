package Shapes;

import java.awt.*;

public class Tongue extends Frog{
    int cursorX, cursorY;

    public Tongue() {
    }
    public void paintComponent(Graphics g) {
        g.setColor(Color.pink);
        g.drawLine(this.posx+30, this.posy+15, this.cursorX+7, this.cursorY+7);
        g.fillOval(this.cursorX, this.cursorY, 15, 15);
    }
}
