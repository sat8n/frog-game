import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class frogListener implements KeyListener {
    runGame frame;

    public frogListener(runGame f) {
        this.frame = f;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (this.frame.board.frog.posy > 105) {
                this.frame.board.frog.posy -= 54;
                this.frame.stats.moves += 1;
            }
            this.frame.board.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (this.frame.board.frog.posy < 456) {
                this.frame.board.frog.posy += 54;
                this.frame.stats.moves += 1;
            }
            this.frame.board.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (this.frame.board.frog.posx > 65 && this.frame.board.frog.posy >= 78) {
                this.frame.board.frog.posx -= 43;
                this.frame.board.frog.posy -= 27;
                this.frame.stats.moves += 1;
            }
            this.frame.board.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (this.frame.board.frog.posx < 581 && this.frame.board.frog.posy >= 78) {
                this.frame.board.frog.posx += 43;
                this.frame.board.frog.posy -= 27;
                this.frame.stats.moves += 1;
            }
            this.frame.board.repaint();
        }
    }
    public void keyTyped(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
}
