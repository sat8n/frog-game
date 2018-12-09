package Shapes;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    Hexagons board;
    Frog frog;
    JLabel score; // so that we can use setText to change the score

    public Screen() {
        setBackground(new Color(215,234,255));
        setOpaque(true);

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout(20,20));

        JButton quit = new JButton("quit");
        quit.setForeground(Color.black);
        quit.setBackground(Color.white);
        top.add(quit, BorderLayout.CENTER);

        score = new JLabel("Score: 0", SwingConstants.CENTER);
        score.setFont(new Font("Arial", Font.BOLD, 18));
        top.add(score, BorderLayout.EAST);

        top.setOpaque(false);
        add(top, BorderLayout.NORTH);

        board = new Hexagons();
        frog = new Frog();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        board.paintComponent(g);
        frog.paintComponent(g);
    }
}
