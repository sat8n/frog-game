import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class frogListener implements KeyListener {
    gameBoard board;

    public frogListener(gameBoard b) {
        this.board = b;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (board.posx > 63) {
                board.posx -= 5;
            }
            board.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (board.posx < 575) {
                board.posx += 5;
            }

            board.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (board.posy > 80) {
                board.posy -= 7;
            }
            board.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (board.posy < 581) {
                board.posy += 7;
            }
            board.repaint();
        }
    }
    public void keyTyped(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
}
