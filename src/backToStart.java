import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class backToStart implements ActionListener {
    runGame r;

    public backToStart(runGame r) {
        this.r = r;
    }

    public void actionPerformed(ActionEvent e) {
        r.remove(r.instructions);
        r.remove(r.board);
        r.remove(r.stats);
        r.remove(r.highscore);

        r.add(r.startPanel);
        r.revalidate();
        r.repaint();
    }
}
