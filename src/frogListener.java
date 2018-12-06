import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class frogListener implements KeyListener {
    GameFrame theFrame;

    public frogListener(GameFrame f) {
        this.theFrame = f;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (theFrame.posx > 63) {
                theFrame.posx -= 5;
            }
            theFrame.gamePage.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (theFrame.posx < 575) {
                theFrame.posx += 5;
            }
            theFrame.gamePage.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (theFrame.posy > 80) {
                theFrame.posy -= 7;
            }
            theFrame.gamePage.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (theFrame.posy < 581) {
                theFrame.posy += 7;
            }
            theFrame.gamePage.repaint();
        }
    }
    public void keyTyped(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
}
