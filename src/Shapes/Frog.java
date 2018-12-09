package Shapes;

import java.awt.*;

public class Frog extends Shape {
    int posx, posy;
    final int initialX;
    final int initialY;

    public Frog() {
        this.posx = (((378-323)/2) + 323) - (this.width/2);
        this.posy = (((604-556)/2) + 556) - (this.height/2);
        this.initialX = (((378-323)/2) + 323) - (this.width/2);
        this.initialY = (((604-556)/2) + 556) - (this.height/2);
    }
    public void paintComponent(Graphics g) {
        g.setColor(new Color(0,128,64));
        g.fillOval(this.posx, this.posy, this.width, this.height);
    }
}
