import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class tongueBlaster implements MouseListener {
    gameBoard board;

    public tongueBlaster(gameBoard b) {
        this.board = b;
    }

    public void mousePressed(MouseEvent e) {
        // we want the frog's tongue to blast out when mouse button is pressed
    }
    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }
}