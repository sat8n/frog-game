import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameBoard extends JPanel {
    Board hexagons;
    Frog frog;
    JLabel score; // so that we can use setText to change the score
    JButton quit;

    public gameBoard() {
        setBackground(new Color(215,234,255));
        setOpaque(true);

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout(20,20));

        quit = new JButton("quit");
        quit.setForeground(Color.black);
        quit.setBackground(Color.white);
        top.add(quit, BorderLayout.CENTER);

        score = new JLabel("Score: 0", SwingConstants.CENTER);
        score.setFont(new Font("Arial", Font.BOLD, 18));
        top.add(score, BorderLayout.EAST);

        top.setOpaque(false);
        add(top, BorderLayout.NORTH);

        hexagons = new Board();
        frog = new Frog();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        hexagons.paintComponent(g);
        frog.paintComponent(g);
    }
}

class fromGame implements ActionListener {
    runGame r;

    public fromGame(runGame r) {
        this.r = r;
    }

    public void actionPerformed(ActionEvent e) {
        r.remove(r.highscore);
        r.remove(r.board);
        r.remove(r.instructions);
        r.add(r.startPanel);
        r.revalidate();
        r.repaint();
    }
}