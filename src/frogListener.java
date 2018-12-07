import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

class frogListener implements KeyListener {
    gameBoard board;

    public frogListener(gameBoard b) {
        this.board = b;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (board.posx > 63) {
                //board.posx -= 5;
                board.posx -= 43;
                board.posy -= 26;
                System.out.println("[" + board.posx + ", " + board.posy + "]");
            }
            board.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (board.posx < 575) {
                //board.posx += 5;
                board.posx += 43;
                board.posy -= 26;
            }

            board.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (board.posy > 80) {
                //board.posy -= 7;
                /**
                 * if we want to go up, then we want to look at the y value
                 * we know the x value stays the same, but the y value changes
                 * e.g. [x,510] are all in one column
                 * in order to move forward, we need to get the current position
                 * then compare it to the other y values in frogPosition
                 * it has a maximum y distance of 53
                 */
                int diffY;
                for (int i = 0; i < 114; i++) {
                    if (board.posx == board.frogPosition.get(i)[0]) {
                        diffY = board.posy - board.frogPosition.get(i)[1];
                        if (diffY < 100 && diffY > 0) {
                            board.posy = board.frogPosition.get(i)[1];
                            System.out.println("current pos: " + board.posy);
                        }
                    }
                }
            }
            board.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (board.posy < 563) {
                board.posy += 54;
                System.out.println("current pos: " + board.posy);
            }
            board.repaint();
        }
    }
    public void keyTyped(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
}
