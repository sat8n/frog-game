import javax.swing.*;
import java.awt.*;

public class runGame extends JFrame {
    public runGame() {
        setTitle("Frogger 1705063");
        getContentPane().setBackground(new Color(255,233,137));

        gameBoard panel = new gameBoard();
        add(panel);
        addKeyListener(new frogMover(panel));

        setPreferredSize(new Dimension(700,700));
        setResizable(false);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new runGame();
        //new GameFrame();
    }
}
