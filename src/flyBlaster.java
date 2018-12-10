import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class flyBlaster implements MouseListener {
    runGame frame;

    public flyBlaster(runGame f) {
        this.frame = f;
    }
    public void mousePressed(MouseEvent e) {
        int[] flyPosLog = new int[this.frame.board.hexagons.flyLog.size()];
        // we now have the positions of the flies logged
        for (int i = 0; i < this.frame.board.hexagons.flyLog.size(); i ++) {
            flyPosLog[i] = (Integer) this.frame.board.hexagons.flyLog.get(i);
        }

        // player can only click between current hexagon and the 2 side hexagons:
        // left: (e.getX() <= this.frame.screen.frog.posx) && (e.getX() >= (this.frame.screen.frog.posx-86))
        // right: (e.getX() >= this.frame.screen.frog.posx) && (e.getX() <= (this.frame.screen.frog.posx+132))
        // restricting y to only go up: (e.getY() <= this.frame.screen.frog.posy) && (e.getY() >= (this.frame.screen.frog.posy-108))
        if ( ( ((e.getX() <= this.frame.board.frog.posx) && (e.getX() >= (this.frame.board.frog.posx-86))) || ((e.getX() >= this.frame.board.frog.posx) && (e.getX() <= (this.frame.board.frog.posx+132))) ) && ((e.getY() <= this.frame.board.frog.posy) && (e.getY() >= (this.frame.board.frog.posy-108))) ) {

            for (int i = 0; i < flyPosLog.length; i++) {
                // when player clicks on fly
                // player can click 10 pixels to the left of the fly or 10 pixels to the right
                // left:
                // right: ( e.getX() >= (this.frame.screen.board.flyPosition.get(flyPosLog[i])[0]) )
                //        ( e.getX() <= (this.frame.screen.board.flyPosition.get(flyPosLog[i])[0]+10) )
                // and 10 pixels up and down
                // up: ( e.getY() >= (this.frame.screen.board.flyPosition.get(flyPosLog[i])[1] )
                //     ( e.getY() <= (this.frame.screen.board.flyPosition.get(flyPosLog[i])[1]+10 )
                // down:
                if ( (( e.getX() >= (this.frame.board.hexagons.flyPosition.get(flyPosLog[i])[0]) ) && ( e.getX() <= (this.frame.board.hexagons.flyPosition.get(flyPosLog[i])[0]+10) )) && (( e.getY() >= (this.frame.board.hexagons.flyPosition.get(flyPosLog[i])[1] ) && ( e.getY() <= (this.frame.board.hexagons.flyPosition.get(flyPosLog[i])[1]+10 ) ) )) ) {
                    this.frame.board.flyPoints += 5; // player gets 5 points for each fly
                    this.frame.board.score.setText("Score: " + this.frame.board.flyPoints);
                    this.frame.board.repaint();
                }
            }

        }
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) { }
}
