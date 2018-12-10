import java.awt.*;

public class Frog extends Shapes {
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
        // frog's tongue
        g.setColor(Color.pink);
        g.fillRect((this.posx+25), (this.posy-10), 5, 13);
        g.fillOval((this.posx+22), (this.posy-19), 10,10);
        // frog's body
        g.setColor(new Color(0,128,64));
        g.fillOval(this.posx, this.posy, this.width, this.height);
        // frog's mouth
        g.setColor(new Color(112,180,44));
        g.fillArc(this.posx, this.posy, this.width, 30, 43,90);
        // frog's weird seedy eyes
        g.setColor(Color.white);
        g.fillOval((this.posx+7), this.posy,14,14);
        g.fillOval((this.posx+35), this.posy,14,14);
        g.setColor(Color.black);
        g.drawOval((this.posx+7), this.posy,14,14);
        g.drawOval((this.posx+35), this.posy,14,14);
        g.fillOval((this.posx+9), this.posy,7,7);
        g.fillOval((this.posx+40), this.posy,7,7);
    }
}
