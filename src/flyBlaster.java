import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class flyBlaster implements MouseListener {
    runGame frame;

    // frog eats flies for breakfast
    public flyBlaster(runGame f) {
        this.frame = f;
    }
    public void mousePressed(MouseEvent e) {
        int[] flyPosLog = new int[this.frame.board.hexagons.flyLog.size()];

        // logging in the positions of the flies
        for (int i = 0; i < this.frame.board.hexagons.flyLog.size(); i ++) {
            flyPosLog[i] = (Integer) this.frame.board.hexagons.flyLog.get(i);
        }

        // setting frog's tongue range
        if ( ( ((e.getX() <= this.frame.board.frog.posx) && (e.getX() >= (this.frame.board.frog.posx-86)))
                ||
                ((e.getX() >= this.frame.board.frog.posx) && (e.getX() <= (this.frame.board.frog.posx+132))) )
                &&
                (((e.getY() <= this.frame.board.frog.posy) && (e.getY() >= (this.frame.board.frog.posy-108))) )
                || ((e.getY() >= this.frame.board.frog.posy) && (e.getY() <= this.frame.board.frog.posy+80))
        ) {

            for (int i = 0; i < flyPosLog.length; i++) {

                // when player clicks on fly (or close to fly)
                // this is so that where the player clicks, the cursor coordinates don't have to be exact
                if ( (( e.getX() >= (this.frame.board.hexagons.flyPosition.get(flyPosLog[i])[0]) ) && ( e.getX() <= (this.frame.board.hexagons.flyPosition.get(flyPosLog[i])[0]+10) )) && (( e.getY() >= (this.frame.board.hexagons.flyPosition.get(flyPosLog[i])[1] ) && ( e.getY() <= (this.frame.board.hexagons.flyPosition.get(flyPosLog[i])[1]+10 ) ) )) ) {
                    this.frame.stats.points += 5;
                    this.frame.board.score.setText("Score: " + this.frame.stats.points); // updating score as player catches flies
                    this.frame.board.repaint();
                }
            }

        }
    }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) { }
}
