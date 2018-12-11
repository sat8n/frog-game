import javax.swing.*;
import java.awt.*;

public class gameBoard extends JPanel {
    Hexagon hexagons;
    Frog frog;
    JLabel score; // so that we can use setText to change the score
    JButton quit;

    public gameBoard() {
        setBackground(new Color(215,234,255));
        setOpaque(true);

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout(20,20));

        quit = new JButton("quit");
        quit.setFont(new Font("Helvetica", Font.BOLD, 15));
        quit.setForeground(Color.black);
        quit.setBackground(Color.white);
        top.add(quit, BorderLayout.CENTER);

        score = new JLabel("Score: 0", SwingConstants.CENTER);
        score.setFont(new Font("Helvetica", Font.BOLD, 18));
        top.add(score, BorderLayout.EAST);

        top.setOpaque(false);
        add(top, BorderLayout.NORTH);

        hexagons = new Hexagon();
        frog = new Frog();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        hexagons.paintComponent(g); // painting the board of hexagons
        frog.paintComponent(g); // painting the frog
    }
}